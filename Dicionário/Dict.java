package Dicionário;

import java.util.Iterator;

public interface Dict {
    public int size();
    public boolean isEmpty();


    public void insertItem(int k, Object o);
    public Object findElement(int k);
    public Item removeElement(int k);

    public Iterator<Integer> keys();
    public Iterator<Object> elements();
}
