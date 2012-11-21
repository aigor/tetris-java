import static org.junit.Assert.*;

import org.junit.Test;


public class FigureTest {
	
	@Test
	public void shouldBuildFigure(){
		Figure f = new Figure(	3, 3,
								"     ",
								"  *  ",	
								"  *  ",
								"  *  ",
								"  *  ");
		assertEquals("     \n  *  \n  *  \n  *  \n  *  \n", f.toString());		
	}
	
	@Test
	public void sholdReturnRightNumberOfElems(){
		Figure f = new Figure(	3, 3,
								"     ",
								"  *  ",	
								"  *  ",
								"  *  ",
								"  *  ");
		assertEquals(4, f.numbOfElemsOnField());
		
	}
	
	@Test
	public void sholdRotateCorreclty(){
		Figure f1 = new Figure(	3, 3,
								"     ",
								"  *  ",	
								"  *  ",
								"  *  ",
								"  *  ");
		Figure f2 = new Figure(	3, 3,
								"     ",
								"     ",	
								"**** ",
								"     ",
								"     ");

		assertEquals(f1.rotate().toString(), f2.toString());
		
	}
	
	@Test
	public void sholdRotateCorrecltyTFigure(){
		Figure f1 = new Figure(	3, 3,
								"     ",
								"  *  ",	
								" *** ",
								"     ",
								"     ");
		Figure f2 = new Figure(	3, 3,
								"     ",
								"  *  ",	
								"  ** ",
								"  *  ",
								"     ");

		assertEquals(f1.rotate().toString(), f2.toString());		
	}
	
	@Test
	public void sholdRotateCorrecltyTFigure2Times(){
		Figure f1 = new Figure(	3, 3,
								"     ",
								"  *  ",	
								" *** ",
								"     ",
								"     ");
		Figure f2 = new Figure(	3, 3,
								"     ",
								"     ",	
								" *** ",
								"  *  ",
								"     ");
		
		Figure f3 = new Figure(	3, 3,
								"     ",
								"  *  ",	
								" **  ",
								"  *  ",
								"     ");

		assertEquals(f1.rotate(2).toString(), f2.toString());		
		assertEquals(f1.rotate(3).toString(), f3.toString());
	}

}
