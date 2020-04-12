/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otero.alex.campingdelsol.modelo;

import java.util.ArrayList;


/**
 *
 * @author alexoterof
 */
public class Param {
	//tienda
	private int tiendaDia;
	private int tiendaElec;
	private double tiendaDesc;
	private int tiendaLargaEstancia;

	//Caravana
	private int caravanaDiaBaja;
	private int caravanaDiaAlta;
	private int caravanaMinimaEstancia;
	private ArrayList<Integer> caravanaMesesTAlta;
	
	//Bungalow
	private int bungalowDia;
	private int bungalowEstanciaCorta;
	private double bungalowRecargo;

	public Param() {
	}

	
	
	//Constructor para test
	public Param(int tiendaDia, int tiendaElec, double tiendaDesc, int tiendaLargaEstancia, int caravanaDiaBaja, int caravanaDiaAlta, int caravanaMinimaEstancia, ArrayList<Integer> caravanaMesesTAlta, int bungalowDia, int bungalowEstanciaCorta, double bungalowRecargo) {
		this.tiendaDia = tiendaDia;
		this.tiendaElec = tiendaElec;
		this.tiendaDesc = tiendaDesc;
		this.tiendaLargaEstancia = tiendaLargaEstancia;
		this.caravanaDiaBaja = caravanaDiaBaja;
		this.caravanaDiaAlta = caravanaDiaAlta;
		this.caravanaMinimaEstancia = caravanaMinimaEstancia;
		this.caravanaMesesTAlta = caravanaMesesTAlta;
		this.bungalowDia = bungalowDia;
		this.bungalowEstanciaCorta = bungalowEstanciaCorta;
		this.bungalowRecargo = bungalowRecargo;
	}

	

	
	
	public int getTiendaDia() {
		return tiendaDia;
	}

	public void setTiendaDia(int tiendaDia) {
		this.tiendaDia = tiendaDia;
	}

	public int getTiendaElec() {
		return tiendaElec;
	}

	public void setTiendaElec(int tiendaElec) {
		this.tiendaElec = tiendaElec;
	}

	public double getTiendaDesc() {
		return tiendaDesc;
	}

	public void setTiendaDesc(double tiendaDesc) {
		this.tiendaDesc = tiendaDesc;
	}

	public int getTiendaLargaEstancia() {
		return tiendaLargaEstancia;
	}

	public void setTiendaLargaEstancia(int tiendaLargaEstancia) {
		this.tiendaLargaEstancia = tiendaLargaEstancia;
	}

	public int getCaravanaDiaBaja() {
		return caravanaDiaBaja;
	}

	public void setCaravanaDiaBaja(int caravanaDiaBaja) {
		this.caravanaDiaBaja = caravanaDiaBaja;
	}

	public int getCaravanaDiaAlta() {
		return caravanaDiaAlta;
	}

	public void setCaravanaDiaAlta(int caravanaDiaAlta) {
		this.caravanaDiaAlta = caravanaDiaAlta;
	}

	public int getCaravanaMinimaEstancia() {
		return caravanaMinimaEstancia;
	}

	public void setCaravanaMinimaEstancia(int caravanaMinimaEstancia) {
		this.caravanaMinimaEstancia = caravanaMinimaEstancia;
	}

	public ArrayList<Integer> getCaravanaMesesTAlta() {
		return caravanaMesesTAlta;
	}

	public void setCaravanaMesesTAlta(ArrayList<Integer> caravanaMesesTAlta) {
		this.caravanaMesesTAlta = caravanaMesesTAlta;
	}

	public int getBungalowDia() {
		return bungalowDia;
	}

	public void setBungalowDia(int bungalowDia) {
		this.bungalowDia = bungalowDia;
	}

	public int getBungalowEstanciaCorta() {
		return bungalowEstanciaCorta;
	}

	public void setBungalowEstanciaCorta(int bungalowEstanciaCorta) {
		this.bungalowEstanciaCorta = bungalowEstanciaCorta;
	}

	public double getBungalowRecargo() {
		return bungalowRecargo;
	}

	public void setBungalowRecargo(double bungalowRecargo) {
		this.bungalowRecargo = bungalowRecargo;
	}

	
	

	
	
	
}
