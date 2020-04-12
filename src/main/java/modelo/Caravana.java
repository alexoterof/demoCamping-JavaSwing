package modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Caravana extends Parcela{
	private final int estanciaMinima;
	private final ArrayList<Integer> mesesTAlta;
	private final double precioDiaBaja; //TBaja
	private final double precioDiaAlta;

	public Caravana(int estanciaMinima, ArrayList<Integer> mesesTAlta, double precioDiaBaja, double precioDiaAlta) {
		super();
		this.estanciaMinima = estanciaMinima;
		this.mesesTAlta = mesesTAlta;
		this.precioDiaBaja = precioDiaBaja;
		this.precioDiaAlta = precioDiaAlta;
	}
	
	@Override
	public double checkOut(){
		//int diasPasados = (int) ChronoUnit.DAYS.between(this.getFechaEntrada(), LocalDate.now());	
		int diasPasados = (int) ChronoUnit.SECONDS.between(this.getFechaEntrada(), LocalDateTime.now());	
		if(diasPasados <= estanciaMinima && diasPasados > 0) return -1; //No se puede hacer checkOut aun
		
		//Estamos teniendo en cuenta la temporada alta solo para el mes de salida. 
		//En las especificaciones no aclara si es para cualquier momento de la estancia
		//o como se cobraria de ser solo una parte de la estancia
		double factura;
		if(mesesTAlta.contains(getFechaEntrada().getMonthValue())) factura = precioDiaAlta * diasPasados;
		else factura = precioDiaBaja * diasPasados;
		
		setDniHuesped(null);
		setFechaEntrada(null);
		setOcupada(false);
		return factura;
	}
}
