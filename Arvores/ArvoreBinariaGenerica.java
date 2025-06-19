package Arvores;

import Arvores.Node;

public class ArvoreBinariaGenerica extends ArvoreGenerica implements ArvoreB{

    public ArvoreBinariaGenerica(Object o){ // Construtor
        super(o);
    }

    public boolean hasLeft(Node n){
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("Essa árvore está vazia!");
        } else {
            return (n.getFilhoEsq() != null);
        }
    }
    public boolean hasRight(Node n){
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("Essa árvore está vazia!");
        } else {
            return (n.getFilhoDir() != null);
        }
    }

    public Node rightChild(Node n){
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("Essa árvore está vazia!");
        } else{
            return (n.getFilhoDir());
        }
    }

    public Node leftChild(Node n){
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("Essa árvore está vazia!");
        } else{
            return (n.getFilhoEsq());
        }
    }
}