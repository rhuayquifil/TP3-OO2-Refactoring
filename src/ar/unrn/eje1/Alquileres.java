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
//			puntosAlquilerFrecuente += bonusPorDosDíasDeAlquilerDeUnNuevoLanzamiento(alquiler);
			puntosAlquilerFrecuente += alquiler.puntosPorNuevoLanzamiento();

		}

		resultado[0] = total;
		resultado[1] = puntosAlquilerFrecuente;

		return resultado;
	}
}