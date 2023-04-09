package ar.unrn.eje1;

public class RegularesCodigoPrecio implements CodigoPrecio {

	public RegularesCodigoPrecio() {
		super();
	}

	@Override
	public double calcularCosto(int diasAlquilados) {
		double monto = 2;

		if (diasAlquilados > 2) {
			return monto += (diasAlquilados - 2) * 1.5;
		}

		return monto;
	}

	@Override
	public boolean nuevoLanzamiento() {
		return false;
	}

}
