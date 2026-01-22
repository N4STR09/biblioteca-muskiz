package Classes;

import java.util.List;

public class UtilidadesAutores {
    
    //Bloque 1: Estadisticas de libros por autor
    //-----------------------------
    //Autor que más libros tiene en la biblioteca
    //Autor que menos libros tiene en la biblioteca

    //Bloque 2: Estadisticas de paginas por libro de autor
    //-----------------------------
    //Autor con el libro con más largo
    //Autor con el libro con más corto
    
    //Bloque 3: Edades de autores
    //-----------------------------
    //Autor más viejo
    //Autor más joven
    //Edad media de los autores

    //Bloque 4: Estadisticas de autores
    //-----------------------------
    //Total de Autores en la biblioteca
    
    
    
    
    //Autor con más libros en la biblioteca
    public static String autorMasLibros(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) return null;
        int maxAutor = 0;
        for (int i = 0; i < autores.size(); i++) {
            if (autores.get(i).getidLibros().size() > autores.get(maxAutor).getidLibros().size()) {
                maxAutor = i;
            }
        }
        return autores.get(maxAutor).getNombre();
    }

    //Autor con menos libros en la biblioteca
    public static String autorMenosLibros(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) return null;
        int minAutor = 0;
        for (int i = 0; i < autores.size(); i++) {
            if (autores.get(i).getidLibro().size() < autores.get(minAutor).getidLibros().size()) {
                minAutor = i;
            }
        }
        return autores.get(minAutor).getNombre();
    }



    //Autor con el libro más largo
    public static String autorLibroMasLargo(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) return null;
        int maxPaginas = 0;
        for (int i = 0; i < autores.size(); i++) {
            for (int j = 0; j < autores.get(i).getLibros().size(); j++) {
                if (autores.get(i).getidLibros().get(j).getNumPaginas() > autores.get(maxPaginas).getidLibros().get(0).getNumPaginas()) {
                    maxPaginas = i;
                }
            }
        }
        return autores.get(maxPaginas).getNombre();
    }

    //Autor con el libro más corto
    public static String autorLibroMasCorto(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) return null;
        int minPaginas = 0;
        for (int i = 0; i < autores.size(); i++) {
            for (Libros libro : autores.get(i).getidLibros()) {
                if (libro.getNumeroPaginas() < autores.get(minPaginas).getidLibros().get(0).getNumeroPaginas()) {
                    minPaginas = i;
                }
            }
        }
        return autores.get(minPaginas).getNombre();
    }



    //Autor más viejo
    public static String autorMasViejo(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) return null;
        int maxEdad = 0;
        for (int i = 0; i < autores.size(); i++) {
            if (autores.get(i).getEdad() > autores.get(maxEdad).getEdad()) {
                maxEdad = i;
            }
        }
        return autores.get(maxEdad).getNombre();
    }

    //Autor más joven
    public static String autorMasJoven(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) return null;
        int minEdad = 0;
        for (int i = 0; i < autores.size(); i++) {
            if (autores.get(i).getEdad() < autores.get(minEdad).getEdad()) {
                minEdad = i;
            }
        }
        return autores.get(minEdad).getNombre();
    }

    //Edad media de los autores
    public static double edadMediaAutores(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) return 0;
        double edades = 0;
        for (Autores autor : autores) {

            if (autor.getDefuncion()) {
                edades += autor.getFechaFallecimiento() - autor.getFechaNacimiento();
            } else {
                edades += 2026 - autor.getFechaNacimiento();
            }
        }
        return edades / autores.size();
    }



    //Total de Autores en la biblioteca
    public static int totalAutores(List<Autores> autores) {
        if (autores == null) return 0;
        return autores.size();
    }
}