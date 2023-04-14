package ar.unrn.eje1;

public class Main {
	public static void main(String args[]) {

		CodigoPrecio regulares = new RegularesCodigoPrecio();
		CodigoPrecio infantiles = new InfantilesCodigoPrecio();
		CodigoPrecio nuevoLanzamiento = new NuevoLanzamientoCodigoLibro();

		Libro elTunel = new Libro("El Túnel", infantiles);
//		Libro antesDelFin = new Libro("Antes del Fin", nuevoLanzamiento);
		CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
//		CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);
		Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
//		Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);
		Cliente yo = new Cliente("Javier");
		yo.alquilar(alquilerElTunel);
//		yo.alquilar(alquilerAntesDelFin);
		Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
		System.out.println(resultado[0]);
		System.out.println(resultado[1]);
	}
}