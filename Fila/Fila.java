package Fila;

public interface Fila {

    public int size();
    public boolean isEmpty();
    public void enqueue(Object o);
    public Object dequeue() throws FilaVazia;
    public Object first() throws FilaVazia;
}