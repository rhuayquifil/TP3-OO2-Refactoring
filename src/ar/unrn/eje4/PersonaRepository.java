package ar.unrn.eje4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jdbi.v3.core.Jdbi;

public class PersonaRepository {

	private Jdbi jdbi;

	public PersonaRepository(Jdbi jdbi) {
		this.jdbi = jdbi;
	}

	/**
	 * Busca por nombre a parte
	 * 
	 * @throws PersonaRepositoryExceptions
	 */
	public List<Persona> buscarPorNombre(String nombreOParte) throws PersonaRepositoryExceptions {
		return jdbi.withHandle(handle -> {
			var rs = handle.select("select nombre, apellido from persona where nombre like ?")
					.bind(0, "%" + nombreOParte + "%").mapToMap(String.class).list();

			var personas = new ArrayList<Persona>();

			if (rs.size() == 0) {
				throw new PersonaRepositoryExceptions("es nulo");
			}

			for (Map<String, String> map : rs) {
				personas.add(new Persona(map.get("nombre"), map.get("apellido")));
			}

			return personas;
		});

	}

	/**
	 * Dado un id, retorna: - null si el id no se encuentra en la BD - la instancia
	 * de Persona encontrada
	 * 
	 * @throws PersonaRepositoryExceptions
	 */
	public Persona buscarId(Long id) throws PersonaRepositoryExceptions {
		return jdbi.withHandle(handle -> {

			var rs = handle.select("select nombre, apellido from persona where id_persona = ?").bind(0, id)
					.mapToMap(String.class).list();

			if (rs.size() == 0) {
				throw new PersonaRepositoryExceptions("es nulo");
			}

			return new Persona(rs.get(0).get("nombre"), rs.get(0).get("apellido"));

		});
	}

}
