package entradasalidaDatos;

import modelo.Parametros;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author alexoterof
 */

public class ESParametros {
	public static void getParametrosFichero(){
		Properties config = new Properties();
		try {
			config.load(new FileInputStream("config.props"));
			Parametros.setTiendaDia(Integer.parseInt(config.getProperty("tiendaDia")));
			Parametros.setTiendaElec(Integer.parseInt(config.getProperty("tiendaElec")));
			Parametros.setTiendaDesc(Double.valueOf(config.getProperty("tiendaDesc")));
			Parametros.setTiendaLargaEstancia(Integer.parseInt(config.getProperty("tiendaLargaEstancia")));
			
			Parametros.setCaravanaDiaBaja(Integer.parseInt(config.getProperty("caravanaDiaBaja")));
			Parametros.setCaravanaDiaAlta(Integer.parseInt(config.getProperty("caravanaDiaAlta")));
			Parametros.setCaravanaMinimaEstancia(Integer.parseInt(config.getProperty("caravanaMinimaEstancia")));
			Parametros.setCaravanaMesesTAlta(config.getProperty("caravanaMesesTAlta"));
			
			Parametros.setBungalowDia(Integer.parseInt(config.getProperty("bungalowDia")));
			Parametros.setBungalowEstanciaCorta(Integer.parseInt(config.getProperty("bungalowEstanciaCorta")));
			Parametros.setBungalowRecargo(Double.valueOf(config.getProperty("bungalowRecargo")));
			
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			System.out.println("Restaurando valores por defecto...");
			escribeProperties();
		}
	}
	
	public static void setParametrosFichero(){
		Properties config = new Properties();
		config.setProperty("tiendaDia", String.valueOf(Parametros.getTiendaDia()));
		config.setProperty("tiendaElec", String.valueOf(Parametros.getTiendaElec()));
		config.setProperty("tiendaDesc", String.valueOf(Parametros.getTiendaDesc()));
		config.setProperty("tiendaLargaEstancia", String.valueOf(Parametros.getTiendaLargaEstancia()));
		
		config.setProperty("caravanaDiaBaja", String.valueOf(Parametros.getCaravanaDiaBaja()));
		config.setProperty("caravanaDiaAlta", String.valueOf(Parametros.getCaravanaDiaAlta()));
		config.setProperty("caravanaMinimaEstancia",String.valueOf(Parametros.getCaravanaMinimaEstancia()));
		config.setProperty("caravanaMesesTAlta", Parametros.getCaravanaMesesTAlta().toString()); // ojo aqui el array
		
		config.setProperty("bungalowDia", String.valueOf(Parametros.getBungalowDia()));
		config.setProperty("bungalowEstanciaCorta", String.valueOf(Parametros.getBungalowEstanciaCorta()));
		config.setProperty("bungalowRecargo", String.valueOf(Parametros.getBungalowRecargo()));
		try {
			config.store(new FileOutputStream("config.props"), "Fichero de config.");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	//A esto solo se le deberia llamar en caso de no encontrar el archivo. Son los valores por defecto de nuestro programa
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
			System.out.println("Valores por defecto cargados con éxito");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
}