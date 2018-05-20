package exRafaelASojoRuiz.negocio;

import java.util.regex.Pattern;

import exRafaelASojoRuiz.negocio.excepciones.FechaNoValidaException;
import exRafaelASojoRuiz.negocio.excepciones.NombreNoValidoException;

public class Perecedero extends Producto {
	String fechaCaducidad;
	private static final Pattern patron = Pattern.compile("^[0-3]?\\d{1}\\/[0-1]?\\d\\/\\d{4}$");
	
	public Perecedero(String nombre, String fechaCaducidad) throws FechaNoValidaException, NombreNoValidoException{
		super(nombre);
		setFechaCaducidad(fechaCaducidad);
	}

	private void setFechaCaducidad(String fechaCaducidad) throws FechaNoValidaException {
		checkearFecha(fechaCaducidad);
		this.fechaCaducidad = fechaCaducidad;
		
	}

	private void checkearFecha(String fecha) throws FechaNoValidaException {
		if(!patron.matcher(fecha).matches())
			throw new FechaNoValidaException("La fecha de caducidad no es válida: "+fecha);
	}
	
	
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	
	
	
	
}
