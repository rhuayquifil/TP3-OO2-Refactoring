package ar.unrn.eje2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Recaudacion {

	public static List<Map<String, String>> where(Map<String, String> options) throws IOException {

		// aplique la regla FIRST CLASS COLLECTIONS para csvData

		CSVData csvData = new CSVData("data.csv");

		if (options.containsKey("company_name")) {
			csvData.filtroKey(options.get("company_name"), 1);
		}

		if (options.containsKey("city")) {
			csvData.filtroKey(options.get("city"), 4);
		}

		if (options.containsKey("state")) {
			csvData.filtroKey(options.get("state"), 5);
		}

		if (options.containsKey("round")) {
			csvData.filtroKey(options.get("round"), 9);
		}

		return csvData.salida();
	}

}