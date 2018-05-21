package exRafaelASojoRuiz.negocio.excepciones;

public class ProductoYaExisteException extends Exception {

	private static final long serialVersionUID = 5575855922529688598L;

	public ProductoYaExisteException(String mensaje){
		super(mensaje);
	}
}
 