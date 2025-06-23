package Arvores;


public class ArvorePesquisa extends ArvoreBinaria {
    public ArvorePesquisa(Object o) {
        super(o);
    }

    public Node busca(Object k, Node v) {
        // System.out.println(k + " " + v.getElemento());
        if ((comparar(v.getElemento(), k)) < 0) {
            if (hasLeft(v)) {
                return busca(k, leftChild(v));
            }
        } else if ((comparar(v.getElemento(), k)) == 0) {
            return v;
        } else {
            if (hasRight(v)){
                return busca(k, rightChild(v));
            }
        }

        return v;
    }

    private int comparar(Object o, Object p) {
        int pInt = converterInt(p);
        int oInt = converterInt(o);

        return Integer.compare(pInt, oInt);
    }

    private int converterInt(Object p) {


        if (p instanceof Integer) {
            return (Integer) p;
        }
        if (p instanceof Float) {
            return Math.round((Float) p);
        }
        if (p instanceof String) {
            return Integer.parseInt((String) p);
        }
        if (p instanceof Boolean) {
            return ((Boolean) p) ? 1 : 0;
        }
        
        return 0;
    }

    public Node insert(Object k) {
        if (isEmpty()) {
            Node no = new Node(k);
            raiz = no;
            tamanho = 1;
            return no;
        }
        
        Node nodePai = busca(k, raiz);
        if (comparar(k, nodePai.getElemento()) == 0) {
            throw new PosicaoInvalida("Esse elemento já existe!");
        }
        Node no = new Node(k);
        no.setPai(nodePai);
        
        if (comparar(nodePai.getElemento(), k) < 0) {
            nodePai.setFilhoEsq(no);
        } else {
            // System.out.println(k + " " + nodePai.getElemento());
            nodePai.setFilhoDir(no);
        }
        
        tamanho++;
        return no;
    }
    
    public Object remove(Node n) {
        if (isEmpty()) {
            throw new ArvoreVaziaExcecao("A árvore está vazia!");
        }
        
        Node pai = n.getPai();
        if (hasLeft(n) && hasRight(n)) {
            Node sucessor = prox(n.getFilhoDir());
            Object element = n.getElemento();
            replace(n, sucessor.getElemento());
            remove(sucessor);
            tamanho--;
            return element;
            
        } else if (!hasLeft(n) && !hasRight(n)) {
            if (isRoot(n)) {
                raiz = null;
                tamanho = 0;
                return n.getElemento();
            }
            
            if (n == pai.getFilhoDir()) {
                pai.setFilhoDir(null);
                tamanho--;
                System.out.println(n.getElemento());
                return n.getElemento();
            } else {
                pai.setFilhoEsq(null);
                tamanho--;
                return n.getElemento();
            }
        } else {

            if (isRoot(n)) {
                if (hasRight(n)) {
                    raiz = n.getFilhoDir();
                    tamanho--;
                    return n.getElemento();
                } else{
                    raiz = n.getFilhoEsq();
                    tamanho--;
                    return n.getElemento();
                }
            }
            if (n.getFilhoDir() != null) { // se o filho for direito
                if (pai.getFilhoDir() == n) {
                    pai.setFilhoDir(n.getFilhoDir());
                    (n.getFilhoDir()).setPai(pai);
                    tamanho--;
                    return n.getElemento();
                } else{
                    pai.setFilhoEsq(n.getFilhoEsq());
                    (n.getFilhoEsq()).setPai(pai);
                    tamanho--;
                    return n.getElemento();
                }
            } else {
                if (pai.getFilhoDir() == n) {
                    pai.setFilhoDir(n.getFilhoEsq());
                    (n.getFilhoEsq()).setPai(pai);
                    tamanho--;
                    return n.getElemento();
                } else{
                    pai.setFilhoEsq(n.getFilhoEsq());
                    (n.getFilhoEsq()).setPai(pai);
                    tamanho--;
                    return n.getElemento();
                }
            }
        }

        // Se ele for o pai
        // Se ele tiver dois filhos
        // Se ele tiver 1 ou nenhum filho
    }

    private Node prox(Node v){

        if (isExternal(v)) {
            return v;
        } else{
            if (hasLeft(v)) {
                return prox(v.getFilhoEsq());
            } else{
                return v;
            }
        }   

    }
}