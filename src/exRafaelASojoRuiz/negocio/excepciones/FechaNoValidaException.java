 package exRafaelASojoRuiz.negocio.excepciones;

public class FechaNoValidaException extends Exception {

	private static final long serialVersionUID = -2350364704558750440L;

	public FechaNoValidaException(String mensaje){
		super(mensaje);
	}
}
