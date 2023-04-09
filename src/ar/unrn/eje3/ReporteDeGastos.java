package ar.unrn.eje3;

import java.util.List;

//class Gasto {
//	TipoDeGasto tipoGasto;
//	int monto;
//}

public class ReporteDeGastos {

	private Fecha helpDate;

	public ReporteDeGastos(Fecha helpDate) {
		super();
		this.helpDate = helpDate;
	}

	public String imprimir(List<Gasto> gastos) {
		int total = 0;
		int gastosDeComida = 0;
		String reporte = "";

		reporte += "Expenses " + helpDate.now() + '\n';

		for (Gasto gasto : gastos) {
			if (gasto.Cena() || gasto.Desayuno()) {
				gastosDeComida += gasto.monto();
			}

			String marcaExcesoComidas = (gasto.Cena() && gasto.monto() > 5000
					|| gasto.Desayuno() && gasto.monto() > 1000) ? "X" : " ";

			reporte += gasto.nombre() + "\t" + gasto.monto() + "\t" + marcaExcesoComidas + '\n';

			total += gasto.monto();

		}

		reporte += "Gastos de comida: " + gastosDeComida + '\n';
		reporte += "Total de gastos: " + total + '\n';

		return reporte;
	}
}
