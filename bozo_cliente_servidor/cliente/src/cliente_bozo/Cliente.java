package cliente_bozo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;



public class Cliente {
	
	static boolean ocupado[] = new boolean[11];
	
	static int countChar(String dados, int c) {
		
		int count  = 0;
		
			for (int i = 0; i < dados.length(); i+=2) {
				if(Character.getNumericValue(dados.charAt(i)) == c) {
					count++;
				}
			}
				
		return count;
		
	}

	public static int calculaMaior(String DadosServer) {
		
		System.out.println("Recebido -> " + DadosServer);
		int tabuleiro[] = new int[11];
		//int i = 0;	
		
		for(int i = 1;i <= 6; i++) {
			tabuleiro[i] = countChar(DadosServer,i) * i;	
			//System.out.println("Posicao: " +i + " fez " +tabuleiro[i]+ " Pontos");
		}
		
		//contar quina
		for(int i = 1;i <= 6; i++) {
			int aux = countChar(DadosServer,i);
			if(aux == 0){
				continue;
			}else if(aux == 5){
				tabuleiro[10] = 40;
			}else if(aux < 5){
				tabuleiro[10] = 0;
				break;
			}
		}
		
		//contar quadra
		for(int i = 1;i <= 6; i++) {
			int aux = countChar(DadosServer,i);
			if(aux == 1 || aux == 0){
				continue;
			}else if(aux >= 4){
				tabuleiro[9] = 30;
			}else if(aux < 4){
				tabuleiro[9] = 0;
				break;
			}
		}		
		
		//sequencia
		
		
		for(int i = 1;i <= 5; i++) {
			if(countChar(DadosServer,i) == 1) {
				
				tabuleiro[8] = 20; 
			}else {
				
				tabuleiro[8] = 0;
				break;
			}
		}
		if(tabuleiro[8] == 0) {
			for(int i = 2; i <= 6; i++) {
				if(countChar(DadosServer,i) == 1) {
					
					tabuleiro[8] = 20; 
				}else {
					
					tabuleiro[8] = 0;
					break;
				}
			}
		}
		
		
		//contar full hand
		
		int count[] = new int [7];
		for(int i = 1;i <= 6; i++) {
			count[i] = countChar(DadosServer,i);
		}
		
		boolean flag = false;
		for(int i = 1;i <= 6; i++) {
			if(count[i] == 3) {
				flag = true;
				break;
			}
		}	
		
		boolean flag2 = false;
		for(int i = 1; (flag || flag2) && i <= 6; i++) {
			if(count[i] == 2) {
				flag2 = true;
				break;
			}
		}
		
		if(flag2 && flag) {
			tabuleiro[7] = 15;
		}else {
			tabuleiro[7] = 0;
		}
		
		/*for(int i = 1;i <= 6; i++) {
			tabuleiro[i] = countChar(DadosServer,i) * i;	
			System.out.println("Posicao: " +i + " fez " +tabuleiro[i]+ " Pontos");
		}
		System.out.println("Full Hand: " +tabuleiro[7]);
		System.out.println("Sequencia: " +tabuleiro[8]);
		System.out.println("Quadra: " +tabuleiro[9]);
		System.out.println("Quina: " +tabuleiro[10]);*/
		
		for(int i = 10;i <= 7; i--) {
			if(tabuleiro[i] != 0){
					ocupado[i] = true;
					return i;
			}
		}
		
		for(int i = 1;i <= 6; i++) {
			int maior = i;
			count[i] = maior;
			for(int j = i; j<= 6 ;j++) {
				if(tabuleiro[j] > tabuleiro[maior]){
					count[i] = j;
					maior = j;
				}
			}	
		}
		
		for(int i = 1;i <= 6; i++) {
			System.out.println("count point " + count[i]);
		}
		
		return 0;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		System.out.println("Ola mundo");
		Socket cliente = new Socket("127.0.0.1",9669);	
		System.out.println("Conectamos com o servidor");	
		
		PrintStream saida = new  PrintStream(cliente.getOutputStream());
		Scanner teclado = new Scanner(System.in);
		Scanner server = new  Scanner(cliente.getInputStream());
		
		saida.println("I 9081453");
		System.out.println(server.nextLine());// mensagens de boas vindas
	
		for(int i = 1;i <= 10 ;i++) {
			ocupado[i] = false;
		}
		
		
		for (int i = 1; i <= 10; i++) {
			saida.println("R"+i); // joga os dados	
			System.out.println(server.nextLine()); // printa os dados
			saida.println("T 0 0 0 0 0"); // alteracao
			System.out.println(server.nextLine());
			saida.println("T 0 0 0 0 0");
			System.out.print(calculaMaior("2 2 2 2 2"));
			saida.println("P"+i+" "+ i); // coloca no placar
			System.out.println("Pontuação corrente " + server.nextLine());
		}
		//System.out.println("Pontuação corrente " + server.nextLine());
		saida.print("F");
		/*System.out.print("Eaee");
		System.out.println("Pontuação final " + server.nextLine());*/
	}

}
