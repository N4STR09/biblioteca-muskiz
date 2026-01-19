package Classes;
public class Libros {
    private int idLibro;
    private int existencias;
    private int numeroPaginas;
    private String titulo;
    private Autores autor;
    private String genero; //Se refiere al genero del libro: comedia, aventuras, fantasia...
    private String anioPublicacion;
    private String editorial;
    private String isbn;
    private String idioma;
    private String formato;
    private String portada; //Se mete un link de la portada
    private String descripcion;
    private String categoria; //Se refiere a la "tecnica" de escritura: literatura, poesia, teatro...
    private boolean disponibilidad;

    public Libros(int idLibro, int existencias, int numeroPaginas, String titulo, Autores autor, String genero, String anioPublicacion, String editorial, String isbn, String idioma, String formato, String portada, String descripcion, String categoria, boolean disponibilidad) {
        this.idLibro = idLibro;
        this.existencias = existencias;
        this.numeroPaginas = numeroPaginas;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.editorial = editorial;
        this.isbn = isbn;
        this.idioma = idioma;
        this.formato = formato;
        this.portada = portada;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.disponibilidad = disponibilidad;
    }

    public int getIdLibro() { 
        return idLibro; 
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() { 
        return autor.getNombre();
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
}