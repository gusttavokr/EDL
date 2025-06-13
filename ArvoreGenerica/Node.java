package Node;

import java.util.List;
import java.util.ArrayList;

public class Node {
    private Object elemento;
    private Node pai;
    private List<Node> filhos;

    public Node (Object o){
        this.elemento = o;
        this.filhos = new ArrayList<>();
    }

    public Object getElemento(){
        return elemento;
    }
    
    public void setElemento(Object o){
        elemento = o;
    }

    public Node getPai(){
        return pai;
    }
    public void setPai(Node pai){
        this.pai = pai;
    }

    public List<Node> getFilhos(){
        return filhos;
    }

    public void adicionarFilho(Node filho){
        filho.setPai(this);
        filhos.add(filho);
    }

    public void removerFilho(Node filho){
        filhos.remove(filho);
    }
}