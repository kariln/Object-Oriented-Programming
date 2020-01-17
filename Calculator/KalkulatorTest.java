package app;

import java.io.File;
import java.io.FileNotFoundException;

public class KalkulatorTest extends junit.framework.TestCase{
	
	public void testKalkulator(){
		kalkulator kalkulator = new kalkulator();
		
		//tester dele-metode
		assertEquals(5.0,kalkulator.dele(5,1));
		try{
			kalkulator.dele(5, 0);
			fail();
		} 
		catch (IllegalArgumentException e){
		}
		
		//tester plusse-metode
		assertEquals(3.0,kalkulator.pluss(1, 2));
		
		//tester minus-metode
		assertEquals(5.0, kalkulator.minus(6, 1));
		
		//tester gange-metode
		assertEquals(6.0, kalkulator.gange(2, 3));
		
		
		grensesnitt_app historie = new historie();
		File fil = new File ("C:\\Users\\Bruker\\tdt4100-v2019-master2\\git\\tdt4100-v2019-students");
	
		assertEquals("File not found",historie.lese(fil));

		
		File file = new File ("C:\\Users\\Bruker\\tdt4100-v2019-master2\\git\\tdt4100-v2019-students\\ovinger\\src\\app\\svar_vec.txt");
		historie.vise(4,2,"+", 6, file);
		assertEquals("4.0+2.0=6.0",historie.lese(file));
		
	}

}
