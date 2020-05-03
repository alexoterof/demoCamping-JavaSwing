package otero.alex.campingdelsol.modelo;

import modelo.Tienda;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alexoterof
 */
public class TiendaTest {
	
	public TiendaTest() {
	}

	/**
	 * Test of checkOut method, of class Tienda.
	 */
	
	
	@Test
	public void testCheckOutECorta() {
		Tienda tienda = new Tienda(1, 20, 7, 0.10, 1);
		tienda.checkIn("35484573N");
		tienda.setFechaEntrada(LocalDateTime.now().minusSeconds(2));
		
		double expResult = 42;
		double result = tienda.checkOut();
		assertEquals(expResult, result, 0.1);
	}
	
	@Test
	public void testCheckOutELimite() {
		Tienda tienda = new Tienda(1, 20, 7, 0.10, 1);
		tienda.checkIn("35484573N");
		tienda.setFechaEntrada(LocalDateTime.now().minusSeconds(7));
		
		double expResult = 147;
		double result = tienda.checkOut();
		assertEquals(expResult, result, 0.1);
	}
	@Test
	public void testCheckOutELarga() {
		Tienda tienda = new Tienda(1, 20, 7, 0.10, 1);
		tienda.checkIn("35484573N");
		tienda.setFechaEntrada(LocalDateTime.now().minusSeconds(8));
		
		double expResult = 152;
		double result = tienda.checkOut();
		assertEquals(expResult, result, 0.1);
	}
	
	@Test
	public void testCheckOutParcelaNueva(){
		Tienda tienda = new Tienda(1, 20, 7, 0.10, 1);
		//Esperamos un nullPointer
		//fechaEntrada no esta inicializada la primera vez.
		assertThrows(NullPointerException.class, ()->{
				tienda.checkOut();
				});
	}
	
	@Test
	public void testCheckOutParcelaUsada(){
		Tienda tienda = new Tienda(1, 20, 7, 0.10, 1);
		tienda.checkIn("35484573N");
		tienda.setFechaEntrada(LocalDateTime.now().minusSeconds(7));
		tienda.checkOut();
		
		//Con este test nos aseguramos de que fechaEntrada
		//queda a null despues de salir
		assertThrows(NullPointerException.class, ()->{
				tienda.checkOut();
				});
	}
	
	@Test
	public void testCheckOutECero() {
		Tienda tienda = new Tienda(1, 20, 7, 0.10, 1);
		tienda.checkIn("35484573N");
		
		// t - 0 Suponemos que la parcela se ha dado de alta por error / reservaCancelada
		double expResult = 0;
		double result = tienda.checkOut();
		assertEquals(expResult, result, 0.1);
	}
}
