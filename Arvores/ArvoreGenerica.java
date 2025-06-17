package Arvores;

import java.util.ArrayList;
import java.util.Iterator;

import Arvores.Node;

public class ArvoreGenerica implements Arvore {
    public int tamanho;
    public Node raiz;

    public ArvoreGenerica(Object o) {
        this.raiz = new Node(o);
        this.tamanho = 1;
    }

    public int size() {
        return tamanho;
    }

    public int height(Node n) {
        if (isExternal(n)) {
            return 0;
        } else {
            int h = 0;
            for (Node w : n.getFilhos()) {
                h = Math.max(h, height(w));
            }
            return h + 1;
        }
    }

    public boolean isEmpty() {
        return (tamanho == 0);
    }
    
    public void preOrder(Node n, ArrayList<Object> array) {
        Object elemento = n.getElemento();
        array.add(elemento);
        for (Node w : n.getFilhos()) {
            preOrder(w, array);
        }
    }
       
    public Node root() {
        return this.raiz;
    }
    
    public Node parent(Node n) {
        return n.getPai();
    }
    
    public Iterator<Node> children(Node n) {
        return n.getFilhos().iterator();
    }
    
    public Iterator<Object> elements() {
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("Essa árvore está vazia");
        } else {
            ArrayList<Object> array = new ArrayList<>();
            preOrder(raiz, array);
            return array.iterator();
        }
    }
    
    public void postOrder(Node n, ArrayList<Node> array) {
        for (Node w : n.getFilhos()) {
            postOrder(w, array);
        }
        array.add(n);
    }
    
    public Iterator<Node> nodes(){
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("Essa árvore está vazia");
        } else {
            ArrayList<Node> array = new ArrayList<>();
            postOrder(raiz, array);
            return array.iterator();
        }
    }

    public boolean isExternal(Node n) {
        return n.getFilhos().size() == 0;
    }

    public boolean isInternal(Node n){
        return n.getFilhos().size() >= 1 ;
    }

    public boolean isRoot(Node n){
        return n == raiz;
    }

    public int depth(Node n){
        if ((isRoot(n)) || (n.getPai() == null)){
            return 0;
        } else{
            return 1 + depth(parent(n));
        }
    }

    public Object replace(Node n, Object o){
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("A árvore está vazia");
        }
        Object temp = n.getElemento();
        n.setElemento(o);
        return temp;
    }
}