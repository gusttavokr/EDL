package Fila;

public interface Fila {

    public int size();
    public boolean isEmpty();
    public void enqueue(Object o);
    public Object dequeue();
    public Object first();
}