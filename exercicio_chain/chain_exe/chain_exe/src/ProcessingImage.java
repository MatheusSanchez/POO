public class ProcessingImage{

	private int[][] matrixPixel;	
	private int w,h;
	private double perimeter;
	

	public ProcessingImage(int[] pixels, int w, int h){

		matrixPixel = new int[h][w];

		
		for(int i=0;i<h;i++){
                        for(int j=0;j<w;j++){
                                matrixPixel[i][j] = pixels[j + w*i];
                        }
                }
		this.w = w;
		this.h = h;
		this.perimeter = 0;
	}
	

	private int pixelIsNotWhite(int rgb){
		
		int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                if(red != 255 || green != 255 || blue != 255){
                        return 1;
                }
                else{
                	return 0;
                }
	}

	public int getHeight(){
		
		int ret, counter = 0;	
		int bigger = -1;

                for(int i=0;i<w;i++){
                        for(int j=0;j<h;j++){
                                ret = pixelIsNotWhite(matrixPixel[j][i]);
                                if(ret == 1){
                                        counter++;
                                }
                        }
                        if(bigger < counter){
                                bigger = counter;
                        }
                        counter = 0;

		}
		return bigger;
	}


	 public int getWidth(){

                int ret, counter = 0;
                int bigger = -1;

                for(int i=0;i<h;i++){
                        for(int j=0;j<w;j++){
                                ret = pixelIsNotWhite(matrixPixel[i][j]);
                                if(ret == 1){
                                        counter++;
                                }
                        }
                        if(bigger < counter){
                                bigger = counter;
                        }
                        counter = 0;

                }
                return bigger;
        }

	public int[] initialImage(){
			
		int ret;
		int[] vector = new int[2];
		vector[0] = vector[1] = -1;

		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				ret = pixelIsNotWhite(matrixPixel[i][j]);	
				if(ret == 1){
					vector[0] = j;
					vector[1] = i;
					return vector;
				}
			}
		}
		return vector;
	}
	
	//chain
	private void runChainCodes(int[] pos, int x, int y, boolean[] chainCodes){
		
		int p = 0;

		for(int i=0;i<chainCodes.length;i++){
			chainCodes[i] = false;
		}

		if((y + 1) < w && pixelIsNotWhite(matrixPixel[x][y+1]) == 0){
			chainCodes[0] = true;
		}
		if((y + 1) < w && (x - 1) >= 0 && pixelIsNotWhite(matrixPixel[x-1][y+1]) == 0){
			chainCodes[1] = true;
		}
		if((x - 1) >= 0 && pixelIsNotWhite(matrixPixel[x-1][y]) == 0){
			chainCodes[2] = true;
		}
		if((y - 1) >= 0 && (x - 1) >= 0 && pixelIsNotWhite(matrixPixel[x-1][y-1]) == 0){
			chainCodes[3] = true;
		}
		if((y - 1) >= 0 && pixelIsNotWhite(matrixPixel[x][y-1]) == 0){
			chainCodes[4] = true;
		}
		if((y - 1) >= 0 && (x + 1) < h && pixelIsNotWhite(matrixPixel[x+1][y-1]) == 0){
			chainCodes[5] = true;
		}
		if((x + 1) < h && pixelIsNotWhite(matrixPixel[x+1][y]) == 0){
			chainCodes[6] = true;
		}
		if((y + 1) < w && (x + 1) < h && pixelIsNotWhite(matrixPixel[x+1][y+1]) == 0){
			chainCodes[7] = true;
		}
		
		for(int i=0;i>=0;i--){
			if(chainCodes[i] == true){
				p = i;
				break;
			}
			if(i == 0) i = chainCodes.length;
		}
		
		for(int i=p;i>=0;i--){
			if(chainCodes[i] == false){
				p = i;
				break;
			}
			if(i ==0) i  = chainCodes.length;
		}	

		if(p == 0){
			pos[0] = x;
			pos[1] = y+1;
			perimeter += 1;
			System.out.printf(" 0");
		}
		else if(p == 1){
			pos[0] = x-1;
			pos[1] = y+1;
			perimeter += Math.sqrt(2);
			System.out.printf(" 7");
		}
		else if(p == 2){
			pos[0] = x-1;
			pos[1] = y;
			perimeter += 1;
			System.out.printf(" 6");
		}
		else if(p == 3){
			pos[0] = x-1;
			pos[1] = y-1;
			perimeter += Math.sqrt(2);
			System.out.printf(" 5");
		}
		else if(p == 4){
			pos[0] = x;
			pos[1] = y-1;
			perimeter += 1;
			System.out.printf(" 4");
		}
		else if(p == 5){
			pos[0] = x+1;
			pos[1] = y-1;
			perimeter += Math.sqrt(2);
			System.out.printf(" 3");
		}
		else if(p == 6){
			pos[0] = x+1;
			pos[1] = y;
			perimeter += 1;
			System.out.printf(" 2");
		}
		else if(p == 7){
			pos[0] = x+1;
			pos[1] = y+1;
			perimeter += Math.sqrt(2);
			System.out.printf(" 1");
		}
	}


	public int edgePoints(){
		
		int point = 0 ,ret;
		int x = 0, y = 0;
		int[] pos = new int[2];
	
		//Vetor do chain codes
		boolean[] chainCodes = new boolean[8];
		
		//Procurando pelo ponto incial da imagem
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				ret = pixelIsNotWhite(matrixPixel[i][j]);
				if(ret == 1){
					x = i;
					y = j;
					i = h;
					j = w;
				}
			}
		}
		
		System.out.printf("Chain Codes:");
		
		pos[0] = x;
		pos[1] = y;
		do{	
			runChainCodes(pos,pos[0],pos[1],chainCodes);
			point++;
		}while(pos[0] != x || pos[1] != y);
		
		System.out.println("\nPerimetro: " + perimeter);

		return point;	
	}
}