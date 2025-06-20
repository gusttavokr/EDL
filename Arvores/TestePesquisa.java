package Arvores;
import Arvores.ArvorePesquisa;
import Arvores.ArvoreB;
import Arvores.PosicaoInvalida;
import Arvores.ArvoreVaziaExcecao;
import Arvores.Node;

public class TestePesquisa{
    public static void main(String[] args){
        ArvorePesquisa arvore = new ArvorePesquisa(50);
        int[] elementos = {30, 70, 40, 60, 20, 80};

        for (int l : elementos){
            arvore.insert(l);
        }

        arvore.nodes().forEachRemaining(no -> System.out.print(no.getElemento() + " "));
        Node no = arvore.busca(30, arvore.root());
        Node no2 = arvore.busca(70, arvore.root());
        Node no3 = arvore.busca(30, arvore.root());


        arvore.remove(no);
        arvore.remove(no2);
        arvore.remove(no3);
    }   
}