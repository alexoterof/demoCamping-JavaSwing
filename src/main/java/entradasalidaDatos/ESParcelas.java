/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasalidaDatos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Parcela;

/**
 *
 * @author alexoterof
 */
public class ESParcelas {
	private final static String rutaParcelas = "data" + System.getProperty("file.separator") + "parcelas.dat";
	public static void escribeParcelas(ArrayList<Parcela> parcelasAEscribir){
		try (FileOutputStream fos = new FileOutputStream(rutaParcelas);
			BufferedOutputStream bos = new BufferedOutputStream(fos); 
			ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			
			for(Parcela parcela : parcelasAEscribir){
				oos.writeObject(parcela);
			}
		} catch (IOException ex) {
			System.err.println("Error ESParcelas:" + ex.getMessage());
			ex.printStackTrace();
		}
	}
	public static ArrayList<Parcela> leeParcelas(){
		ArrayList<Parcela> parcelasOcupadas = new ArrayList<>();
		
		boolean eof = false;
		try (FileInputStream fis = new FileInputStream(rutaParcelas); 
			BufferedInputStream bufis = new BufferedInputStream(fis); 
			ObjectInputStream ois = new ObjectInputStream(bufis)) {
			while (!eof) {                                //while(bufis.available()>0          
				parcelasOcupadas.add((Parcela)ois.readObject());
			}
		} catch (EOFException e) {
			eof = true;
		} catch (IOException ex) {
			System.err.println("Error:" + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ESParcelas.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return parcelasOcupadas;
	}
}
