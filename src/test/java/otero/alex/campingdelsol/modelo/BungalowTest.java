package otero.alex.campingdelsol.modelo;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alexoterof
 */
public class BungalowTest {
	
	public BungalowTest() {
	}

	/**
	 * Test of checkOut method, of class Bungalow.
	 */
	
	@Test
	public void testCheckOutELargaNormal() {
		Bungalow bungalow = new Bungalow(45, 2, 20, 2, 0.2);
		bungalow.checkIn("35484573N");
		bungalow.setFechaEntrada(LocalDate.now().minusDays(3));
		
		double expResult = 120;
		double result = bungalow.checkOut();
		assertEquals(expResult, result, 0.1);
		// TODO review the generated test code and remove the default call to fail.
		
	}
	
	@Test
	public void testCheckOutECortaNormal() {
		Bungalow bungalow = new Bungalow(45, 2, 20, 2, 0.2);
		bungalow.checkIn("35484573N");
		bungalow.setFechaEntrada(LocalDate.now().minusDays(1));
		
		double expResult = 48;
		double result = bungalow.checkOut();
		assertEquals(expResult, result, 0.1);
		// TODO review the generated test code and remove the default call to fail.
	}
	
	@Test
	public void testCheckOutEstanciaLimite() {
		Bungalow bungalow = new Bungalow(45, 3, 20, 2, 0.2);
		bungalow.checkIn("35484573N");
		bungalow.setFechaEntrada(LocalDate.now().minusDays(2));
		
		double expResult = 144;
		double result = bungalow.checkOut();
		assertEquals(expResult, result, 0.1);
	}
	
	@Test
	public void testCheckOutParcelaNueva() {
		Bungalow bungalow = new Bungalow(45, 2, 20, 2, 0.2);
		//bungalow.checkIn("35484573N");
		//bungalow.setFechaEntrada(LocalDate.now().minusDays(3));
		

		//Esperamos un nullPointer
		//fechaEntrada no esta inicializada la primera vez.
		assertThrows(NullPointerException.class, ()->{
				bungalow.checkOut();
				});
	}
	
	@Test
	public void testCheckOutParcelaUsada() {
		Bungalow bungalow = new Bungalow(45, 2, 20, 2, 0.2);
		bungalow.checkIn("35484573N");
		bungalow.setFechaEntrada(LocalDate.now().minusDays(3));
		bungalow.checkOut();
		
		//Con este test nos aseguramos de que fechaEntrada
		//queda a null despues de salir
		assertThrows(NullPointerException.class, ()->{
				bungalow.checkOut();
				});
	}
	
	@Test
	public void testCheckOutECero() {
		Bungalow bungalow = new Bungalow(45, 2, 20, 2, 0.2);
		bungalow.checkIn("35484573N");
		
		// t - 0 Suponemos que la parcela se ha dado de alta por error / reservaCancelada
		double expResult = 0;
		double result = bungalow.checkOut();
		assertEquals(expResult, result, 0.1);
	}
	
	
}
