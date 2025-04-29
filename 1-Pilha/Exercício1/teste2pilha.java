/*
 * Created on 01/09/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Robinson
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class teste2pilha {

	public static void main(String[] args) {		
		PilhaArray p1 = new PilhaArray(10, 10);
        PilhaArray p2 = new PilhaArray(10, 10);

        p1.push("A");
        p1.push("B");
        System.out.println("Pilha 1: " + p1);
        
        p2.push("1");
        p2.push("2");
        System.out.println("Pilha 2: " + p2);
        
        p1.adicionaPilha(p2); // Agora p1 tem: A, B, 1, 2
        System.out.println("Pilha 1:" + p1);

	}
}
