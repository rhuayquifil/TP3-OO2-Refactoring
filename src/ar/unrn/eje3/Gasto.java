package ar.unrn.eje3;

public abstract class Gasto {

//	enum TipoDeGasto {
//		CENA, DESAYUNO, ALQUILER_AUTO
//	}

	private int monto;

	public Gasto(int monto) {
		this.monto = monto;
	}

	public int monto() {
		return monto;
	}

	public abstract String nombre();

	public abstract boolean exceso();

	public abstract int comida();
}
