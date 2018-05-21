package exRafaelASojoRuiz.gui;


import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public abstract class VentanaPadre extends JDialog {

	private static final long serialVersionUID = 1L;

	final JPanel contentPanel = new JPanel();
	public JTextField textFieldNombre;
	public JTextField textFieldFecha;
	public JButton btnBotonDerecha;
	public JLabel lblNombre;
	public JLabel lblFechaCaducidad;
	public JButton btnBotonIzquierda;
	
	public VentanaPadre() {
		super();
		setListeners();
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		setResizable(false);
		setModal(true);
		setBounds(100, 100, 340, 145);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(51, 6, 76, 30);

		lblFechaCaducidad = new JLabel("Fecha Caducidad");
		lblFechaCaducidad.setBounds(51, 39, 99, 14);

		btnBotonIzquierda = new JButton("boton1");
		btnBotonIzquierda.setBounds(76, 67, 91, 23);

		btnBotonDerecha = new JButton("boton2");
		btnBotonDerecha.setBounds(177, 67, 117, 23);

		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(177, 36, 86, 20);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(177, 11, 86, 20);

		getContentPane().setLayout(null);
		getContentPane().add(btnBotonIzquierda);
		getContentPane().add(btnBotonDerecha);
		getContentPane().add(textFieldFecha);
		getContentPane().add(textFieldNombre);
		getContentPane().add(lblFechaCaducidad);
		getContentPane().add(lblNombre);

		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

	}

	private void setListeners() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salir();
			}
		});
	}

	void limpiar() {
		textFieldFecha.setText("");
		textFieldNombre.setText("");
	}

	
	void salir() {
		if (JOptionPane.showConfirmDialog(contentPanel, "¿Estás seguro de que deseas salir?", "Saliendo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(contentPanel, "Aaaaaaadios");
			System.exit(0);
		}
	}
	
	abstract void preparar();

}