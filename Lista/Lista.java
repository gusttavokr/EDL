package Lista;

import Node.Node;

public interface Lista{
    public int size();
    public boolean isEmpty();

    // Métodos de Fila
    public boolean isFirst(Node n) throws EmptyListaException;
    public boolean isLast(Node n) throws EmptyListaException;

    // Métodos de acesso
    public Node first() throws EmptyListaException;
    public Node last() throws EmptyListaException;
    public Node before(Node p);
    public Node after(Node p);

    // Métodos de atualizar
    public void replaceElement(Node n, Object o) throws EmptyListaException, NoInvalido, ObjectNullException; // Atualize nó N com elemento Q
    public void swapElements(Node n, Node q) throws EmptyListaException, NoInvalido; // Troque nó N pelo nó q
    public void insertBefore(Node n, Object o) throws EmptyListaException, NoInvalido, ObjectNullException; // Insira o elemento no anterior do nó N
    public void insertAfter(Node n, Object o) throws EmptyListaException, NoInvalido, ObjectNullException;  // Insira o elemento no próximo do nó N
    public void insertFirst(Object o) throws ObjectNullException; // Insere o elemento no primeiro
    public void insertLast(Object o) throws ObjectNullException; // Insere o elemento no último
    public void remove(Node n) throws EmptyListaException, NoInvalido; // Removendo um nó
}