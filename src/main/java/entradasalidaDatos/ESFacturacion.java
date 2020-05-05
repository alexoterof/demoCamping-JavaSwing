package entradasalidaDatos;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Factura;

/**
 *
 * @author alexoterof
 */
public class ESFacturacion {
	private final static String rutaFacturacion = "data" + System.getProperty("file.separator") + "facturacion.csv";
	public static void addFactura(Factura factura){
		try (FileWriter fw = new FileWriter(new File(rutaFacturacion), true);
		       BufferedWriter bfw = new BufferedWriter(fw)){
			String line = factura.getDniHuesped() + ";" + 
					factura.getId() + ";" + 
					factura.getClass().getSimpleName() +  ";" + 
					factura.getFechaEntrada().format(DateTimeFormatter.ISO_LOCAL_DATE) +  ";" + 
					LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE) +  ";" + 
					factura.getPrecio() + "\n";
			bfw.write(line);
		} catch (IOException e) {
			System.out.println("Error añadiendo facturacion");
			System.out.println("Error: " + e.getMessage());
		}
	}
}
