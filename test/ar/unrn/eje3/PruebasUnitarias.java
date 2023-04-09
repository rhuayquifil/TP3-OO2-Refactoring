package ar.unrn.eje3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PruebasUnitarias {

	@Test
	void reporteDeUnaCena() {
		Gasto primerGasto = new CenaGasto(10);

		List<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(primerGasto);

		FakeReporteDeGastos reporte = new FakeReporteDeGastos(new HelpDate());
		StringBuffer resultado = reporte.imprimir(gastos);
		assertEquals(10, reporte.gastoDeComida());
	}

}
