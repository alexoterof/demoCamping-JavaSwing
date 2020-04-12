/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author alexoterof
 */
public abstract class Parcela implements iAlquilable{
	private boolean ocupada;
	private String dniHuesped;
	private LocalDateTime fechaEntrada;
			
	Parcela(){
		this.ocupada = false;
		this.dniHuesped = "";
		this.fechaEntrada = null;
	}

	@Override
	public boolean checkIn(String dniHuesped){
		if(ocupada) return false;
		this.ocupada = true;
		this.dniHuesped = dniHuesped;
		this.fechaEntrada = LocalDateTime.now();
		return true;
	}

	@Override
	public String toString() {
		String st = "";
		st += "Class: " + this.getClass().getSimpleName() +
			  "\nOcupada: " + Boolean.toString(this.ocupada);
		if(ocupada) st += "\nDNI del huesped: " + dniHuesped +
					   "\nFecha de entrada: " + fechaEntrada.toString();
		return st;
	}
	
	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public String getDniHuesped() {
		return dniHuesped;
	}

	public void setDniHuesped(String dniHuesped) {
		this.dniHuesped = dniHuesped;
	}

	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
}
