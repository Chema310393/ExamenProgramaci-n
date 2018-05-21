package exRafaelASojoRuiz.negocio.excepciones;

public class FicheroNoExisteException extends Exception {

	private static final long serialVersionUID = 7737394034600080421L;

	public FicheroNoExisteException(String mensaje) {
		super(mensaje);
	}
} 
