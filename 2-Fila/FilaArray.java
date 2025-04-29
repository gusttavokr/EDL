public class FilaArray implements Fila{
    private int capacidade;
    private int inicio;
    private int fim;
    private Object[] a;

    public FilaArray(int capacidade){
        inicio = -1;
        fim = capacidade+1;

        a = new Object[capacidade];
    }

    public boolean isEmpty(){
        return (inicio==fim);
    }

    public int size(){
        return ((capacidade-inicio+fim)%capacidade);
    }

    
}