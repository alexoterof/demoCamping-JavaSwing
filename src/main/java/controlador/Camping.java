package controlador;

import entradasalidaDatos.ESParametros;
import entradasalidaDatos.ESParcelas;
import entradasalidaDatos.ESFacturacion;
import java.util.ArrayList;
import modelo.Parametros;
import javax.swing.JButton;
import modelo.*;
import vista.FramePrincipal;

/**
 *
 * @author alexoterof
 */
public class Camping {
	//Esto va a ir dentro de param
	private final int numTiendas = 10;
	private final int numCaravanas = 20;
	private final int numBungalows = 50;
	private final ArrayList<Parcela> parcelas;
	
	public Camping() {
		ESParametros.getParametrosFichero();
		parcelas = new ArrayList<>();
		cargaParcelas();
		FramePrincipal.actualizaInterfaz(parcelas);
	}
	
	public void cargaParcelas(){
		for (int i = 0; i < numTiendas + numCaravanas +  numBungalows; i++) {
			if(i < numTiendas){
				parcelas.add(new Tienda(i, Parametros.getTiendaDia(), 
									Parametros.getTiendaLargaEstancia(), 
									Parametros.getTiendaDesc(), 
									Parametros.getTiendaElec()));
			}
			else if(i < numTiendas + numCaravanas) {
				parcelas.add(new Caravana(i, Parametros.getCaravanaMinimaEstancia(), 
									Parametros.getCaravanaMesesTAlta(), 
									Parametros.getCaravanaDiaBaja(), 
									Parametros.getCaravanaDiaAlta()));
			}
			else {
				//num adultos a cero pq inicializamos vacia
				parcelas.add(new Bungalow(i, 0, Parametros.getBungalowDia(), 
									Parametros.getBungalowEstanciaCorta(), 
									Parametros.getBungalowRecargo())); 
			}
		}
		ArrayList<Parcela> parcelasOcu = new ArrayList<>();
		parcelasOcu = ESParcelas.leeParcelas();
		for(Parcela parc : parcelasOcu){
			parcelas.set(parc.getId(), parc); //Sustituimos as parcelas desocupadas creadas polas parcelas ocupadas gardadas no arquivo
		}
	}
	
	public void parcelaClickada(java.awt.event.MouseEvent evt){
		int id = Integer.parseInt(((JButton) evt.getSource()).getName()) - 1;
		//Cuando clickamos la parcela bien hacemos checkIn o hacemos checkOut
		if(parcelas.get(id).isOcupada()) checkOutParcela(id);
		else  checkInParcela(id);
		FramePrincipal.actualizaInterfaz(parcelas);
	}
	
	private void checkInParcela(int id){
		try{
			if(parcelas.get(id) instanceof  Bungalow){
				int numAdultos = Integer.parseInt(FramePrincipal.obtenNumAdultos()); //Hay que envolver esto con try-catch
				((Bungalow) parcelas.get(id)).setNumAdultos(numAdultos);
			}
			String dniInquilino = FramePrincipal.obtenDNI();
			if(dniInquilino != null) parcelas.get(id).checkIn(dniInquilino);	
			ESParcelas.writeParcelas(getParcelasOcupadas());
		}catch(NumberFormatException e){
			//Nada salta cuando el cliente cancela alquilar al bungalow en el primer msg(El que pide el numero de adultos)
		}
	}
	
	private void checkOutParcela(int id){
		Factura factura = new Factura(parcelas.get(id));
		double precio = parcelas.get(id).checkOut();
		if(precio != -1){//Solo pasa en caravana. Cuando se abandona antes del minimo de dias
			factura.setPrecio(precio);
			ESFacturacion.addFactura(factura);
			ESParcelas.writeParcelas(getParcelasOcupadas());
			FramePrincipal.muestraFactura(precio);
		}else FramePrincipal.muestraError("No se puede abandonar la estancia tan pronto"); 
	}
	
	//Esto se utiliza para obtener las parcelas que necesitamos guardar en el fichero de persistencia. 
	//Solo guardamos las que estan ocupadas (Por si luego los precios de las desocupadas cambian.
	//Las que ya se alquilaron mantienen la tarifa hasta la facturacion
	public ArrayList<Parcela> getParcelasOcupadas(){
		ArrayList<Parcela> parcelasOcupadas = new ArrayList<>();
		for (Parcela parcela : parcelas) {
			if(parcela.isOcupada()) parcelasOcupadas.add(parcela);
		}
		return parcelasOcupadas;
	}
}