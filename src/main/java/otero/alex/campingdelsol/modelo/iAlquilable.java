package otero.alex.campingdelsol.modelo;

/**
 *
 * @author alexoterof
 */
public interface iAlquilable {
	//checkin marca la parcela como ocupada  
	boolean checkIn(String dniHuesped);
	
	//checkout marca la parcela como libre y 
	//calcula el importe a pagar en función de los parámetros del camping 
	double checkOut();
}
