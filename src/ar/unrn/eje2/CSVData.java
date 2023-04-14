package ar.unrn.eje2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class CSVData {

	// se cambio a estatico, resolve esto sino funciona
	private static List<String[]> csvData;

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

	public void filtroKey(String key, int columna) {

		List<String[]> results = new ArrayList<String[]>();

		for (int i = 0; i < csvData.size(); i++) {
			// extract method
			aplicarAlFiltro((int indice) -> csvData.get(indice)[columna].equals(key), results, i);

		}

		csvData = results;
	}

	private static void aplicarAlFiltro(Condicion condicion, List<String[]> results, int indice) {

		// implementacion de lambda
		if (condicion.condicion(indice)) {
			results.add(csvData.get(indice));
		}
	}

	// devolver esto en cvsdata
	public List<Map<String, String>> salida() {
		List<Map<String, String>> output = new ArrayList<Map<String, String>>();

		// toma los datos de la nueva clase CSVData
		for (int i = 0; i < csvData.size(); i++) {
			Map<String, String> mapped = new HashMap<String, String>();
			mapped.put("permalink", csvData.get(i)[0]);
			mapped.put("company_name", csvData.get(i)[1]);
			mapped.put("number_employees", csvData.get(i)[2]);
			mapped.put("category", csvData.get(i)[3]);
			mapped.put("city", csvData.get(i)[4]);
			mapped.put("state", csvData.get(i)[5]);
			mapped.put("funded_date", csvData.get(i)[6]);
			mapped.put("raised_amount", csvData.get(i)[7]);
			mapped.put("raised_currency", csvData.get(i)[8]);
			mapped.put("round", csvData.get(i)[9]);
			output.add(mapped);
		}
		return output;
	}
}
