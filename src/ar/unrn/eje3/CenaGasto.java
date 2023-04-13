package ar.unrn.eje3;

public class CenaGasto extends Gasto {

	enum TipoDeGasto {
		CENA
	}

	public CenaGasto(int monto) {
		super(monto);
	}

	@Override
	public String nombre() {
		return String.valueOf(TipoDeGasto.CENA);
	}

	@Override
	public boolean exceso() {
		return super.monto() > 5000;
	}

	@Override
	public int comida() {
		return super.monto();
	}
}
