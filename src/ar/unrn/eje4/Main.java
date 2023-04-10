package ar.unrn.eje4;

import java.util.List;

import org.jdbi.v3.core.Jdbi;

public class Main {

	public static void main(String[] args) {

		Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

		new SetUpDatabase(jdbi).setUp();

		try {
			var repo = new PersonaRepository(jdbi);

			var personas = repo.buscarPorNombre("Vla");

			imprimir(personas);

			var persona = repo.buscarId(1L);

			System.out.println(persona.nombre() + " " + persona.apellido());

		} catch (PersonaRepositoryExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	private static void imprimir(List<Persona> personas) {
		for (Persona persona : personas) {
			System.out.println(persona.nombre() + " " + persona.apellido());
		}
	}
}
