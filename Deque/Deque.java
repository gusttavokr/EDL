package Deque;

public interface Deque{
    public int size();
    public boolean isEmpty();
    
    public Object first();
    public Object last();

    public void inserirInicio(Object o);
    public Object removerInicio() throws DequeVazioExcecao;
    public void inserirFim(Object o);
    public Object removerFim() throws DequeVazioExcecao;
}