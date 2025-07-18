package FilaPrioridade;

public class TestHeap {
    public static void main(String[] args) {
        heapArray heap = new heapArray(5);
        
        // Inserir itens (chave, objeto)
        heap.insertItem(20, "Vinte");
        heap.insertItem(15, "Quinze");
        heap.insertItem(30, "Trinta");
        heap.insertItem(10, "Dez");
        heap.insertItem(25, "Vinte e cinco");

        // Mostrar tamanho
        // System.out.println("Tamanho do heap: " + heap.size());

        // Mostrar o item mínimo (chave e objeto)
        // Item min = heap.min();
        // System.out.println("Item mínimo -> chave: " + min.key() + ", valor: " + min.value());

        // Imprimir todos os itens do heap (para checar a estrutura)
        System.out.println("Itens no heap (em ordem de array):");
        for (int i = 0; i < heap.size(); i++) {
            Item it = heap.array[i];
            // System.out.println("Índice " + i + ": chave=" + it.key() + ", valor=" + it.value());
            System.out.print(it.key() + ",");
        }

        // heap.printHeapTree(0, 0);
    }
}
