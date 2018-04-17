import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testMap {
	public Map<Integer,String> teste;

	@BeforeEach
	public void setupMap() { 
		teste = new Map<Integer, String>();
		teste.add(1, "Matheus Sanchez");
		teste.add(2, "Pedro Baratela");
		teste.add(3, "Eduardo Brando");
	}
	
	@Test
	public void testGetValues() {
		assertEquals(teste.getValue(3),"Eduardo Brando");
	}
	
	@Test
	public void testContainsKey() {
		assertEquals(teste.containsKey(3),true);
		assertEquals(teste.containsKey(5),false);
	}
	
	@Test
	public void testContainsValue() {
		assertEquals(teste.containsValue("Matheus Sanchez"),true);
		assertEquals(teste.containsValue("CHALALALALAL"),false);
	}
	
	

}
