/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otero.alex.campingdelsol.modelo;

import java.time.LocalDate;

/**
 *
 * @author alexoterof
 */
public abstract class Parcela implements iAlquilable{
	private boolean ocupada;
	private String dniHuesped;
	private LocalDate fechaEntrada;
	private int id; // necesario??
			
	Parcela(int id){
		this.id = id;
		this.ocupada = false;
		this.dniHuesped = "";
		this.fechaEntrada = null;
	}

	@Override
	public boolean checkIn(String dniHuesped){
		if(ocupada) return false;
		this.ocupada = true;
		this.dniHuesped = dniHuesped;
		this.fechaEntrada = LocalDate.now();
		return true;
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

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
