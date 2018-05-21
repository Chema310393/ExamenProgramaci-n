package exRafaelASojoRuiz.gui;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exRafaelASojoRuiz.negocio.Fichero;
import exRafaelASojoRuiz.negocio.excepciones.FicheroNoExisteException;

public class Principal {

	private static JFrame frame;

	public static void main(String[] args) {
		leer();
		escribir();
		mostrarAlta();
	}

	private static AltaProducto altaProducto = new AltaProducto();
	private static void mostrarAlta() {
		altaProducto.setVisible(true);
	}

	private static void escribir() {
		try {
			if (Fichero.existeFichero())
				JOptionPane.showMessageDialog(null, "Voy a machacar el fichero");
			Fichero.escribirFichero();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
	}

	private static void leer() {
		try {
			JOptionPane.showMessageDialog(frame, Fichero.leerFichero());
		} catch (FicheroNoExisteException | IOException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
	}

}
