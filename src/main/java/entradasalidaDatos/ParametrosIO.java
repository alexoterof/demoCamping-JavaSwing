package entradasalidaDatos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author alexoterof
 */
public class ParametrosIO {
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

	public ParametrosIO() {
		//Lo vamos a potencialmente llamar en tiempo de ejecucion
		//Lo metemos en un metodo para no construir una instancia
		//nueva cada vez que cambien
		actualizaParametros(); 
	}
	
	public void actualizaParametros(){
		Properties config = new Properties();
		try {
			config.load(new FileInputStream("config.props"));
			tiendaDia = Integer.parseInt(config.getProperty("tiendaDia"));
			tiendaElec = Integer.parseInt(config.getProperty("tiendaElec"));
			tiendaDesc = Double.valueOf(config.getProperty("tiendaDesc"));
			tiendaLargaEstancia = Integer.parseInt(config.getProperty("tiendaLargaEstancia"));
			
			caravanaDiaBaja = Integer.parseInt(config.getProperty("caravanaDiaBaja"));
			caravanaDiaAlta = Integer.parseInt(config.getProperty("caravanaDiaAlta"));
			caravanaMinimaEstancia = Integer.parseInt(config.getProperty("caravanaMinimaEstancia"));
			caravanaMesesTAlta = traduce(config.getProperty("caravanaMesesTAlta"));
			
			bungalowDia = Integer.parseInt(config.getProperty("bungalowDia"));
			bungalowEstanciaCorta = Integer.parseInt(config.getProperty("bungalowEstanciaCorta"));
			bungalowRecargo = Double.valueOf(config.getProperty("bungalowRecargo"));
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private ArrayList<Integer> traduce (String input){
		ArrayList<Integer> lista = new ArrayList<>();
		Scanner scanner = new Scanner(input);
		while(scanner.hasNextInt()){
			lista.add(scanner.nextInt());
		}
		return lista;
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
