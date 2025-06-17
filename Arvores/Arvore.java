package Arvores;
import java.util.Iterator;

import Arvores.Node;

public interface Arvore {
    public int size();
    public int height(Node n); // A altura 
    public boolean isEmpty();
    public Iterator<Object> elements(); // Elementos armazenados nos nós
    public Iterator<Node> nodes(); // Retorna os nós

    // Acesso
    public Node root();
    public Node parent(Node n);
    public Iterator<Node> children (Node n);

    // Consulta
    public boolean isExternal(Node n); // Nó sem filhos
    public boolean isInternal(Node n); // Nó com pelo menos um filho
    public boolean isRoot(Node n); // Verifica se tem pai, se é o raiz
    public int depth(Node n); // Retorna a quantidade de elementos 

    // Atualização
    public Object replace(Node n, Object o);
}