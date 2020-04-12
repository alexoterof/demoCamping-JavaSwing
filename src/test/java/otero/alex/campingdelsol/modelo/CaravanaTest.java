package otero.alex.campingdelsol.modelo;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alexoterof
 */
public class CaravanaTest {
	static ArrayList<Integer> mesesTAlta;
	public CaravanaTest() {
		mesesTAlta = new ArrayList<Integer>();
		mesesTAlta.add(7);
		mesesTAlta.add(8);
	}
	
	/**
	 * Test of checkOut method, of class Caravana.
	 */
	@Test
	public void testCheckOutETBajaCorta() {
		System.out.println("checkOut");
		Caravana caravana = new Caravana(0, 10, mesesTAlta, 30, 40);
		double expResult = 0.0;
		double result = caravana.checkOut();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
