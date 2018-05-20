package exRafaelASojoRuiz.negocio;

import java.util.ArrayList;
import java.util.ListIterator;

import exRafaelASojoRuiz.negocio.excepciones.NombreNoValidoException;
import exRafaelASojoRuiz.negocio.excepciones.ProductoYaExisteException;

public class Stock {

	public static  ArrayList<Producto> almacen  = new ArrayList<Producto>();
	

	public static  void altaProducto(Producto producto) throws ProductoYaExisteException {
		if (almacen.contains(producto))
			throw new ProductoYaExisteException("El producto ya existe");
		almacen.add(producto);
	}

	public static void altaPerecedero(Perecedero perecedero) throws ProductoYaExisteException, NombreNoValidoException {
		if (almacen.contains(new Producto(perecedero.getNombre())))
			throw new ProductoYaExisteException("El producto perecedero ya existe");
		almacen.add(perecedero);
	}

	public static ListIterator<Producto> getIterator() {
		return almacen.listIterator();
	}

	public static int getNumeroProductos() {
		return almacen.size();
	}

}
