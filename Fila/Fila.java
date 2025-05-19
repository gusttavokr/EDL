public interface Fila{
    public int size();
    public boolean isEmpty();
    public Object first() throws FilaVazia;
    public Object dequeue() throws FilaVazia;
    public void enqueue(Object o);
}