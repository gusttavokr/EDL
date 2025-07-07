package FilaPrioridade;

public class Item implements Entry{
    public int chave;
    public Object valor;

    public Item(int key, Object value){
        this.chave = key;
        this.valor = value;
    }

    public int key(){
        return chave;
    }

    public Object value(){
        return valor;
    }
}
