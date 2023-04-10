package ar.unrn.eje3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PruebasUnitarias {

	@Test
	void reporteDeUnaCena() {
		Gasto primerGasto = new CenaGasto(1000);

		List<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(primerGasto);

		FakeReporteDeGastos reporte = new FakeReporteDeGastos(new HelpDate());
		StringBuffer resultado = reporte.imprimir(gastos);
		assertEquals(1000, reporte.gastoDeComida());
		assertEquals(1000, reporte.total());
	}

	@Test
	void reporteUnDesayunoYUnAlquiler() {
		Gasto primerGasto = new DesayunoGasto(600);
		Gasto segundoGasto = new AlquilerAutoGasto(1000);

		List<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(primerGasto);
		gastos.add(segundoGasto);

		FakeReporteDeGastos reporte = new FakeReporteDeGastos(new HelpDate());
		StringBuffer resultado = reporte.imprimir(gastos);
		assertEquals(600, reporte.gastoDeComida());
		assertEquals(1600, reporte.total());
	}

	@Test
	void reporteDeDosDesayunoyDosCena() {
		Gasto primerGasto = new CenaGasto(1500);
		Gasto segundoGasto = new CenaGasto(2000);
		Gasto tercerGasto = new DesayunoGasto(800);
		Gasto cuartoGasto = new DesayunoGasto(500);

		List<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(primerGasto);
		gastos.add(segundoGasto);
		gastos.add(tercerGasto);
		gastos.add(cuartoGasto);

		FakeReporteDeGastos reporte = new FakeReporteDeGastos(new HelpDate());
		StringBuffer resultado = reporte.imprimir(gastos);
		assertEquals(4800, reporte.gastoDeComida());
	}
}
