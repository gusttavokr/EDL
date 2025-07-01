package Arvores.FilaPrioridade;

public class Item implements ItemInterface{
    public Object chave;
    public Object valor;

    public Item(Object key, Object value){
        this.chave = key;
        this.valor = value;
    }

    public Object key(){
        return chave;
    }

    public Object value(){
        return valor;
    }
}
