 package exRafaelASojoRuiz.negocio.excepciones;

public class NombreNoValidoException extends Exception {

	private static final long serialVersionUID = -3791929815137884490L;

	public NombreNoValidoException(String mensaje){
		super(mensaje);
	}
}
