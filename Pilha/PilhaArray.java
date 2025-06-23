package Pilha;

public class PilhaArray implements Pilha{
    public int capacidade;
    public int FC;
    public int t;
    public Object array[];
    
    
    public PilhaArray(int capacidade, int crescimento){
        this.capacidade = capacidade;
        t = -1;
        FC = crescimento;
        if (crescimento <= 0){
            FC = 0;
        }
        array = new Object[capacidade];
    }

    public int size(){
        return t+1;
    }

    public boolean isEmpty(){
        return t==-1;
    }

    public Object top() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        return array[t];
    }
    
    public Object pop() throws PilhaVaziaExcecao{
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        
        return array[t--];
    }

    public void push(Object o){
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        if( size() == capacidade - 1){
            int capacidade2;
            if (FC == 0) {
                capacidade2 = capacidade*2;
            }
            else{
                capacidade2 = capacidade + FC;
            }
            Object[] novo = new Object[capacidade2];
            for (int i =0; i<capacidade; i++){
                novo[i] = array[i];
            } 
            array = novo;
            capacidade = capacidade2;
        }
        array[t+1] = o;
        ++t;
    }
}
