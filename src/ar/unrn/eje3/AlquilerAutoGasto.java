package ar.unrn.eje3;

public class AlquilerAutoGasto extends Gasto {

	enum TipoDeGasto {
		ALQUILER_AUTO
	}

	public AlquilerAutoGasto(int monto) {
		super(monto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String nombre() {
		return String.valueOf(TipoDeGasto.ALQUILER_AUTO);
	}

	@Override
	public boolean exceso() {
		return false;
	}

	@Override
	public int comida() {
		return 0;
	}
}
