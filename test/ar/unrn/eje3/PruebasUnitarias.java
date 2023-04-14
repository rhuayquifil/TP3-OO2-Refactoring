package ar.unrn.eje3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PruebasUnitarias {

	@Test
	void reporteDeUnaCena() {
		Gasto primerGasto = new CenaGasto(1000);

		List<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(primerGasto);

		ReporteDeGastos reporte = new ReporteDeGastos(new HelpDate());

		StringBuffer esperado = new StringBuffer();
		HelpDate helpDate = new HelpDate();
		esperado.append("Expenses " + helpDate.now() + '\n');
		esperado.append("CENA" + "\t" + 1000 + "\t" + " " + '\n');
		esperado.append("Gastos de comida: " + 1000 + '\n');
		esperado.append("Total de gastos: " + 1000 + '\n');

		StringBuffer resultado = reporte.imprimir(gastos);

		assertEquals(esperado.toString(), resultado.toString());
	}

	@Test
	void reporteUnDesayunoYUnAlquiler() {
		Gasto primerGasto = new DesayunoGasto(600);
		Gasto segundoGasto = new AlquilerAutoGasto(1000);

		List<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(primerGasto);
		gastos.add(segundoGasto);

		ReporteDeGastos reporte = new ReporteDeGastos(new HelpDate());

		StringBuffer esperado = new StringBuffer();
		HelpDate helpDate = new HelpDate();
		esperado.append("Expenses " + helpDate.now() + '\n');
		esperado.append("DESAYUNO" + "\t" + 600 + "\t" + " " + '\n');
		esperado.append("ALQUILER_AUTO" + "\t" + 1000 + "\t" + " " + '\n');
		esperado.append("Gastos de comida: " + 600 + '\n');
		esperado.append("Total de gastos: " + 1600 + '\n');

		StringBuffer resultado = reporte.imprimir(gastos);

		assertEquals(esperado.toString(), resultado.toString());
	}

	@Test
	void reporteDeDosDesayunoyDosCena() {
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

		StringBuffer esperado = new StringBuffer();
		HelpDate helpDate = new HelpDate();
		esperado.append("Expenses " + helpDate.now() + '\n');
		esperado.append("CENA" + "\t" + 1500 + "\t" + " " + '\n');
		esperado.append("CENA" + "\t" + 8000 + "\t" + "X" + '\n');
		esperado.append("DESAYUNO" + "\t" + 800 + "\t" + " " + '\n');
		esperado.append("DESAYUNO" + "\t" + 500 + "\t" + " " + '\n');
		esperado.append("Gastos de comida: " + 10800 + '\n');
		esperado.append("Total de gastos: " + 10800 + '\n');

		StringBuffer resultado = reporte.imprimir(gastos);

		assertEquals(esperado.toString(), resultado.toString());
	}
}
