package Lista;

import Node.Node;

public class ListaArray implements Lista{
    private Node[] array;
    private int capacidade;
    private int tamanho;

    public ListaArray(int capacidade){
        tamanho = 0;
        this.capacidade = capacidade;
        array = new Node[capacidade];
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public boolean isFirst(Node n){
        if (isEmpty()) {
            throw new EmptyListaException("A lista está vazia!");
        }
        return array[0] == n;
    }

    public boolean isLast(Node n){
        if (isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        return array[size() - 1] == n;
    }

    public Object First(){
        if (isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        return array[0];
    }

    public Object Last(){
        if(isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        return array[size()-1];
    }

    public void replaceElements(Node n, Object o){
        if (isEmpty()) {
            throw new EmptyListaException("A lista está vazia!");
        }

        for (i=0; i<size(); i++){ // Percorra a lista
            if (array[i] == n){ // Se o i for igual ao nó que vc quer
                n.setElemento(o); // o novo elemento será aplicado
            }
        }
    }

    public void swapElements(Node n, Node q){
        if (isEmpty()) {
            throw new EmptyListaException("A lista está vazia!");
        }

        Node velha = null;
        Node nova = null;

        for (int i=0; i != size(); i++){
            if (array[i] == n){
                nova = n;
            } else if (array[i] == q) {
                velha = q;
            }
        }

        if (nova == null && velha == null){
            throw new NoInvalido("O nó não existe!");
        } 
        
        n.setElemento(velha.getElemento());
        q.setElemento(nova.getElemento());
    }


    public void insertBefore(Node n, Object o){
        if (isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }


        for (int i=0; i != size(); i++){
            if (array[i] == n){
                if (size() == capacidade -1){
                    capacidade2 = capacidade*2;
                    Node[] novoArray = new Node[capacidade2];

                    for(int j=0; j < capacidade2; j++){
                        novoArray[j] = array[j];
                    }
                    array = novoArray;
                }
                for (int j = size(); j > i; j--){
                    array[j] = array[j-1];
                }

                Node node = new Node(o);
                array[i] = node;
                tamanho++;
                return;
            }
        }

        
        throw new NoInvalido("O nó inválido!");
    }
}