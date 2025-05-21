package Pilha2;

public interface Pilha{
    public int size();
    public boolean isEmpty();
    public void push(Object o);
    public Object top() throws PilhaVaziaExcecao;
    public Object pop() throws PilhaVaziaExcecao;
}