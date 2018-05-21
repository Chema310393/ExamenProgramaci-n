package exRafaelASojoRuiz.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import exRafaelASojoRuiz.negocio.Stock;
import exRafaelASojoRuiz.negocio.excepciones.FechaNoValidaException;
import exRafaelASojoRuiz.negocio.excepciones.NombreNoValidoException;
import exRafaelASojoRuiz.negocio.excepciones.ProductoYaExisteException;

public class AltaProducto extends VentanaPadre {

	private static final long serialVersionUID = 4178253007506723500L;
	private MostrarStock mostrarStock = new MostrarStock();

	public AltaProducto() {
		super();
		preparar();
	} 

	protected void preparar() {
		setTitle("Alta de productos");
		
		btnBotonIzquierda.setText("Añadir");
		btnBotonDerecha.setText("Mostrar Stock");
		
		btnBotonDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Stock.getNumeroProductos() == 0)
					JOptionPane.showMessageDialog(contentPanel, "No hay productos que mostrar");
				else
					mostrarStock();
			}

		});
		
		btnBotonIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaProducto();
				limpiar();
			}
		});
	}
	
	
	
	void mostrarStock() {
		mostrarStock.setVisible(true);
		this.setVisible(false);
	}

	 void altaProducto() {
		try {
			if (textFieldFecha.getText().length() == 0)
				Stock.altaProducto(textFieldNombre.getText());
			else
				Stock.altaPerecedero(textFieldNombre.getText(), textFieldFecha.getText());
		} catch (NombreNoValidoException | FechaNoValidaException | ProductoYaExisteException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage());
		}
	}
}

