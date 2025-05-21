package Pilha;

public interface Pilha{
    public int size();
    public boolean isEmpty();

    public Object top() throws PilhaVaziaExcecao;
    public Object pop() throws PilhaVaziaExcecao;
    public void push(Object o);
}