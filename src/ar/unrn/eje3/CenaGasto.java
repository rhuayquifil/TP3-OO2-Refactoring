package ar.unrn.eje3;

public class CenaGasto extends Gasto {

	enum TipoDeGasto {
		CENA
	}

	public CenaGasto(int monto) {
		super(monto);
	}

	@Override
	public boolean Cena() {
		return true;
	}

	@Override
	public boolean Desayuno() {
		return false;
	}

	@Override
	public boolean AlquilerAuto() {
		return false;
	}

	@Override
	public String nombre() {
		return String.valueOf(TipoDeGasto.CENA);
	}
}
