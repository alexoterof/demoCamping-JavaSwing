package modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author alexoterof
 */
public class Tienda extends Parcela{
	private double precioDia;
	private final int estanciaLarga;
	private final double descuento;
	private final double precioElec;

	public Tienda(int id, double precioDia, int estanciaLarga, double descuento, double precioElec) {
		super(id);
		this.precioDia = precioDia;
		this.estanciaLarga = estanciaLarga;
		this.descuento = descuento;
		this.precioElec = precioElec;
	}
	
	
	
	@Override
	public double checkOut(){
		//int diasPasados = (int) ChronoUnit.DAYS.between(this.getFechaEntrada(), LocalDateTime.now());		
		int diasPasados = (int) ChronoUnit.SECONDS.between(this.getFechaEntrada(), LocalDateTime.now());		
		if(diasPasados > estanciaLarga) precioDia = precioDia * (1d - descuento);
		precioDia += precioElec;
		
		
		setDniHuesped(null);
		setFechaEntrada(null);
		setOcupada(false);
		return precioDia * diasPasados;
	}
}
