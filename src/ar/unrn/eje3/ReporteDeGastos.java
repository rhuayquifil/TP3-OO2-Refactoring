package ar.unrn.eje3;

import java.util.List;

public class ReporteDeGastos {

	private Fecha helpDate;

	public ReporteDeGastos(Fecha helpDate) {
		super();
		this.helpDate = helpDate;
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

		reporte.append("Gastos de comida: " + gastosDeComida + '\n');
		reporte.append("Total de gastos: " + total + '\n');

		return reporte;
	}
}
