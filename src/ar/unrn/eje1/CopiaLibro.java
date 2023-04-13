package ar.unrn.eje1;

public class CopiaLibro {
	private Libro libro;

	public CopiaLibro(Libro libro) {
		this.libro = libro;
	}

	public Libro libro() {
		return libro;
	}

	public double calcularMontoAlquiler(int diasAlquilados) {
		return libro.calcularMontoAlquiler(diasAlquilados);
	}

//	public boolean libroNuevoLanzamiento() {
//		return libro.nuevoLanzamiento();
//	}

	public int puntosPorNuevoLanzamiento(int diasAlquilados) {
		return libro.puntosPorNuevoLanzamiento(diasAlquilados);
	}
}