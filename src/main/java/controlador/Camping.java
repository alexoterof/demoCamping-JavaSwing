package controlador;

import entradasalidaDatos.ESParametros;
import entradasalidaDatos.ESParcelas;
import entradasalidaDatos.Facturacion;
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
		instanciaParcelas();
		cargaParcelas();
		FramePrincipal.actualizaInterfaz(parcelas);
	}
	
	public void instanciaParcelas(){
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
	}
	
	public void cargaParcelas(){
		ArrayList<Parcela> parcelasOcu = new ArrayList<>();
		parcelasOcu = ESParcelas.leeParcelas();
		for(Parcela parc : parcelasOcu){
			parcelas.set(parc.getId(), parc); //Sustituimos as parcelas desocupadas creadas no constructor polas parcelas ocupadas gardadas no arquivo
		}
		
	}
	
	public void parcelaClickada(java.awt.event.MouseEvent evt){
		int id = Integer.parseInt(((JButton) evt.getSource()).getName()) - 1;
		if(parcelas.get(id).isOcupada()) checkOutParcela(id);
		else  alquilaParcela(id);
		FramePrincipal.actualizaInterfaz(parcelas);
	}
	private void alquilaParcela(int id){
		if(parcelas.get(id) instanceof  Bungalow){
			int numAdultos = Integer.parseInt(FramePrincipal.obtenNumAdultos()); //Hay que envolver esto con try-catch
			((Bungalow) parcelas.get(id)).setNumAdultos(numAdultos);
		}
		String dniInquilino = FramePrincipal.obtenDNI();
		if(dniInquilino != null) parcelas.get(id).checkIn(dniInquilino);	
		ESParcelas.escribeParcelas(getParcelasOcupadas());
	}
	
	private void checkOutParcela(int id){
		//Llamamos al jpane de factura pasandole los datos
		double precio = parcelas.get(id).checkOut();
		if(precio != -1){
			FramePrincipal.muestraFactura(precio);
			//Facturacion.factura("");
		}else FramePrincipal.muestraError("No se puede abandonar la estancia tan pronto"); //Solo pasa en caravana
		
		ESParcelas.escribeParcelas(getParcelasOcupadas());
	}
	public String getSParcela(int id){
		return parcelas.get(id).toString();
	}
	
	//Esto se utiliza para obtener las parcelas que necesitamos guardar en el fichero de persistencia
	public ArrayList<Parcela> getParcelasOcupadas(){
		ArrayList<Parcela> parcelasOcupadas = new ArrayList<>();
		for (Parcela parcela : parcelas) {
			if(parcela.isOcupada()) parcelasOcupadas.add(parcela);
		}
		return parcelasOcupadas;
	}
}
