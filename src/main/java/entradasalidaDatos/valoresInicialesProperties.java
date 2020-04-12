package entradasalidaDatos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author alexoterof
 */

//Ejecutar esta clase por separado para crear y rellenar 
//el fichero properties
public class valoresInicialesProperties {
	public static void escribeProperties(){
		//Array de meses de TAlta -> 
		ArrayList<Integer> caravanaMesesTAlta = new ArrayList<>();
		caravanaMesesTAlta.add(8); caravanaMesesTAlta.add(7);
		
		Properties config = new Properties();
		config.setProperty("tiendaDia", Integer.toString(20));
		config.setProperty("tiendaElec", Integer.toString(1));
		config.setProperty("tiendaDesc", Double.toString(0.1));
		config.setProperty("tiendaLargaEstancia", Integer.toString(7));
		
		config.setProperty("caravanaDiaBaja", Integer.toString(30));
		config.setProperty("caravanaDiaAlta", Integer.toString(40));
		config.setProperty("caravanaMinimaEstancia", Integer.toString(10));
		config.setProperty("caravanaMesesTAlta", caravanaMesesTAlta.toString());
		
		config.setProperty("bungalowDia", Integer.toString(20));
		config.setProperty("bungalowEstanciaCorta", Integer.toString(2));
		config.setProperty("bungalowRecargo", Double.toString(0.2));
		try {
			config.store(new FileOutputStream("config.props"), "Fichero de config.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public static void main(String[] args){
		System.out.println("Inicializando...");
		escribeProperties();
		System.out.println("Escritura realizada con éxito");
	}
}
