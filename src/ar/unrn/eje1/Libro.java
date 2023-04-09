package ar.unrn.eje1;

public class Libro {
//	public static final int INFANTILES = 2;
//	public static final int REGULARES = 0;
//	public static final int NUEVO_LANZAMIENTO = 1;

	private String nombre;
	private CodigoPrecio codigoPrecio;

	public Libro(String nombre, CodigoPrecio priceCode) {
		this.nombre = nombre;
		this.codigoPrecio = priceCode;
	}

	public CodigoPrecio codigoPrecio() {
		return codigoPrecio;
	}

	public String nombre() {
		return nombre;
	}

	public double calcularMontoAlquiler(int diasAlquilados) {
		return codigoPrecio.calcularCosto(diasAlquilados);
	}

	public boolean nuevoLanzamiento() {
		return codigoPrecio.nuevoLanzamiento();
	}
}