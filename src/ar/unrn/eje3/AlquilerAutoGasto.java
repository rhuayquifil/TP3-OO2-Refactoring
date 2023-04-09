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
	public boolean Cena() {
		return false;
	}

	@Override
	public boolean Desayuno() {
		return false;
	}

	@Override
	public boolean AlquilerAuto() {
		return true;
	}

	@Override
	public String nombre() {
		return String.valueOf(TipoDeGasto.ALQUILER_AUTO);
	}
}
