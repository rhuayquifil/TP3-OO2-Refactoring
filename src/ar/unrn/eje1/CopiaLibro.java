package ar.unrn.eje1;

public class CopiaLibro {
  private Libro libro;

  public CopiaLibro(Libro libro) {
    this.libro = libro;
  }

  public Libro libro() {
    return libro;
  }
}