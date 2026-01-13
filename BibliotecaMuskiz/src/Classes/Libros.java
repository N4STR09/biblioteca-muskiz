package Classes;
public class Libros {
    private int id_titulo;
    private int existencias;
    private int numero_paginas;
    private String titulo;
    private String autor;
    private String genero; //Se refiere a si es Literatura dramática, lírica, narrativa...
    private String anio_publicacion;
    private String editorial;
    private String isbn;
    private String idioma;
    private String formato;
    private String portada; //Se mete un link de la portada
    private String descripcion;
    private String categoria; //Se refiere a si es de Literatura, Comedia, Drama...
    private boolean disponibilidad;

    public Libros(int id_titulo, int existencias, int numero_paginas, String titulo, String autor, String genero, String anio_publicacion, String editorial, String isbn, String idioma, String formato, String portada, String descripcion, String categoria, boolean disponibilidad) {
        this.id_titulo = id_titulo;
        this.existencias = existencias;
        this.numero_paginas = numero_paginas;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio_publicacion = anio_publicacion;
        this.editorial = editorial;
        this.isbn = isbn;
        this.idioma = idioma;
        this.formato = formato;
        this.portada = portada;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.disponibilidad = disponibilidad;
    }
}