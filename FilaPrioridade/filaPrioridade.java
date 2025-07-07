package FilaPrioridade;

public interface filaPrioridade{
    public boolean isEmpty();
    public int size();
    public void insert(Object k, Object o);
    public Object removeMin();
    public Object min();
}