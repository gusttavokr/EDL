package FilaPrioridade;

public interface filaPrioridade{
    boolean isEmpty();
    int size();

    Item min();
    // Item removeMin();
    void insertItem(int k, Object o);
}