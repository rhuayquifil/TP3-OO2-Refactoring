package ar.unrn.eje1;

public class InfantilesCodigoPrecio implements CodigoPrecio {

	public InfantilesCodigoPrecio() {
		super();
	}

	@Override
	public double calcularCosto(int diasAlquilados) {
		double monto = 1.5;

		if (diasAlquilados > 3) {
			return monto += (diasAlquilados - 3) * 1.5;
		}

		return monto;
	}

	@Override
	public boolean nuevoLanzamiento() {
		return false;
	}

}
