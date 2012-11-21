import static org.junit.Assert.*;

import org.junit.Test;


public class GlassTest {
	
	@Test
	public void shouldInitializeGlassCorrectly(){
		Glass glass = new Glass("    *         *         *         *                                                                                                                                                                     ");
		assertEquals("|          |\n|          |\n|          |\n|          |\n|          |\n|          |\n|          |\n|          |\n|          |\n" +
				     "|          |\n|          |\n|          |\n|          |\n|          |\n|          |\n|          |\n|    *     |\n|    *     |\n|    *     |\n|    *     |\n------------", glass.toString());
	}
	
	@Test
	public void shouldReturnRightSufrace(){
		Glass glass = new Glass("    *         *         *         *                                                                                                                                                                     ");
		int[] surf = glass.getSurface();
		int[] shouldBe = new int[]{0, 0, 0, 4, -4, 0, 0, 0, 0};
		for (int i = 0; i < surf.length; i++){
			assertEquals(shouldBe[i], surf[i]);
		}
	}
	
	@Test
	public void shouldReturnRightNumberOfElems(){
		Glass glass = new Glass("    *         *         *         *                                                                                                                                                                     ");		
		assertEquals(4, glass.numbOfElemsOnField());
		
	}
	

}
