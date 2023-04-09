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

	public abstract boolean Cena();

	public abstract boolean Desayuno();

	public abstract boolean AlquilerAuto();

	public abstract String nombre();
}
