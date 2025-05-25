package Sequência;

import Node.Node;

public interface Sequencia{
    public int size();
    public boolean isEmpty();

    public void insertAtRank(int r, Object o);
    public Object elementAtRank(int r); 
    public Object replaceAtRank(int r, Object o); 
    public Object removeAtRank(int r);

    // Método ponte
    public Node atRank(int r); // Retorna o nó do rank
    public int rankOf(Node n); // Retorna o rank do nó

    // Lista
    public Node first();
    public Node last();
    public void replaceElement(Node n, Object o);
    public void swapElements(Node n, Node q);
    public void insertBefore(Node n, Object o);
    public void insertAfter(Node n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public void remove(Node n);
}