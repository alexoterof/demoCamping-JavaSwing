/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entradasalidaDatos.Facturacion;
import entradasalidaDatos.ParametrosIO;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import modelo.*;
import vista.FramePrincipal;

/**
 *
 * @author alexoterof
 */
public class Camping {
	//Esto va a ir dentro de param
	private final int numTiendas = 11;
	private final int numCaravanas = 20;
	private final int numBungalows = 49;
	
	//Probablemente refactor aqui a ArrayList pq parcelas ya tiene un id. Se deberia sobrescribir el equals y ya
	private final Map<Integer, Parcela> parcelas;
	ParametrosIO p;
	public Camping(ParametrosIO param) {
		parcelas = new HashMap<>();
		this.p = param;
	}
	
	public void instanciaParcelas(){
		for (int i = 1; i <= numTiendas + numCaravanas +  numBungalows; i++) {
			if(i < numTiendas){
				parcelas.put(i, new Tienda(p.getTiendaDia(), p.getTiendaLargaEstancia(), p.getTiendaDesc(), p.getTiendaElec()));
			}
			else if(i < numTiendas + numCaravanas) {
				parcelas.put(i, new Caravana(p.getCaravanaMinimaEstancia(), p.getCaravanaMesesTAlta(), p.getCaravanaDiaBaja(), p.getCaravanaDiaAlta()));
			}
			else {
				parcelas.put(i, new Bungalow(0, p.getBungalowDia(), p.getBungalowEstanciaCorta(), p.getBungalowRecargo())); //num adultos a cero pq inicializamos vacia
			}
		}
	}
	
	public void parcelaClickada(java.awt.event.MouseEvent evt){
		int id = Integer.parseInt(((JButton) evt.getSource()).getName());
		Parcela parcelaSeleccionada = parcelas.get(id);
		if(parcelaSeleccionada.isOcupada())  
			liberaParcela(parcelaSeleccionada);
		else  alquilaParcela(parcelaSeleccionada);
		FramePrincipal.actualizaInterfaz(parcelas);
		
	}
	private void alquilaParcela(Parcela parcelaSeleccionada){
		if(parcelaSeleccionada instanceof  Bungalow){
			int numAdultos = Integer.parseInt(FramePrincipal.obtenNumAdultos()); //Hay que envolver esto con try-catch
			((Bungalow) parcelaSeleccionada).setNumAdultos(numAdultos);
		}
		
		String dniInquilino = FramePrincipal.obtenDNI();
		if(dniInquilino != null) parcelaSeleccionada.checkIn(dniInquilino);		
	}
	
	private void liberaParcela(Parcela parcelaSeleccionada){
		//Llamamos al jpane de factura pasandole los datos
		double precio = parcelaSeleccionada.checkOut();
		if(precio != -1){
			FramePrincipal.muestraFactura(precio);
			Facturacion.factura("");
		}
		else FramePrincipal.muestraError("No se puede abandonar la estancia tan pronto"); //Solo pasa en caravana
	}
	public String getSParcela(int id){
		return parcelas.get(id).toString();
	}
	
	
}
