package ar.unrn.eje1;

public class Cliente {

	// ACA APLIQUE LA REGLA FIRST CLASS COLLECTIONS, PORQUE CLIENTE TIENE VARIABLES
	// DE INSTANCIA Y LA LISTA DE ALQUILERES, POR ESO CREE LA CLASE ALQUILERES

//	private List<Alquiler> alquileres = new ArrayList<Alquiler>();
	private Alquileres alquileres;
	private String name;

	public Cliente(String nombre) {
		this.name = nombre;
		this.alquileres = new Alquileres();
	}

	public void alquilar(Alquiler rental) {
		alquileres.agregar(rental);
	}

	public Object[] calcularDeudaYPuntosObtenidos() {
		// aca movi toda la logica a la clase alquileres para despues aplicar
		// polimorfismo
		return alquileres.calcularTotalDeudaYPuntos();

//		Object[] resultado = new Object[2];
//	    double total = 0;
//	    int puntosAlquilerFrecuente = 0;
//	    for (Alquiler alquiler : alquileres) {
//	      double monto = 0;
//	// determine amounts for each line
//	      switch (alquiler.copia().libro().codigoPrecio()) {
//	      case Libro.REGULARES:
//	        monto += 2;
//	        if (alquiler.diasAlquilados() > 2)
//	          monto += (alquiler.diasAlquilados() - 2) * 1.5;
//	        break;
//	      case Libro.NUEVO_LANZAMIENTO:
//	        monto += alquiler.diasAlquilados() * 3;
//	        break;
//	      case Libro.INFANTILES:
//	        monto += 1.5;
//	        if (alquiler.diasAlquilados() > 3)
//	          monto += (alquiler.diasAlquilados() - 3) * 1.5;
//	        break;
//	      }
//	      total += monto;
//	      // sumo puntos por alquiler
//	      puntosAlquilerFrecuente++;
//	      // bonus por dos días de alquiler de un nuevo lanzamiento
//	      if ((alquiler.copia().libro().codigoPrecio() == Libro.NUEVO_LANZAMIENTO)
//	          && alquiler.diasAlquilados() > 1) {
//	        puntosAlquilerFrecuente++;
//	      }
//	    }
//	    resultado[0] = total;
//	    resultado[1] = puntosAlquilerFrecuente;
//	    return resultado;
	}
}