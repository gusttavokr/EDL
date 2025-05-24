package Vetor;

public class VetorArray implements Vetor{
    public Object[] array;
    public int capacidade;
    public int finalVetor;

    public VetorArray(int capacidade){
        this.capacidade = capacidade;
        finalVetor = 0;
        array = new Object[capacidade];
    }

    public int size(){
        return finalVetor;
    }

    public boolean isEmpty(){
        return finalVetor == -1;
    }

    public Object elemenAtRank(int r){
        validacao(r);
        
        Object elemento = array[r];
        return elemento;
    }

    public Object replaceElement(int r, Object o){
        validacao(r);

        Object antigo = array[r];
        array[r] = o;
        return antigo;
    }

    public Object removeAtRank(int r){
        validacao(r);

        Object removido = array[r];
        for (int i = r; i < (finalVetor -1) ; i++){
            array[i] = array[i+1];
        }
        finalVetor--;
        array[finalVetor] = null;

        return removido;
    }

    

    public void validacao(int r){
        if (isEmpty()) {
            throw new VetorInvalidoExcecao("Vetor vazio yeah!");
        }

        if (r < 0 || r > (size()-1)) {
            throw new VetorNullExcecao("O elemento não existe nesse rank");
        }
    }
}