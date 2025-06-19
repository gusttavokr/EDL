package Arvores;
import Arvores.ArvoreB;
import Arvores.PosicaoInvalida;
import Arvores.ArvoreVaziaExcecao;
import Arvores.Node;

public class Teste {
    public static void main(String[] args) {
        try {
            // Instanciando a árvore
            ArvoreBinaria arvore = new ArvoreBinaria("A");

            // Teste 1
            Node raiz = arvore.root();
            System.out.println("Raiz: " + raiz.getElemento()); // Esperado: A

            // Teste: inserir filhos
            Node b = arvore.insertLeft(raiz, "B");
            Node c = arvore.insertRight(raiz, "C");
            
            Node d = arvore.insertLeft(b, "D");
            Node e = arvore.insertRight(b, "E");
            
            Node f = arvore.insertRight(c, "F");

            arvore.children(raiz).forEachRemaining(no -> System.out.print(no.getElemento() + " "));
            
            // // Teste de altura e profundidade
            // System.out.println("Altura da árvore: " + arvore.height(raiz)); // Esperado: 2
            // System.out.println("Profundidade de E: " + arvore.depth(e)); // Esperado: 2

            // // Teste de substituição
            // Object antigo = arvore.replace(f, "F-novo");
            // System.out.println("Elemento antigo em F: " + antigo); // Esperado: F
            // System.out.println("Novo elemento em F: " + f.getElemento()); // Esperado: F-novo

            // // Teste de iteração
            // System.out.println("\nElementos (preOrder):");
            // arvore.elements().forEachRemaining(System.out::println);

            // System.out.println("\nNós (in-order):");
            // arvore.nodes().forEachRemaining(no -> System.out.print(no.getElemento() + " "));
            // System.out.println();

            // // Impressão hierárquica
            // System.out.println("\nImpressão da árvore:");
            // arvore.print();

            // // Teste de remoção
            // System.out.println("\nRemovendo folha D...");
            // arvore.remove2(d);
            // System.out.println("Nova altura da árvore: " + arvore.height(raiz));
            // arvore.print();

            // Teste de exceções:
            System.out.println("\nTestes de exceções:");
            // arvore.remove2(raiz);
            // // arvore.print();

            // arvore.insertRoot("j");
            // arvore.print();



        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}