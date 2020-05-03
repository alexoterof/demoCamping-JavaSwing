package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexoterof
 */
public class Parametros {
	//tienda
	private static int tiendaDia;
	private static int tiendaElec;
	private static double tiendaDesc;
	private static int tiendaLargaEstancia;

	//Caravana
	private static int caravanaDiaBaja;
	private static int caravanaDiaAlta;
	private static int caravanaMinimaEstancia;
	private static ArrayList<Integer> caravanaMesesTAlta;
	
	//Bungalow
	private static int bungalowDia;
	private static int bungalowEstanciaCorta;
	private static double bungalowRecargo;

	public static int getTiendaDia() {
		return tiendaDia;
	}

	public static void setTiendaDia(int tiendaDia) {
		Parametros.tiendaDia = tiendaDia;
	}

	public static int getTiendaElec() {
		return tiendaElec;
	}

	public static void setTiendaElec(int tiendaElec) {
		Parametros.tiendaElec = tiendaElec;
	}

	public static double getTiendaDesc() {
		return tiendaDesc;
	}

	public static void setTiendaDesc(double tiendaDesc) {
		Parametros.tiendaDesc = tiendaDesc;
	}

	public static int getTiendaLargaEstancia() {
		return tiendaLargaEstancia;
	}

	public static void setTiendaLargaEstancia(int tiendaLargaEstancia) {
		Parametros.tiendaLargaEstancia = tiendaLargaEstancia;
	}

	public static int getCaravanaDiaBaja() {
		return caravanaDiaBaja;
	}

	public static void setCaravanaDiaBaja(int caravanaDiaBaja) {
		Parametros.caravanaDiaBaja = caravanaDiaBaja;
	}

	public static int getCaravanaDiaAlta() {
		return caravanaDiaAlta;
	}

	public static void setCaravanaDiaAlta(int caravanaDiaAlta) {
		Parametros.caravanaDiaAlta = caravanaDiaAlta;
	}

	public static int getCaravanaMinimaEstancia() {
		return caravanaMinimaEstancia;
	}

	public static void setCaravanaMinimaEstancia(int caravanaMinimaEstancia) {
		Parametros.caravanaMinimaEstancia = caravanaMinimaEstancia;
	}

	public static ArrayList<Integer> getCaravanaMesesTAlta() {
		return caravanaMesesTAlta;
	}

	public static void setCaravanaMesesTAlta(ArrayList<Integer> caravanaMesesTAlta) {
		Parametros.caravanaMesesTAlta = caravanaMesesTAlta;
	}
	public static void setCaravanaMesesTAlta(String caravanaMesesTAltaStr){
		caravanaMesesTAlta = new ArrayList<>();
		String[] meses = caravanaMesesTAltaStr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(","); //Eliminamos chars innecesarios
		for (String mes : meses) {
			caravanaMesesTAlta.add(Integer.parseInt(mes));
		}
	}
	public static int getBungalowDia() {
		return bungalowDia;
	}

	public static void setBungalowDia(int bungalowDia) {
		Parametros.bungalowDia = bungalowDia;
	}

	public static int getBungalowEstanciaCorta() {
		return bungalowEstanciaCorta;
	}

	public static void setBungalowEstanciaCorta(int bungalowEstanciaCorta) {
		Parametros.bungalowEstanciaCorta = bungalowEstanciaCorta;
	}

	public static double getBungalowRecargo() {
		return bungalowRecargo;
	}

	public static void setBungalowRecargo(double bungalowRecargo) {
		Parametros.bungalowRecargo = bungalowRecargo;
	}	
}