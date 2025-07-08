package FilaPrioridade;
import java.util.Iterator;

public interface dicionario {
    public Object findElement(int k);
    public void insertItem(int k, Object o);
    public Object removeElement(int k);
    public int size();
    public boolean isEmpty();

    public Iterator<Integer> keys(); // Todas as chaves
    public Iterator<Object> elements(); // Todos os elementos
}


// Busca Binária
// Pega a metade, comparo o elemento que eu procuro com a metade. Se for menor que a metade, metade da lista já some
// Buscar (4) em [1,2,3,4,5,6,7,8,9,10]
// "Pós busca" [1,2,3,4,5]
// Inicia recursão Recursão


// Colisão
// Ao colidir, criar uma lista encadeada que armazena as colisões