package otero.alex.campingdelsol.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Caravana extends Parcela{
	private final int estanciaMinima;
	private final ArrayList<Integer> mesesTAlta;
	private final double precioDiaBaja; //TBaja
	private final double precioDiaAlta;

	public Caravana(int id, int estanciaMinima, ArrayList<Integer> mesesTAlta, double precioDiaBaja, double precioDiaAlta) {
		super(id);
		this.estanciaMinima = estanciaMinima;
		this.mesesTAlta = mesesTAlta;
		this.precioDiaBaja = precioDiaBaja;
		this.precioDiaAlta = precioDiaAlta;
	}
	
	
	@Override
	public double checkOut(){
		int diasPasados = (int) ChronoUnit.DAYS.between(this.getFechaEntrada(), LocalDate.now());	
		if(diasPasados < estanciaMinima) return -1; //No se puede hacer checkOut aun
		
		//Estamos teniendo en cuenta la temporada alta solo para el mes de salida. 
		//En las especificaciones no aclara si es para cualquier momento de la estancia
		//o como se cobraria de ser solo una parte de la estancia
		double factura;
		if(mesesTAlta.contains(getFechaEntrada().getMonthValue())) factura = precioDiaBaja * diasPasados;
		else factura = precioDiaAlta * diasPasados;
		
		setDniHuesped(null);
		setFechaEntrada(null);
		return factura;
	}
}