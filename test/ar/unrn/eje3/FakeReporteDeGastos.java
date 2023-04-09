package ar.unrn.eje3;

import java.util.List;

public class FakeReporteDeGastos {
	private Fecha helpDate;
	private int reporteGastoDeComida;
	private int reporteTotal;

	public FakeReporteDeGastos(Fecha helpDate) {
		super();
		this.helpDate = helpDate;
		this.reporteGastoDeComida = 0;
		this.reporteTotal = 0;
	}

	public StringBuffer imprimir(List<Gasto> gastos) {
		int total = 0;
		int gastosDeComida = 0;
		StringBuffer reporte = new StringBuffer();

		reporte.append("Expenses " + helpDate.now() + '\n');

		for (Gasto gasto : gastos) {
			if (gasto.Cena() || gasto.Desayuno()) {
				gastosDeComida += gasto.monto();
			}

			String marcaExcesoComidas = (gasto.Cena() && gasto.monto() > 5000
					|| gasto.Desayuno() && gasto.monto() > 1000) ? "X" : " ";

			reporte.append(gasto.nombre() + "\t" + gasto.monto() + "\t" + marcaExcesoComidas + '\n');
			total += gasto.monto();

		}

		reporteGastoDeComida = gastosDeComida;
		reporteTotal = total;
		reporte.append("Gastos de comida: " + gastosDeComida + '\n');
		reporte.append("Total de gastos: " + total + '\n');

		return reporte;
	}

	int gastoDeComida() {
		return reporteGastoDeComida;
	}
}
