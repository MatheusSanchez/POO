package cliente_bozo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {

	public static void main(String[] args) throws IOException {
		
		Socket cliente = new Socket("127.0.0.1",9669);	
		System.out.println("Conectamos com o servidor");	
		
		PrintStream saida = new  PrintStream(cliente.getOutputStream());
		Scanner teclado = new Scanner(System.in);
		Scanner server = new  Scanner(cliente.getInputStream());
		
		saida.println("I 9081453");
		System.out.println(server.nextLine());// mensagens de boas vindas
	
	
		
		
		for (int i = 1; i <= 11; i++) {
			saida.println("R"+i); // joga os dados	
			//System.out.println(server.nextLine()); // printa os dados
			saida.println("T 0 0 0 0 0"); // alteracao
			//System.out.println(server.nextLine());
			saida.println("T 0 0 0 0 0");
			//System.out.println(server.nextLine());
			saida.println("P"+i+" "+ i); // coloca no placar
			//System.out.println("Pontuação corrente " + server.nextLine());
		}
		//System.out.println("Pontuação corrente " + server.nextLine());
		saida.print("F");
		System.out.println("Pontuação final " + server.nextLine());
	}

}
