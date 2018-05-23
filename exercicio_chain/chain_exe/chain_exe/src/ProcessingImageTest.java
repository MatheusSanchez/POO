import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ProcessingImageTest {

	static ProcessingImage im;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		BufferedImage imagem = null;
		int w,h;
		int[] pixels;
		
		File inFile = new File("circulo.png");
		imagem = ImageIO.read(inFile);
		w = imagem.getWidth();
		h = imagem.getHeight();
		pixels = imagem.getRGB(0,0,w,h,null,0,w);
		im = new ProcessingImage(pixels,w,h);
	}

	@Test
	public void testGetHeight() {

		assertEquals(20,im.getHeight());
	}

	@Test
	public void testGetWidth() {
		assertEquals(20,im.getWidth());
	}

	@Test
	public void testInitialImage() {
		int[] vector = new int[2];
		vector[0] = 23;
		vector[1] = 16;
		assertArrayEquals(vector,im.initialImage());
	}

	@Test
	public void testEdgePoints() {
		assertEquals(52,im.edgePoints());
	}

}
