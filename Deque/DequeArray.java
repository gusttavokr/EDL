package Deque;

public class DequeArray implements Deque{
    public Object[] array;
    public int capacidade;
    public int FC;
    public int inicioDeque;
    public int fimDeque;

    public DequeArray(int capacidade, int crescimento){
        this.capacidade = capacidade;
        inicioDeque = 0;
        fimDeque = 0;
        FC = crescimento;

        if (capacidade <= 0){
            FC = 0;
        }

        array = new Object[capacidade];

    }

    public int size(){
        return ((capacidade - inicioDeque + fimDeque) % capacidade);
    }

    public boolean isEmpty(){
        return inicioDeque == fimDeque;
    }

    public Object first(){
        if (isEmpty()) {
            throw new DequeVazioExcecao("O deque está vazio!");
        }
        return array[inicioDeque];
    }

    public Object last(){
        if (isEmpty()) {
            throw new DequeVazioExcecao("O deque está vazio!");
        }

        return array[fimDeque];
    }

    public void inserirInicio(Object o){
        duplicacao();
        array[inicioDeque] = o;
        inicioDeque = (inicioDeque + 1)%capacidade;
    }

    public Object removerInicio(){
        if (isEmpty()) {
            throw new DequeVazioExcecao("O deque está vazio!");
        }
        
        Object removido = array[inicioDeque];
        array[inicioDeque] = null;
        inicioDeque = ((inicioDeque +1)%capacidade);
        return removido;
    }

    public void inserirFim(Object o){
        duplicacao();
        array[fimDeque] = o;
        fimDeque = (fimDeque+1)%capacidade;
    }

    public Object removerFim(){
        if (isEmpty()) {
            throw new DequeVazioExcecao("O deque está vazio!");
        }
        Object removido = array[fimDeque];
        array[fimDeque] = null;
        fimDeque = (fimDeque +1)%capacidade;
        return removido;
    }

    public void duplicacao(){
        int capacidade2;
        if (size() == capacidade - 1) {
            if (FC == 0) {
                capacidade2 = capacidade*2;
            } else{
                capacidade2 = capacidade+FC;
            }

            Object[] novo = new Object[capacidade2];
            for (int i =0; i < size(); i++){
                novo[i] = array[(i + inicioDeque)% capacidade];
            }
            fimDeque = size();
            inicioDeque = 0;
            capacidade = capacidade2;
            array = novo;
        }
    }
}