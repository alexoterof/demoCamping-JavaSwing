package otero.alex.campingdelsol.modelo;

import modelo.Caravana;
import java.time.LocalDateTime;
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
	public void testCheckOutTBajaInstantánea() {
		Caravana caravana = new Caravana(10, mesesTAlta, 30, 40);
		caravana.checkIn("35484573N");
		
		double expResult = 0; //No se puede abandonar tan pronto
		double result = caravana.checkOut();
		assertEquals(expResult, result, 0.1);
		
	}
	
	@Test
	public void testCheckOutTBajaCorta() {
		Caravana caravana = new Caravana(10, mesesTAlta, 30, 40);
		caravana.checkIn("35484573N");
		caravana.setFechaEntrada(LocalDateTime.now().minusSeconds(3));
		double expResult = -1; //No se puede abandonar tan pronto
		double result = caravana.checkOut();
		assertEquals(expResult, result, 0.1);
		
	}
	
	@Test
	public void testCheckOutTBajaLimite() {
		Caravana caravana = new Caravana(10, mesesTAlta, 30, 40);
		caravana.checkIn("35484573N");
		caravana.setFechaEntrada(LocalDateTime.now().minusSeconds(10));
		double expResult = -1; //No se puede abandonar tan pronto
		double result = caravana.checkOut();
		assertEquals(expResult, result, 0.1);
	}
	
	@Test
	public void testCheckOutTBaja() {
		Caravana caravana = new Caravana(10, mesesTAlta, 30, 40);
		caravana.checkIn("35484573N");
		caravana.setFechaEntrada(LocalDateTime.now().minusSeconds(11));
		
		double expResult = 330; 
		double result = caravana.checkOut();
		assertEquals(expResult, result, 0.1);
		
	}
	
	@Test
	public void testCheckOutTAlta() {
		ArrayList<Integer> mesesTAltaAlt = new ArrayList<Integer>();
		mesesTAltaAlt.add(LocalDateTime.now().getMonthValue());
		
		Caravana caravana = new Caravana(10, mesesTAltaAlt, 30, 40);
		caravana.checkIn("35484573N");
		caravana.setFechaEntrada(LocalDateTime.now().minusSeconds(11));
		
		double expResult = 440;
		double result = caravana.checkOut();
		assertEquals(expResult, result, 0.1);
		
	}
	
}
