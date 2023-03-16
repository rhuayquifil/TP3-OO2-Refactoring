package ar.unrn.eje4;

import org.jdbi.v3.core.Jdbi;

public class SetUpDatabase {

  private Jdbi jdbi;
  
  public SetUpDatabase(Jdbi jdbi) {
    this.jdbi = jdbi;
  }
  
  public void setUp() {
    jdbi.useTransaction(handle -> {

      handle.execute("DROP SCHEMA PUBLIC CASCADE");

      handle.execute("CREATE TABLE persona (id_persona INT NOT NULL "
          + "primary key generated always as identity (start with 1,increment by 1), "
          + "nombre VARCHAR(255), apellido VARCHAR(255))");
      
      handle.createUpdate("INSERT INTO persona (nombre, apellido) VALUES (?, ?)")
      .bind(0, "José").bind(1, "Laurenti").execute();

      handle.createUpdate("INSERT INTO persona (nombre, apellido) VALUES (?, ?)")
      .bind(0, "Esteban").bind(1, "Otermon").execute();
      
      handle.createUpdate("INSERT INTO persona (nombre, apellido) VALUES (?, ?)")
      .bind(0, "Vladimir").bind(1, "Varkov").execute();    
      
    });
  }
}
