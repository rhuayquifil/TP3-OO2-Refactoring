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
	public boolean Cena() {
		return false;
	}

	@Override
	public boolean Desayuno() {
		return true;
	}

	@Override
	public boolean AlquilerAuto() {
		return false;
	}

	@Override
	public String nombre() {
		return String.valueOf(TipoDeGasto.DESAYUNO);
	}
}
