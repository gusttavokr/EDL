package Lista;

import Node.Node;

// Versão com sentinelas
public class ListaDuplamenteEncadeada implements Lista{
    private Node inicio;
    private Node fim;
    private int tamanho;

    public ListaDuplamenteEncadeada(){
        inicio = new Node(null);
        fim = new Node(null);
        inicio.setProximo(fim);
        fim.setAnterior(inicio);
        tamanho = 0;
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public boolean isFirst(Node n){
        if(isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }

        return n == inicio.getProximo();
    }

    public boolean isLast(Node n){
        if(isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        
        return n == fim.getAnterior();
    }

    public Node First(){
        if(isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        
        return inicio.getProximo();
    }

    public Node Last(){
        if(isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        
        return fim.getAnterior();
    }

    public Node before(Node p){
        validacaoNo(p);
        return p.getAnterior();
    }

    public Node after(Node p){
        validacaoNo(p);
        return p.getProximo();
    }

    public void replaceElement(Node n, Object o){
        validacaoNo(n);
        validacaoObject(o);

        n.setElemento(o);
    }

    public void swapElements(Node n, Node q){
        validacaoNo(n);
        validacaoNo(q);

        elemento = n.getElemento();
        n.setElemento(q.getElemento());
        q.setElemento(elemento);
    }

    public void insertBefore(Node n, Object o){
        validacaoNo(n);
        validacaoObject(o);

        Node novo = new Node(o);

        novo.setProximo(n);
        novo.setAnterior(n.getAnterior());
        (n.getAnterior()).setProximo(novo);
        n.setAnterior(novo);

        tamanho++;
    }

    public void insertAfter(Node n, Object o){
        validacaoNo(n);
        validacaoObject(o);

        Node novo = new Node(o);

        novo.setAnterior(n);
        novo.setProximo(n.getProximo());
        n.getProximo().setAnterior(novo);
        n.setProximo(novo);

        tamanho++;
    }

    public void insertFirst(Object o){
        validacaoObject(o);

        Node novo = new Node(o);

        novo.setAnterior(inicio);
        novo.setProximo(inicio.getProximo());
        inicio.getProximo().setAnterior(novo);
        inicio.setProximo(novo);

        tamanho++;
    }

    public void insertLast(Object o){
        validacaoObject(o);

        Node novo = new Node(o);

        novo.setProximo(fim);
        novo.setAnterior(fim.getAnterior());
        fim.getAnterior().setProximo(novo);
        fim.setAnterior(novo);

        tamanho++;
    }

    public void remove(Node n){
        validacaoNo(n);

        n.getAnterior().setProximo(n.getProximo());
        n.getProximo().setAnterior(n.getAnterior());

        tamanho--;
    }

    public void validacaoNo(Node n){
        if(isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        
        if (n == inicio || n == fim){
            throw new NoInvalido("O nó é inválido!");
        }

        temp = inicio.getProximo();
        while (temp != fim){
            if (temp == n){
               return;
            }
            temp = temp.getProximo();
        }
        throw new NoInvalido("O nó não existe!");
    }

    public void validacaoObject(Object o){
        if (o == Null){
            throw new ObjectNullException("O objeto não pode ser nulo!");
        }
    }
}