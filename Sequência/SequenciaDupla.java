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

        Object elemento = temp.getElemento(temp.getProximo());

        return elemento;
    }

    public Object replaceAtRank(int r, Object o){
        validacao();

        Node temp = NoInicio.getProximo();

        for (int i = 0; i < r; i++){
            temp = temp.getProximo();
        }

        Object antigo = temp.getProximo();
        temp.getProximo().setElemento(o);

        return antigo;
    }

    public Object removeAtRank(int r){
        validacao();

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
        validacao();

        Node temp = NoInicio.getProximo();

        for (int i = 0; i < r; i++){
            temp = temp.getProximo();
        }

        return temp.getProximo();
    }

    public int rankOf(Node n){
        validacao();
    }

    public void validacao(){
        if (isEmpty()) {
            throw new SequenciaInvalida("A lista está vazia");
        }
        if (r < 0 || r > tamanho) {
            throw new SequenciaInvalida("Rank inválido!"); 
        }
    }
}