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

    public Node First(){
        if (isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        return array[0];
    }

    public Node Last(){
        if(isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        return array[size()-1];
    }

    public Node before(Node n){
        if (isEmpty()) {
            throw new EmptyListaException("A lista está vazia!");
        }

        if (n==array[0]){
            throw new NoInvalido("Nó inválido");
        }

        for (int i=0; i != size(); i++){
            if (array[i] == n) {
                return array[i-1];
            }
        }
        throw new NoInvalido("Esse nó não existe!");
    }

    public Node after(Node n){
        if (isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }

        if (n == array[size()-1]){
            throw new NoInvalido("Nó inválido!");
        }
        for (int i=0; i != size(); i++){
            if (array[i] == n){
                return array[i+1];
            }
        }
        throw new NoInvalido("Nó inválido");
    }

    public void replaceElement(Node n, Object o){
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

        for (int i=0; i < size(); i++){
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

    public void insertAfter(Node n, Object o){
        if (isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }
        for (int i=0; i < size(); i++){
            if (array[i] == n){
                if (size() == capacidade -1){
                    capacidade2 = capacidade *2;
                    Node[] novoarray = new Node(capacidade2);
                }
                for (int j = 0; i != capacidade2; i++){
                    novoarray[j] = array[j];
                }
                array = novoarray;
            }
            for (int j = size(); j > i; j--){
                array[j] = array[j-1];
            }

            Node novo = new Node(o);
            array[i+1] = novo;
            tamanho++;
            return;
        }

        throw new NoInvalido("Nó inválido!");
    }

    public void insertFirst(Object o){
        if (isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }

        if (size() == capacidade -1){
            capacidade2 = capacidade * 2;
            Node[] novoArray = new Node(capacidade2);

            for (int i=0; i < size(); i++){
                novoArray[i] = array[i];
            }
            array = novo;
        }
        for (int i = size(); i > 0; i--){
            array[i] = array[i-1];
        }
        Node novo = new Node(o);
        array[0] = novo;
        tamanho++;
        return;
    }

    public void insertLast(Object o){
        if (isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }

        if (size() == capacidade -1){
            capacidade2 = capacidade *2;
            Node[] novoArray = new Node(capacidade2);

            for (int i=0; i < size(); i++){
                novoArray[i] = array[i];
            }
            array = novo;
        }
        Node novo = new Node(o);
        array[size()] = novo;
        tamanho++;
        return;
    }

    public void remove(Node n){
        if (isEmpty()){
            throw new EmptyListaException("A lista está vazia!");
        }

        for (int i =0; i != size(); i++){
            if (array[i] == n){
                for (int j = i; j < size() - 1; j++){
                    array[j] = array[j+1];
                }
            }
            tamanho --;
            return;
        }

        throw new NoInvalido("Nó inválido!");
    }
}