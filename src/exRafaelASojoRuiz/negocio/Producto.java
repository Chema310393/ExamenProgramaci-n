package exRafaelASojoRuiz.negocio;

import java.util.regex.Pattern;

import exRafaelASojoRuiz.negocio.excepciones.NombreNoValidoException;

public class Producto {
	
	String nombre;
	private static final Pattern patron = Pattern.compile("^([a-zA-Z]{3,}?)(\\s[a-zA-Z]{3,}?)*$");

	public Producto(String nombre) throws NombreNoValidoException{
		setNombre(nombre);
	}

	private void checkearNombre(String nombre) throws NombreNoValidoException {
		if(!patron.matcher(nombre).matches())
			throw new NombreNoValidoException("El nombre del producto no es válido: "+nombre);
	}
	private void setNombre(String nombre) throws NombreNoValidoException {
		checkearNombre(nombre);
		this.nombre = nombre;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}

}
