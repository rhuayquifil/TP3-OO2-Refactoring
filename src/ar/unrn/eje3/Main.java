package ar.unrn.eje3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Gasto primerGasto = new CenaGasto(10);
		Gasto segundoGasto = new CenaGasto(20);
		Gasto tercerGasto = new AlquilerAutoGasto(70);

		List<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(primerGasto);
		gastos.add(segundoGasto);
		gastos.add(tercerGasto);

		ReporteDeGastos reporte = new ReporteDeGastos(new HelpDate());
		System.out.println(reporte.imprimir(gastos));
	}

}
