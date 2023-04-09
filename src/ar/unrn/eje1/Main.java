package ar.unrn.eje1;

import ar.unrn.eje1.Alquiler;
import ar.unrn.eje1.Cliente;
import ar.unrn.eje1.CodigoPrecio;
import ar.unrn.eje1.CopiaLibro;
import ar.unrn.eje1.InfantilesCodigoPrecio;
import ar.unrn.eje1.Libro;
import ar.unrn.eje1.NuevoLanzamientoCodigoLibro;
import ar.unrn.eje1.RegularesCodigoPrecio;

public class Main {
	public static void main(String args[]) {

		CodigoPrecio regulares = new RegularesCodigoPrecio();
		CodigoPrecio infantiles = new InfantilesCodigoPrecio();
		CodigoPrecio nuevoLanzamiento = new NuevoLanzamientoCodigoLibro();

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
		System.out.println(resultado[0]);
		System.out.println(resultado[1]);
	}
}