public class PilhaArray2 implements Pilha2{
    private int capacidade;
    private int tP;
    private int tV;
    private int FC;
    private Object[] a;

    public PilhaArray2 (int capacidade, int crescimento){
        this.capacidade = capacidade;
        tV = - 1;
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

    public int sizeGeral(){
        return (sizeVermelho() + sizePreto());
    }

    public Object popVermelho() throws PilhaVaziaExcecao{
        if (isEmptyVermelho()){
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia!");
        }
        Object r = a[tV--];
        return r;
    }

    public Object topVermelho() throws PilhaVaziaExcecao{
        if (isEmptyVermelho()){
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia!");
        }
        return a[tV];
    }
    public Object popPreto() throws PilhaVaziaExcecao{
        if (isEmptyPreto()){
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia!");
        }
        Object r = a[tP--];
        return r;
    }

    public Object topPreto() throws PilhaVaziaExcecao{
        if (isEmptyPreto()){
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia!");
        }
        return a[tP];
    }

    public void pushVermelho(Object o){
        if (tV>=capacidade-1){
            if (FC == 0){
                capacidade *= 2;
            }
            else{
                capacidade += FC;
            }
            Object b[] = new Object[capacidade];
            for (int f=0; f < a.length; f++){
                b[f] = a[f];
            }
            a = b;
        }
        a[++tV] = o;
    }

    public void pushPreto(Object o){
        if (tP>=capacidade-1){
            if (FC == 0){
                capacidade *= 2;
            }
            else{
                capacidade += FC;
            }
            Object b[] = new Object[capacidade];
            for (int f=capacidade-1; f > a.length ; f--){
                b[f] = a[f];
            }
            a = b;
        }
        a[--tP] = o;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= tV; i++) {
            sb.append(a[i]);
            if (i < tV) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

