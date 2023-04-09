package ar.unrn.eje1;

public class NuevoLanzamientoCodigoLibro implements CodigoPrecio {

	public NuevoLanzamientoCodigoLibro() {
		super();
	}

	@Override
	public double calcularCosto(int diasAlquilados) {

		return diasAlquilados * 3;

	}

	@Override
	public boolean nuevoLanzamiento() {
		return true;
	}

}
