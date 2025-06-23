package Sequência;

import Node.Node;

public class SequenciaDupla implements Sequencia{
    private Node NoInicio;
    private Node NoFim;
    public int tamanho;

    public SequenciaDupla(){
        tamanho = 0;
        NoInicio = new Node(null);
        NoFim = new Node(null);

        NoInicio.setProximo(NoFim);
        NoFim.setAnterior(NoInicio);
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public void insertAtRank(int r, Object o){

        if (r < 0 || r > tamanho) {
            throw new SequenciaInvalida("Rank inválido!"); 
        }

        Node temp = NoInicio;

        for (int i = 0; i < r; i++){
            temp = temp.getProximo();
        }

        Node novo = new Node(o);
        novo.setAnterior(temp);
        novo.setProximo(temp.getProximo());
        temp.getProximo().setAnterior(novo);
        temp.setProximo(novo);
        
        tamanho++;
    }

    public Object elementAtRank(int r){
        if (isEmpty()) {
            throw new SequenciaInvalida("A lista está vazia");
        }

        Node temp = NoInicio;

        for(int i = 0; i <= r; i++){
            temp = temp.getProximo();
        }

        Object elemento = temp.getProximo().getElemento();

        return elemento;
    }

    public Object replaceAtRank(int r, Object o){
        validacao(r);

        Node temp = NoInicio.getProximo();

        for (int i = 0; i < r; i++){
            temp = temp.getProximo();
        }

        Object antigo = temp.getProximo();
        temp.getProximo().setElemento(o);

        return antigo;
    }

    public Object removeAtRank(int r){
        validacao(r);

        Node temp = NoInicio.getProximo();

        for (int i = 0; i < r; i++){
            temp = temp.getProximo();
        }

        Object antigo = temp.getProximo();

        temp.getAnterior().setProximo(temp.getProximo());
        temp.getProximo().setAnterior(temp.getAnterior());

        return antigo;
    }

    public Node atRank(int r){
        validacao(r);

        Node temp = NoInicio.getProximo();

        for (int i = 0; i < r; i++){
            temp = temp.getProximo();
        }

        return temp.getProximo();
    }

    public int rankOf(Node n){
        Node temp = NoInicio.getProximo();

        for (int i = 0; temp != NoFim; i++){
            if (temp == n) {
                return i;
            } 
            temp = temp.getProximo();
        }

        throw new SequenciaInvalida("Esse nó não existe!"); 
    }

    public Node first(){
        return NoInicio.getProximo();
    }

    public Node last(){
        return NoFim.getAnterior();
    }

    public void replaceElement(Node n, Object o){
        ObjectNoNull(n);
        n.setElemento(o);
    }

    public void swapElements(Node n, Node q){
        ObjectNoNull(n);
        ObjectNoNull(q);
        
        Object antigo = n.getElemento();
        n.setElemento(q.getElemento());
        q.setElemento(antigo);
    }

    public void insertBefore(Node n, Object o){
        ObjectNoNull(n);

        Node novo = new Node(o);
        novo.setAnterior(n.getAnterior());
        novo.setProximo(n);

        n.getAnterior().setProximo(novo);
        n.setAnterior(novo);   
        tamanho++;    
    }

    public void insertAfter(Node n, Object o){
        ObjectNoNull(n);

        Node novo = new Node(o);

        novo.setProximo(n.getProximo());
        novo.setAnterior(n);
        n.getProximo().setAnterior(novo);
        n.setProximo(novo);

        tamanho++;
    }

    public void insertFirst(Object o){

        Node novo = new Node(o);
        novo.setAnterior(NoInicio);
        novo.setProximo(NoInicio.getProximo());
        NoInicio.getProximo().setAnterior(novo);
        NoInicio.setProximo(novo);
        tamanho++;
    }

    public void insertLast(Object o){

        Node novo = new Node(o);

        novo.setProximo(NoFim);
        novo.setAnterior(NoFim.getAnterior());
        NoFim.getAnterior().setProximo(novo);
        NoFim.setAnterior(novo);
        tamanho++;
    }

    public void remove(Node n){
        ObjectNoNull(n);

        n.getAnterior().setProximo(n.getProximo());
        n.getProximo().setAnterior(n.getAnterior());
        tamanho--;
    }

    public void validacao(int r){
        if (isEmpty()) {
            throw new SequenciaInvalida("A lista está vazia");
        }
        if (r < 0 || r > tamanho) {
            throw new SequenciaInvalida("Rank inválido!"); 
        }
    }

    public void ObjectNoNull(Node n){
        if (n == null) {
            throw new SequenciaInvalida("Nó não pode ser null!");
        }
    }
}