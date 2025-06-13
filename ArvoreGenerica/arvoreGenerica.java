package ArvoreGenerica;

import java.util.ArrayList;
import java.util.Iterator;

import ArvoreGenerica.Node;

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

    
    public Node root() {
        return this.raiz;
    }
    
    public Node parent(Node n) {
        return n.getPai();
    }
    
    public List<Node> children(Node n) {
        return n.getFilhos().iterator();
    }
    
    public boolean isExternal(Node n) {
        return n.getFilhos().size() == 0;
    }
    
    public void preOrder(Node n, ArrayList<Object> array) {
        elemento = n.getElemento();
        array.add(elemento);
        for (Node w : n.getFilhos()) {
            preOrder(w, array);
        }
    }
    public Iterator<Object> elements() {
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("Essa árvore está vazia");
        } else {
            ArrayList<Object> array = new ArrayList<Object>();
            preOrder(raiz, array);
            return array.iterator();
        }
    }
}