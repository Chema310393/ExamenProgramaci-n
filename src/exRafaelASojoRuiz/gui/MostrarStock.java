package exRafaelASojoRuiz.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ListIterator;

import exRafaelASojoRuiz.negocio.Perecedero;
import exRafaelASojoRuiz.negocio.Producto;
import exRafaelASojoRuiz.negocio.Stock;

public class MostrarStock extends VentanaPadre {

	private static final long serialVersionUID = 5602076721557029622L;
	private ListIterator<Producto> it;
	private int controlMovimiento = 0;
	private Producto producto;

	public MostrarStock() {
		super();
		preparar();

	}

	private void actualizarStock() {
		it = Stock.getIterator();
	}

	private void comprobarBotones() {
		btnBotonDerecha.setEnabled(true);
		btnBotonIzquierda.setEnabled(true);
		if (!it.hasNext())
			btnBotonDerecha.setEnabled(false);
		if (!it.hasPrevious())
			btnBotonIzquierda.setEnabled(false);

		if (Stock.getNumeroProductos() == 1) {
			btnBotonDerecha.setEnabled(false);
			btnBotonIzquierda.setEnabled(false);
		}

	}

	private void moverDerecha() {
		if (it.hasNext())
			producto = it.next();
		if (controlMovimiento == 1)
			if (it.hasNext())
				producto = it.next();
		controlMovimiento = 0;
	}

	private void moverIzquierda() {
		if (it.hasPrevious())
			producto = it.previous();
		if (controlMovimiento == 0)
			if (it.hasPrevious())
				producto = it.previous();
		controlMovimiento = 1;
	}

	private void mostrarProducto() {
		textFieldNombre.setText(producto.getNombre());
		if (producto instanceof Perecedero)
			textFieldFecha.setText(((Perecedero) producto).getFechaCaducidad());
		else
			textFieldFecha.setText("");
	}

	@Override
	void preparar() {

		setTitle("Stock");

		btnBotonIzquierda.setText("<");
		btnBotonDerecha.setText(">");

		textFieldFecha.setEditable(false);
		textFieldNombre.setEditable(false);

		setListeners();

	}

	private void setListeners() {

		btnBotonDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				moverDerecha();
				mostrarProducto();
				comprobarBotones();
			}
		});

		btnBotonIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverIzquierda();
				mostrarProducto();
				comprobarBotones();
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				actualizarStock();
				comprobarBotones();
				moverDerecha();
				mostrarProducto();
			}
		});

	}

}
