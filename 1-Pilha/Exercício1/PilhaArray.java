public class PilhaArray implements Pilha{
    private int capacidade;
    private Object[] a; // O array
    private int t; // O topo
    private int FC; // fator de crescimento (??)

    public PilhaArray (int capacidade, int crescimento){
        this.capacidade = capacidade;
        t =- 1; // O topo sempre será o ultimo
        FC = crescimento;
        if (crescimento<=0){
            FC = 0;
        }
        a = new Object[capacidade];
    }

    public void push(Object o){
        if (t>= capacidade -1){ // Se o topo for maior ou igual a capacidade
            if (FC==0){ // Se o fator de crescimento for igual a zero
                capacidade*=2; // Dobre a capacidade
            }
            else{
                capacidade += FC; // Incremente a capacidade com o fator de crescimento
            }
            Object b[] = new Object[capacidade]; // Cria o array secundario com base na nova capacidade
            for (int f=0; f<a.length; f++){
                b[f] = a[f]; // Passando os elementos para o novo array
            }
            a = b;
        }
        a[++t] = o; // O topo agora é o novo elemento
        
    }

    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()){ // Verifica se a pilha está vazia
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        Object r = a[t--]; // Remove o elemento
        return r; // Retorna o elemento
    }

    public void empty() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        t = -1;
    }

    public boolean isEmpty(){
        return t==-1; // Retorna um bool se tá vazio ou não se o topo for -1
    }

    public int size(){
        return t+1; // Retorna o tamanho do array
    }

    public Object top() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return a[t];
    }

    public void adicionaPilha(Pilha p){
        PilhaArray pilhaAux = new PilhaArray(capacidade, 10);

        while (!p.isEmpty()){
            pilhaAux.push(p.pop());
        }

        while (!pilhaAux.isEmpty()){
            this.push(pilhaAux.pop());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= t; i++) {
            sb.append(a[i]);
            if (i < t) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}