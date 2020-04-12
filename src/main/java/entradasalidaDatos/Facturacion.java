/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasalidaDatos;

import java.io.*;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexoterof
 */
public class Facturacion {
	
	public static void factura(String newline){
		try {
			File jar = new File(Facturacion.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			String jarDir = jar.getParentFile().getPath();
			System.out.println(jarDir);
		} catch (URISyntaxException ex) {
			Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}
