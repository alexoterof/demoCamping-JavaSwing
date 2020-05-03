package modelo;

import java.io.Serializable;

/**
 *
 * @author alexoterof
 */
public interface iAlquilable extends Serializable{
	//checkin marca la parcela como ocupada  
	boolean checkIn(String dniHuesped);
	
	//checkout marca la parcela como libre y 
	//calcula el importe a pagar en función de los parámetros del camping 
	double checkOut();
}
