package FilaPrioridade;

public class heapArray implements filaPrioridade{
    public Item[] array;
    public int ultimo;
    public int capacidade;

    public heapArray(int capacidade){
        this.capacidade = capacidade;
        ultimo = 0;
        array = new Item[capacidade]; 
    }

    public boolean isEmpty(){
        return (ultimo == 0);
    }

    public int size(){
        return ultimo;
    }

    public Item min(){
        if (isEmpty()) {
            throw new EmptyException("Heap vazio");
        }

        return array[0];
    }

    public void insertItem(int k, Object o){

        Item novoItem = new Item(k, o);

        if (size() == this.capacidade) {
            int capacidade2 = capacidade*2;
            Item[] novoArray = new Item[capacidade2];

            for (int i= 0; i < size(); i++){
                novoArray[i] = array[i];
            }

            array = novoArray;
            capacidade = capacidade2;
        }

        array[ultimo] = novoItem;
        ultimo++;

        upHeap(ultimo-1);
    }

    private void upHeap(int i){
        if (i == 0){
            System.out.println("First!!!!!!");
            return;
        }

        int indexPai = (i-1) /2;

        Item pai = array[indexPai];

        System.out.println("Pré up " + array[indexPai].key() + " " + array[i].key());
        
        if (pai.key() > array[i].key()) {
            array[indexPai] = array[i];
            array[i] = pai;
            
            System.out.println("Pós up " + array[indexPai].key() + " " + array[i].key());
            upHeap(indexPai);
        }

    }

    public void printHeapTree(int i, int level) {
        if (i >= ultimo) return; // último é a quantidade de elementos no heap

        // imprime o filho direito primeiro (para ficar "em cima" no console)
        printHeapTree(2 * i + 2, level + 1);

        // imprime o nó atual com indentação conforme nível
        for (int j = 0; j < level; j++) {
            System.out.print("    "); // 4 espaços por nível
        }
        System.out.println(array[i].key() + " (" + array[i].value() + ")");

        // imprime o filho esquerdo depois (fica "embaixo" no console)
        printHeapTree(2 * i + 1, level + 1);
    }

}
