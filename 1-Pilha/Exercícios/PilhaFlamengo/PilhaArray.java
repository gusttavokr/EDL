public class PilhaArray implements Pilha{
    private int capacidade;
    private int t;
    private int FC;
    private Object[] a;

    public PilhaArray (int capacidade, int crescimento){
        this.capacidade = capacidade;
        tV =- 1;
        tP = capacidade;
        FC = crescimento;
        if (crescimento<=0){
            FC = 0;
        }
        a = new Object[capacidade];
    }

    public boolean isEmptyVermelho(){
        return (tV==-1);
    }
    public boolean isEmptyPreto(){
        return (tP==capacidade);
    }

    public int sizeVermelho(){
        return (tV+1);
    }
    public int sizePreto(){
        return (capacidade-tP);
    }
}