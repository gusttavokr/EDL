package ArvoreGenerica;
import java.util.Iterator;

import Node.Node;

public interface ArvoreGenerica {
    public int size();
    public int height(); // A altura 
    public boolean isEmpty();
    public Iterator elements(); //
    public Iterator nos(); 

    // Acesso
    public Node root();
    public Node parent(Node n);
    public ListaDuplamenteEncadeada children (Node n);

    // Consulta
    public boolean isExternal(Node n); // Nó sem filhos
    public boolean isInternal(Node n); // Nó com pelo menos um filho
    public boolean isRoot(Node n); // Verifica se tem pai, se é o raiz
    public int depth(Node n); // Retorna a quantidade de elementos 

    // Atualização
    public Object replace(Node n, Object o);
}