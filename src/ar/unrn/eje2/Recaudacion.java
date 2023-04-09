package ar.unrn.eje2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {

	public static List<Map<String, String>> where(Map<String, String> options) throws IOException {

		// aplique la regla FIRST CLASS COLLECTIONS para csvData

		CSVData csvData = new CSVData("data.csv");

		if (options.containsKey("company_name")) {

//			csvData = filtro(new Condicion() {
//
//				public boolean condicion(Map<String, String> options, int indice, List<String[]> csvData)
//						throws NullPointerException {
//					return csvData.get(indice)[1].equals(options.get("company_name"));
//				}
//			}, options, csvData);

//			csvData = filtro(((Map<String, String> opciones, int indice,
//					List<String[]> csvDatos) -> csvDatos.get(indice)[1].equals(opciones.get("company_name"))), options,
//					csvData);

			csvData = new CSVData(filtroKey(
					(int indice, CSVData csvDatos) -> csvDatos.get(indice, 1).equals(options.get("company_name")),
					csvData));
		}

		if (options.containsKey("city")) {
			csvData = new CSVData(filtroKey(
					(int indice, CSVData csvDatos) -> csvDatos.get(indice, 4).equals(options.get("city")), csvData));
		}

		if (options.containsKey("state")) {
			csvData = new CSVData(filtroKey(
					(int indice, CSVData csvDatos) -> csvDatos.get(indice, 5).equals(options.get("state")), csvData));
		}

		if (options.containsKey("round")) {
			csvData = new CSVData(filtroKey(
					(int indice, CSVData csvDatos) -> csvDatos.get(indice, 9).equals(options.get("round")), csvData));
		}

		return salida(csvData);
	}

	private static List<Map<String, String>> salida(CSVData csvData) {
		List<Map<String, String>> output = new ArrayList<Map<String, String>>();

		// toma los datos de la nueva clase CSVData
		for (int i = 0; i < csvData.size(); i++) {
			Map<String, String> mapped = new HashMap<String, String>();
			mapped.put("permalink", csvData.get(i, 0));
			mapped.put("company_name", csvData.get(i, 1));
			mapped.put("number_employees", csvData.get(i, 2));
			mapped.put("category", csvData.get(i, 3));
			mapped.put("city", csvData.get(i, 4));
			mapped.put("state", csvData.get(i, 5));
			mapped.put("funded_date", csvData.get(i, 6));
			mapped.put("raised_amount", csvData.get(i, 7));
			mapped.put("raised_currency", csvData.get(i, 8));
			mapped.put("round", csvData.get(i, 9));
			output.add(mapped);
		}
		return output;
	}

	private static List<String[]> filtroKey(Condicion condicion, CSVData csvData) {

		List<String[]> results = new ArrayList<String[]>();

		for (int i = 0; i < csvData.size(); i++) {
			// extract method
			aplicarAlFiltro(condicion, csvData, results, i);
		}
		return results;
	}

	private static void aplicarAlFiltro(Condicion condicion, CSVData csvData, List<String[]> results, int indice) {

		// implementacion de lambda
		if (condicion.condicion(indice, csvData)) {
			results.add(csvData.agregar(indice));
		}
	}
}