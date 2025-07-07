package FilaPrioridade;

public class heapArray implements filaPrioridade{
    private Item[] array;
    private int ultimo;
    private int capacidade;

    public heapArray(int capacidade){
        this.capacidade = capacidade;
        ultimo = 0;
        array = new Object[capacidade]; 
    }

    public boolean isEmpty(){
        return (ultimo == 0);
    }

    public int size(){
        return ultimo;
    }

    public void insert(int k, Object o){

        // if (isEmpty()) {

        // } else{
        //     Item item = new Item(k, o);
        //     chaveExistente(k, capacidade);
        //     array[k] = item;
        // }
    }

    // public void chaveExistente(int k, int capacidade){
    //     if (capacidade < k){
    //         capacidade = capacidade*2;
    //         chaveExistente(k, capacidade);
    //     }
    // }


    // public void aumentaTamanho(int k){
    //     int capacidade2 = capacidade* 2
    // }
    // public Object min(){
    //     if (isEmpty()) {
            
    //     } else{
    //         Object menor = new Object();

    //         for (int i = 0; i < size(); i++){

    //         }
    //     }
    // }
}
