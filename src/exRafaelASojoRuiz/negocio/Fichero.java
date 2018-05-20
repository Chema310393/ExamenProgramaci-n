package exRafaelASojoRuiz.negocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.JOptionPane;

import exRafaelASojoRuiz.negocio.excepciones.FicheroNoExisteException;

public class Fichero {

	private static final File FICHERO = new File("rafaelSojo.txt");

	public static String leerFichero() throws FicheroNoExisteException, FileNotFoundException, IOException {
		String mensaje = "";
		String linea;
		if (!FICHERO.exists())
			throw new FicheroNoExisteException("No hay ningún fichero que leer.");
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			while ((linea = br.readLine()) != null)
				mensaje += linea + "\n";
			return mensaje;
		}
	}

	public static void escribirFichero() throws FileNotFoundException, IOException {
		if (FICHERO.exists())
			JOptionPane.showMessageDialog(null, "Voy a machacar el fichero");

		LocalDate fecha = LocalDate.now();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
			bw.write("Bienvenido al examen final");
			bw.newLine();
			bw.write(fecha.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + " de " + fecha.getYear());
			bw.newLine();
			bw.write("Hoy es día " + fecha.getDayOfMonth() + ", "
					+ fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()) + ".");
			bw.newLine();
			bw.write("Rafael Á. Sojo Ruíz");
		}

	}
}
