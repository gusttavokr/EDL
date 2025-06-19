package Arvores;

public interface ArvoreB extends Arvore{
    public Node leftChild(Node n);
    public Node rightChild(Node n);
    public boolean hasLeft(Node n);
    public boolean hasRight(Node n);
}