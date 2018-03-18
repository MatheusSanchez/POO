
import java.io.IOException;

public class ex1 {

	public static void main(String[] args) throws IOException {
		
		System.out.print("Digite uma string qualquer: ");
		String s;
		
		s = EntradaTeclado.leString();
		
		int A,E,I,O,U;
		A = 0;
		E = 0;
		I = 0;
		O = 0;
		U = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a'|| (s.charAt(i) == 'A') ){
				A++;
			}else if(s.charAt(i) == 'e' || (s.charAt(i) == 'E') ){
				E++;
			}else if(s.charAt(i) == 'i' || (s.charAt(i) == 'I') ){
				I++;
			}else if(s.charAt(i) == 'o' || (s.charAt(i) == 'O') ){
				O++;
			}else if(s.charAt(i) == 'u' || (s.charAt(i) == 'U') ){
				U++;
			}
		}
		

		System.out.println("Quantidade De 'a' ou 'A' -> "+A);
		System.out.println("Quantidade De 'e' ou 'E' -> "+E);
		System.out.println("Quantidade De 'i' ou 'I' -> "+I);
		System.out.println("Quantidade De 'o' ou 'O'-> "+O);
		System.out.println("Quantidade De 'u' ou 'U'-> "+U);
		System.out.println();
		
		
		
		System.out.println("String em letra maiúscula: " + s.toUpperCase());
		System.out.println();
		
		System.out.print("Agora digite outra string -> ");
		
		
		String s2;
		s2 = EntradaTeclado.leString();
		System.out.println();
		
		s2.toLowerCase();
		
		
		System.out.println("Primeira String: " + s);
		System.out.println("Segunda String: " + s2);
		System.out.println();
		
		if(s.startsWith(s2) && s.endsWith(s2)) { // se uma string começa com a string "s2" e acaba com "s2"

			System.out.println("Suas strings são iguais no começo e no fim :0 ");
		}else if(s.startsWith(s2)) {
			System.out.println("Suas strings são iguais no começo :) ");
		}else if(s.endsWith(s2)) {
			System.out.println("Suas strings são iguais no fim :) ");
		}else {
			System.out.println("Suas strings não são nada parecidas :( ");
		}
		
		 
	}

}
