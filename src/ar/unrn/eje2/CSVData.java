package ar.unrn.eje2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVData {

	private List<String[]> csvData;

	public CSVData(String url) throws IOException {
		super();

		csvData = new ArrayList<String[]>();

		CSVReader reader = new CSVReader(new FileReader(url));

		String[] row = null;

		while ((row = reader.readNext()) != null) {
			csvData.add(row);
		}

		reader.close();
		csvData.remove(0);
	}

	public CSVData(List<String[]> filtro) {
		csvData = filtro;
	}

	public void filtroKey(Condicion condicion) {

		List<String[]> results = new ArrayList<String[]>();

		for (int i = 0; i < csvData.size(); i++) {
			// extract method
			aplicarAlFiltro(condicion, results, i);
		}

		csvData = results;
	}

	private static void aplicarAlFiltro(Condicion condicion, List<String[]> results, int indice) {

		// implementacion de lambda
		if (condicion.condicion(indice)) {
//			results.add(csvData.get(indice));
		}
	}

	public String get(int indice, int columna) {
		return csvData.get(indice)[columna];
	}

	public int size() {
		return csvData.size();
	}

	public String[] agregar(int indice) {
		return csvData.get(indice);
	}
}
