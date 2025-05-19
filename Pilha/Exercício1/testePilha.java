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
public class testePilha {

	public static void main(String[] args) {		
		PilhaArray minhaPilha =new PilhaArray(1,0); // Iniciando a pilha com tamanho 1, incremento
		
		long inicio = System.currentTimeMillis();
		// Inserindo elementos na pilha
		System.out.println("inserindo");
		for(int f=0;f<1000000;f++){
			System.out.println(f);		  
			minhaPilha.push(new Integer(f));
		}
		long fim = System.currentTimeMillis();
		
		long tempo = fim - inicio;
		System.out.println("Tempo de execução:" + tempo);
		

		//System.out.println("retirando");
		//for(int f=0;f<10;f++){
		//	  System.out.print(f);
		//	  System.out.println(" - "+pp.pop());
		//}
	}
}
