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
    } //getter que devuelve el idLibro

    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() { 
        return autor.getNombre();
    } //getter que devuelve el nombre del autor
}