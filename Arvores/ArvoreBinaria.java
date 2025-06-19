package Arvores;

import Arvores.Node;

public class ArvoreBinaria extends ArvoreBinariaGenerica{
    
    public ArvoreBinaria(Object o){
        super(o);
    }

    //insertLeft
    //insertRight
    //print
    //remove
    // insertRoot

    public Node insertLeft(Node p, Object o){
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("Não pode inserir filho esquerdo em árvore vazia!");
        }
        if (p.getFilhoEsq() == null) {
            Node filhoE = new Node(o);
            p.setFilhoEsq(filhoE);
            filhoE.setPai(p);
            tamanho++;
            return filhoE;
        } else{
            throw new PosicaoInvalida("Ele já tem filho esquerdo!");
        }
    }

    public Node insertRight(Node p, Object o){
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("Não pode inserir filho direito em árvore vazia!");
        }
        if (p.getFilhoDir() == null) {
            Node filhoD = new Node(o);
            p.setFilhoDir(filhoD);
            filhoD.setPai(p);
            tamanho++;
            return filhoD;
        } else{
            throw new PosicaoInvalida("Ele já tem filho direito!");
        }
    }

    public Node insertRoot(Object o){
        if (isEmpty()) {
            Node r = new Node(o);
            raiz = r;
            tamanho = 1;
            return raiz;
        } else{
            throw new PosicaoInvalida("A árvore já tem uma raiz");
        }
    }

    // Tentar depois remover nós com filhos
    public Object remove2(Node n){
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("A árvore está vazia!");
        }
        Node esq = n.getFilhoEsq();
        Node dir = n.getFilhoDir();

        if (esq != null && dir != null) {
            // porra games
        } 

        Node filho;
        if (esq != null) {
            filho = esq;
        } else if (dir != null){
            filho = dir;
        } else{
            filho = null;
        }

        // Se for raiz
        if (n == raiz) {
            raiz = filho;
            if (filho != null) {
                filho.setPai(null);
            }
        } else{
            Node pai = n.getPai();

            if (n == pai.getFilhoEsq()) {
                pai.setFilhoEsq(filho);
            } else{
                pai.setFilhoDir(filho);
            }

            if (filho != null) {
                filho.setPai(pai);
            }
        }
        tamanho--;
        return n.getElemento();
    }

    public void inOrder(Node n, String[][] matriz, int colunaAtual[]){
        // Esquerda -> Visita -> Direita

        if (hasLeft(n)) {
            inOrder(n.getFilhoEsq(), matriz, colunaAtual);
        }

        int linha = depth(n);
        int coluna = colunaAtual[0]++;
        matriz[linha][coluna] = n.getElemento().toString();

        if (hasRight(n)) {
            inOrder(n.getFilhoDir(), matriz, colunaAtual);
        }
    }

    public void print(){
        int linhas = height(raiz) + 1;
        int colunas = size();
        String[][] matriz = new String[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = " ";
            }
        }

        int colunaAtual[] = new int[1];
        colunaAtual[0] = 0;

        inOrder(raiz, matriz, colunaAtual);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }
    }
}