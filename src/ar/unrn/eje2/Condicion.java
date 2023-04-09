package ar.unrn.eje2;

public interface Condicion {

//	boolean condicion(Map<String, String> options) throws NullPointerException;

//	boolean condicion(Map<String, String> options, int indice, List<String[]> csvData) throws NullPointerException;

//	boolean condicion(Map<String, String> options, int indice, CSVData csvData) throws NullPointerException;

	boolean condicion(int indice, CSVData csvData) throws NullPointerException;
}
