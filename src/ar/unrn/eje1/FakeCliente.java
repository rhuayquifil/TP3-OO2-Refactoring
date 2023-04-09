package ar.unrn.eje1;

import ar.unrn.eje1.Alquiler;
import ar.unrn.eje1.Alquileres;

public class FakeCliente {
	private Alquileres alquileres;
	private String name;
	private Object deuda;
	private Object puntosObtenidos;

	public FakeCliente(String nombre) {
		this.name = nombre;
		this.alquileres = new Alquileres();
	}

	public void alquilar(Alquiler rental) {
		alquileres.agregar(rental);
	}

	public Object[] calcularDeudaYPuntosObtenidos() {
		Object[] resultado = alquileres.calcularTotalDeudaYPuntos();
		this.deuda = resultado[0];
		this.puntosObtenidos = resultado[1];
		return resultado;
	}

	Object deuda() {
		return this.deuda;
	}

	public Object puntosObtenidos() {
		return this.puntosObtenidos;
	}
}