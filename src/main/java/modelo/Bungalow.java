/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author alexoterof
 */
public class Bungalow extends Parcela{
	private int numAdultos;
	private final double precioDia;
	private final int estanciaDemasiadoCorta;
	private final double recargo;

	public Bungalow(int numAdultos, double precioDia, int estanciaCorta, double recargo) {
		super();
		this.numAdultos = numAdultos;
		this.precioDia = precioDia;
		this.estanciaDemasiadoCorta = estanciaCorta;
		this.recargo = recargo;
	}

	public void setNumAdultos(int numAdultos) {
		this.numAdultos = numAdultos;
	}
	
	@Override
	public double checkOut() {
		//int diasPasados = (int) ChronoUnit.DAYS.between(this.getFechaEntrada(), LocalDate.now());
		int diasPasados = (int) ChronoUnit.SECONDS.between(this.getFechaEntrada(), LocalDateTime.now());
		
		setFechaEntrada(null);
		setDniHuesped(null);
		setOcupada(false);
		return  diasPasados <= estanciaDemasiadoCorta ? 
				diasPasados * numAdultos * precioDia * (1 + recargo) :
				diasPasados * numAdultos * precioDia;
	}

	
	
}
