package ar.unrn.eje3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Gasto primerGasto = new CenaGasto(1500);
		Gasto segundoGasto = new CenaGasto(8000);
		Gasto tercerGasto = new DesayunoGasto(800);
		Gasto cuartoGasto = new DesayunoGasto(500);

		List<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(primerGasto);
		gastos.add(segundoGasto);
		gastos.add(tercerGasto);
		gastos.add(cuartoGasto);

		ReporteDeGastos reporte = new ReporteDeGastos(new HelpDate());
		System.out.println(reporte.imprimir(gastos));
	}

}
