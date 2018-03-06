import java.util.Scanner; // classe scanner para ler dados
import java.io.IOException;

public class teste {

	

	public static void main(String[] args) throws Exception {
		Scanner lendo = new Scanner(System.in); // instanciando objeto tipo scanner
		int k = 0;

		/*
			float numF = sc.nextFloat();
			int num1 = sc.nextInt();
			byte byte1 = sc.nextByte();
			long lg1 = sc.nextLong();
			boolean b1 = sc.nextBoolean();
			double num2 = sc.nextDouble();
			String nome = sc.nextLine();
		*/

		while(k != 1){
			System.out.printf("Digite 1 para parar o programa: ");

			k = lendo.nextInt();
			if(k!=1){
				System.out.println("Errrrrrrou");
			}else{
				System.out.println("Acertou Miserável");
			}
		}	

		System.out.print("AQUELE OLÁ MUNDO CLÁSSICO PARA FINALIZAR A BAGAÇA\n");

	}
}


