/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otero.alex.campingdelsol.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author alexoterof
 */
public class Bungalow extends Parcela{
	private final int numAdultos;
	private final double precioDia;
	private final int estanciaDemasiadoCorta;
	private final double recargo;

	public Bungalow(int id, int numAdultos, double precioDia, int estanciaCorta, double recargo) {
		super(id);
		this.numAdultos = numAdultos;
		this.precioDia = precioDia;
		this.estanciaDemasiadoCorta = estanciaCorta;
		this.recargo = recargo;
	}
	
	@Override
	public double checkOut() {
		int diasPasados = (int) ChronoUnit.DAYS.between(this.getFechaEntrada(), LocalDate.now());
		
		setFechaEntrada(null);
		setDniHuesped(null);
		return  diasPasados <= estanciaDemasiadoCorta ? 
				diasPasados * numAdultos * precioDia * (1 + recargo) :
				diasPasados * numAdultos * precioDia;
	}

	
	
}
