package ar.unrn.eje3;

public class DesayunoGasto extends Gasto {

	enum TipoDeGasto {
		DESAYUNO
	}

	public DesayunoGasto(int monto) {
		super(monto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String nombre() {
		return String.valueOf(TipoDeGasto.DESAYUNO);
	}

	@Override
	public boolean exceso() {
		return super.monto() > 1000;
	}

	@Override
	public int comida() {
		return super.monto();
	}
}
