package Arvores;

public class TestePesquisa{
    public static void main(String[] args){
        ArvorePesquisa arvore = new ArvorePesquisa(50);
        int[] elementos = {30, 70, 40, 20, 60, 80};

        for (int l : elementos){
            arvore.insert(l);
        }

        arvore.nodes().forEachRemaining(no -> System.out.print(no.getElemento() + " "));
        Node no = arvore.busca(80, arvore.root());
        arvore.remove(no);
        
        System.out.println();
        arvore.nodes().forEachRemaining(nno -> System.out.print(nno.getElemento() + " "));
        
        Node no2 = arvore.busca(70, arvore.root());
        arvore.remove(no2);
        
        System.out.println();
        arvore.nodes().forEachRemaining(nnno -> System.out.print(nnno.getElemento() + " "));
        
        Node no3 = arvore.busca(50, arvore.root());
        arvore.remove(no3);
        
        System.out.println();
        arvore.nodes().forEachRemaining(nnnno -> System.out.print(nnnno.getElemento() + " "));

    }   
}