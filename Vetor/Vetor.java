package Vetor;

public interface Vetor{
    public int size();
    public boolean isEmpty();

    public Object elemenAtRank(int r) throws VetorInvalidoExcecao; // Retorna o elemento na posição R
    public Object replaceAtRank(int r, Object o) throws VetorInvalidoExcecao; // Substitui o elemento na posição R pelo objeto O, retorna o antigo
    public Object removeAtRank(int r) throws VetorInvalidoExcecao; // Remove o elemento na posição R e o retorna
    public void insertAtRank(int r, Object o) throws VetorInvalidoExcecao; // Insere na posição R o elemento O
}