package Deque;

public interface Deque{
    public int size();
    public boolean isEmpty();
    
    public Object first();
    public Object last();

    public Object inserirInicio();
    public void removerInicio(Object o);
    public Object inserirFim();
    public void removerFim(Object o);
}