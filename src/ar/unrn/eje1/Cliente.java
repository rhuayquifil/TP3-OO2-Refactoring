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

	}
}