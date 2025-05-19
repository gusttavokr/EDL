package Node;

public class Node {
    private Object elemento;
    private Node prox;
    private Node anterior;

    public Node (Object o){
        elemento = o;
    }

    public Object getElemento(){
        return elemento;
    }
    
    public Node getAnterior(){
        return anterior;
    }

    public Node getProximo(){
        return prox;
    }
    
    public void setElemento(Object o){
        elemento = o;
    }

    public void setAnterior(Node n){
        anterior = n;
    }

    public void setProximo(Node n){
        prox = n;
    }
}