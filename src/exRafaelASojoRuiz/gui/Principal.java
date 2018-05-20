package exRafaelASojoRuiz.gui;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exRafaelASojoRuiz.negocio.Fichero;
import exRafaelASojoRuiz.negocio.excepciones.FicheroNoExisteException;

public class Principal {

	private static JFrame frame;

	public static void main(String[] args) {

		// Intentamos leer el fichero por primera vez
		leer();
		
		// Escribimos el fichero
		escribir();
		
		// Mostramos el alta de productos
		mostrarAlta();

	}

	static AltaProducto altaProducto = new AltaProducto();
	private static void mostrarAlta() {
		altaProducto.setVisible(true);
	}

	private static void escribir() {
		try {
			Fichero.escribirFichero();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
	}

	private static void leer() {
		try {
			JOptionPane.showMessageDialog(null, Fichero.leerFichero());
		} catch (FicheroNoExisteException | IOException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
	}
	
	


}
