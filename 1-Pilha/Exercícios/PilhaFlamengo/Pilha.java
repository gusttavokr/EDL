public interface Pilha{
    public boolean isEmptyVermelho();
    public int sizeVermelho();
    public Object popVermelho() throws PilhaVaziaExcecao;
    public Object topVermelho() throws PilhaVaziaExcecao;
    public void pushVermelho(Object o);

    public boolean isEmptyPreto();
    public int sizePreto();
    public Object popPreto() throws PilhaVaziaExcecao;
    public Object topPreto() throws PilhaVaziaExcecao;
    public void pushPreto(Object o);

    public int sizeGeral();
}