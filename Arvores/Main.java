package Arvores;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Cria a árvore com a raiz "Raiz"
        ArvoreGenerica arvore = new ArvoreGenerica("Raiz");
        
        // Cria alguns nós filhos e netos manualmente (usando Node diretamente)
        Node raiz = arvore.root();
        
        // Criar filhos da raiz
        Node filho1 = new Node("Filho 1");
        Node filho2 = new Node("Filho 2");
        Node filho3 = new Node("Filho 3");
        
        // Adiciona filhos à raiz
        raiz.adicionarFilho(filho1);
        raiz.adicionarFilho(filho2);
        raiz.adicionarFilho(filho3);
        
        // Cria netos para filho1
        Node neto1 = new Node("Neto 1");
        Node neto2 = new Node("Neto 2");
        filho1.adicionarFilho(neto1);
        filho1.adicionarFilho(neto2);
        
        // Cria neto para filho3
        Node neto3 = new Node("Neto 3");
        filho3.adicionarFilho(neto3);

        // Testa height
        System.out.println("Altura da árvore a partir da raiz: " + arvore.height(raiz));
        System.out.println("Altura da subárvore com raiz em Filho 1: " + arvore.height(filho1));
        System.out.println("Altura da subárvore com raiz em Filho 3: " + arvore.height(filho3));
        System.out.println("Altura da subárvore com raiz em Neto 1: " + arvore.height(neto1));
        
        // Testa depth
        System.out.println("Profundidade de Neto 1: " + arvore.depth(neto1));  // Espera 2
        System.out.println("Profundidade da Raiz: " + arvore.depth(raiz));     // Espera 0

        // Testa replace
        Object antigo = arvore.replace(filho2, "Filho 2 Alterado");
        System.out.println("Elemento substituído em Filho 2: " + antigo);
        System.out.println("Novo elemento de Filho 2: " + filho2.getElemento());

        // Testa iteração dos elementos (preOrder)
        System.out.print("Elementos da árvore em pré-ordem: ");
        Iterator<Object> elementos = arvore.elements();
        while(elementos.hasNext()){
            System.out.print(elementos.next() + " ");
        }
        System.out.println();

        // Testa iteração dos nodes (postOrder)
        System.out.print("Nós da árvore em pós-ordem: ");
        Iterator<Node> nos = arvore.nodes();
        while(nos.hasNext()){
            System.out.print(nos.next().getElemento() + " ");
        }
        System.out.println();
    }
}
