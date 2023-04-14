package ar.unrn.eje1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PruebasUnitarias {

	@Test
	void alquilerDosLibrosRegulares() {
		CodigoPrecio regulares = new RegularesCodigoPrecio();

		Libro elTunel = new Libro("El Túnel", regulares);
		Libro antesDelFin = new Libro("Antes del Fin", regulares);

		CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
		CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);

		Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
		Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);

		Cliente yo = new Cliente("Javier");

		yo.alquilar(alquilerElTunel);
		yo.alquilar(alquilerAntesDelFin);

		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();

		assertEquals(10.0, resultado[0]);
		assertEquals(2, resultado[1]);
	}

	@Test
	void alquilerUnLibroRegularesYUnNuevoLanzamiento() {
		CodigoPrecio regulares = new RegularesCodigoPrecio();
		CodigoPrecio nuevoLanzamiento = new NuevoLanzamientoCodigoLibro();

		Libro elTunel = new Libro("El Túnel", regulares);
		Libro antesDelFin = new Libro("Antes del Fin", nuevoLanzamiento);

		CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
		CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);

		Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
		Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);

		Cliente yo = new Cliente("Javier");

		yo.alquilar(alquilerElTunel);
		yo.alquilar(alquilerAntesDelFin);

		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();

		assertEquals(15.5, resultado[0]);
		assertEquals(3, resultado[1]);
	}

	@Test
	void alquilerUnLibroInfantiles() {
		CodigoPrecio infantiles = new InfantilesCodigoPrecio();

		Libro elTunel = new Libro("El Túnel", infantiles);

		CopiaLibro elTunelCopia = new CopiaLibro(elTunel);

		Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);

		Cliente yo = new Cliente("Javier");

		yo.alquilar(alquilerElTunel);

		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();

		assertEquals(4.5, resultado[0]);
		assertEquals(1, resultado[1]);
	}
}
