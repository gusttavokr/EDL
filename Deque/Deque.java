package Deque;

public interface Deque{
    public int size();
    public boolean isEmpty();
    
    public Object first();
    public Object last();

    public void inserirInicio(Object o);
    public Object removerInicio();
    public void inserirFim(Object o);
    public Object removerFim();
}