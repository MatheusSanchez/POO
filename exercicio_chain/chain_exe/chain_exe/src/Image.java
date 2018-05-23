/**
* Classe responsável por manipular uma imagem.
* @author Sugi e Thauan
*
*/

import java.util.Scanner;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Image{
	
	private static Scanner entrada;
	

	static public void main(String[] args){
		
		BufferedImage imagem = null;	
		String caminhoImagem;
		int[] pixels, vector;
		int w,h;

		entrada = new Scanner(System.in);

		

		caminhoImagem = "oval.pnj";


		File inFile = new File(caminhoImagem);


		if(!inFile.exists()){
			System.out.println("A imagem não existe, programa finalizado !");
		}	
	
		
		try{
			imagem = ImageIO.read(inFile);	
		}
		catch(Exception e){
			System.out.println("A imagem não existe, programa finalizado !");
		}

		w = imagem.getWidth();
		h = imagem.getHeight();

		pixels = imagem.getRGB(0,0,w,h,null,0,w);	
			
		ProcessingImage im = new ProcessingImage(pixels,w,h); 	
		
		vector = im.initialImage();
		System.out.println("Inicial: " + vector[0] + " " + vector[1]);
		
		System.out.println("Largura: " + im.getWidth());

		System.out.println("Altura: " + im.getHeight());

		System.out.println("Pontos: " + im.edgePoints());

	}

}