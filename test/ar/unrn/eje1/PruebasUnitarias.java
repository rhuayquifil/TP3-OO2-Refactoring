package ar.unrn.eje1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.unrn.eje1.Alquiler;
import ar.unrn.eje1.CodigoPrecio;
import ar.unrn.eje1.CopiaLibro;
import ar.unrn.eje1.InfantilesCodigoPrecio;
import ar.unrn.eje1.Libro;
import ar.unrn.eje1.NuevoLanzamientoCodigoLibro;
import ar.unrn.eje1.RegularesCodigoPrecio;

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

		FakeCliente yo = new FakeCliente("Javier");

		yo.alquilar(alquilerElTunel);
		yo.alquilar(alquilerAntesDelFin);

		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();

		assertEquals(yo.deuda(), resultado[0]);
		assertEquals(yo.puntosObtenidos(), resultado[1]);
	}

	@Test
	void alquilerUnLibroRegularesYUnNuevoLanzamiento() {
		CodigoPrecio regulares = new RegularesCodigoPrecio();
		CodigoPrecio nuevoLanzamiento = new NuevoLanzamientoCodigoLibro();

		Libro elTunel = new Libro("El Túnel", nuevoLanzamiento);
		Libro antesDelFin = new Libro("Antes del Fin", regulares);

		CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
		CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);

		Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
		Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);

		FakeCliente yo = new FakeCliente("Javier");

		yo.alquilar(alquilerElTunel);
		yo.alquilar(alquilerAntesDelFin);

		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();

		assertEquals(yo.deuda(), resultado[0]);
		assertEquals(yo.puntosObtenidos(), resultado[1]);
	}

	@Test
	void alquilerUnLibroInfantiles() {
		CodigoPrecio infantiles = new InfantilesCodigoPrecio();

		Libro elTunel = new Libro("El Túnel", infantiles);

		CopiaLibro elTunelCopia = new CopiaLibro(elTunel);

		Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);

		FakeCliente yo = new FakeCliente("Javier");

		yo.alquilar(alquilerElTunel);

		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();

		assertEquals(yo.deuda(), resultado[0]);
		assertEquals(yo.puntosObtenidos(), resultado[1]);
	}
}
