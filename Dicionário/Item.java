package Dicionário;

public class Item implements Entry{
    private int chave;
    private Object valor;

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