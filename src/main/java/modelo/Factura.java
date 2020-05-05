/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 *
 * @author alexoterof
 */
public class Factura {
	private final int id;
	private final boolean ocupada;
	private final String dniHuesped;
	//private final LocalDateTime fechaEntrada;
	private final LocalDate fechaEntrada;
	private double precio;
	private String lineaFacturacion;
	public Factura(Parcela parcela) {
		this.id = parcela.getId();
		this.ocupada = parcela.isOcupada();
		this.dniHuesped = parcela.getDniHuesped();
		this.fechaEntrada = parcela.getFechaEntrada();
	}

	public int getId() {
		return id;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public String getDniHuesped() {
		return dniHuesped;
	}
	
	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}
	
//	public LocalDateTime getFechaEntrada() {
//		return fechaEntrada;
//	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getLineaFacturacion() {
		return lineaFacturacion;
	}
}
