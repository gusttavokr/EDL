package Fila;

public class FilaArray implements Fila{
    public int capacidade;
    public int FC;
    public Object[] array;
    public int inicioFila;
    public int fimFila;

    public FilaArray(int capacidade, int crescimento){
        this.capacidade = capacidade;
        FC = crescimento;
        inicioFila = 0;
        fimFila = 0;

        if (capacidade <= 0) {
            FC = 0;
        }

        array = new Object[capacidade];
    }

    public int size(){
        return ((capacidade - inicioFila + fimFila)%capacidade);
    }

    public boolean isEmpty(){
        return inicioFila == fimFila;
    }

    public Object first(){
        if (isEmpty()) {
            throw new FilaVazia("A fila está vazia!");
        }
        return array[inicioFila];
    }

    public void enqueue(Object o){
        if (size() == capacidade - 1) {
            duplicacao();
        }

        array[fimFila] = o;
        fimFila = (fimFila + 1) %capacidade;
    }

    public Object dequeue(){
        if (isEmpty()) {
            throw new FilaVazia("A fila ta vazia!");
        }

        Object removido = array[inicioFila];
        array[inicioFila] = null;
        inicioFila = (inicioFila + 1)%capacidade;
        return removido;
    }

    public void duplicacao(){
        int capacidade2;
        if (FC == 0) {
            capacidade2 = capacidade * 2;
        } else{
            capacidade2 = capacidade + FC;
        }

        Object[] novoArray = new Object[capacidade2];

        for (int i =0; i < size(); i++){
            novoArray[i] = array[(i + inicioFila)%capacidade];
        }

        fimFila = size();
        inicioFila = 0;
        capacidade = capacidade2;
        array = novoArray;
    }

    public void print(){
        for (int i = 0; i < size(); i++){
            System.out.println(array[i]);
        }
    }
}