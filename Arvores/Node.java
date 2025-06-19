package Arvores;

import java.util.List;
import java.util.ArrayList;

public class Node {
    private Object elemento;
    private Node pai;
    private List<Node> filhos;
    private Node filhoEsq;
    private Node filhoDir;

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
        filho.setPai(this.pai);
        filhos.add(filho);
    }

    public void removerFilho(Node filho){
        filhos.remove(filho);
    }

    public Node getFilhoEsq(){
        return filhoEsq;
    }
    public Node getFilhoDir(){
        return filhoDir;
    }

    public void setFilhoEsq(Node n){
        if (n == null) {
            removerFilho(filhoEsq);
        } else{
            adicionarFilho(n);
        }
        filhoEsq = n;
    }
    
    public void setFilhoDir(Node n){
        if (n == null) {
            removerFilho(filhoDir);
        } else{
            adicionarFilho(n);
        }
        filhoDir = n;
    }
}