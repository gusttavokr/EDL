package Arvores;

public class PosicaoInvalida extends RuntimeException{
    public PosicaoInvalida(String err){
        super(err);
    }
}