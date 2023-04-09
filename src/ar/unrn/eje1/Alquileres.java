package ar.unrn.eje1;

import java.util.ArrayList;
import java.util.List;

public class Alquileres {

	private List<Alquiler> alquileres;

	public Alquileres() {
		this.alquileres = new ArrayList<Alquiler>();
	}

	public void agregar(Alquiler rental) {
		this.alquileres.add(rental);
	}

	public int cantidadDeAlquileres() {
		return alquileres.size();
	}

	public Object[] calcularTotalDeudaYPuntos() {
		Object[] resultado = new Object[2];
		int puntosAlquilerFrecuente = 0; // puntos obtenidos
		double total = 0;

		// aplique polimorfismo
		for (Alquiler alquiler : alquileres) {
			total += alquiler.calcularMonto();

			puntosAlquilerFrecuente++;

			// aplique extract method
			puntosAlquilerFrecuente += bonusPorDosDíasDeAlquilerDeUnNuevoLanzamiento(alquiler);

		}

		resultado[0] = total;
		resultado[1] = puntosAlquilerFrecuente;

		return resultado;
	}

	private int bonusPorDosDíasDeAlquilerDeUnNuevoLanzamiento(Alquiler alquiler) {
		// aplique Tell, Don't Ask para saber si era de lanzamiento y dias alquilados
		if ((alquiler.nuevoLanzamiento()) && alquiler.diasAlquilados() > 1) {
			return 1;
		}
		return 0;
	}
}