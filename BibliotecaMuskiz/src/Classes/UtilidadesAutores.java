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

    //autor con más libros
    public static String autorMasLibros(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) {
            return null;
        }
        Autores maxAutor = autores.get(0);
        for (Autores a : autores) {
            if (a.getLibrosEscritos().size() > maxAutor.getLibrosEscritos().size()) {
                maxAutor = a;
            }
        }
        return maxAutor.getNombre();
    }

    //autor con menos libros
    public static String autorMenosLibros(List<Autores> autores) {
            if (autores == null || autores.isEmpty()) {
                return null;
            }
            Autores minAutor = autores.get(0);
            for (Autores a : autores) {
                if (a.getLibrosEscritos().size() < minAutor.getLibrosEscritos().size()) {
                    minAutor = a;
                }
            }
            return minAutor.getNombre();
    }

    //autor con el libros mas largo
    public static String autorLibroMasLargo(List<Autores> autores, List<Libros> libros) {
        Autores maxAutor = null;
        int maxPaginas = -1;

        for (Autores a : autores) {
            for (int idLibro : a.getLibrosEscritos()) {
                Libros l = libros.stream().filter(lib -> lib.getIdLibro() == idLibro).findFirst().orElse(null);
                if (l != null && l.getNumeroPaginas() > maxPaginas) {
                    maxPaginas = l.getNumeroPaginas();
                    maxAutor = a;
                }
            }
        }

        return maxAutor != null ? maxAutor.getNombre() : null;
    }

    //autor con el libros mas corto
    public static String autorLibroMasCorto(List<Autores> autores, List<Libros> libros) {
        Autores minAutor = null;
        int minPaginas = -1;

        for (Autores a : autores) {
            for (int idLibro : a.getLibrosEscritos()) {
                Libros l = libros.stream().filter(lib -> lib.getIdLibro() == idLibro).findFirst().orElse(null);
                if (l != null && l.getNumeroPaginas() < minPaginas) {
                    minPaginas = l.getNumeroPaginas();
                    minAutor = a;
                }
            }
        }

        return minAutor != null ? minAutor.getNombre() : null;
    }

    //autor más viejo
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

    //autor más joven
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

    //edad media autores
    public static double edadMediaAutores(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) return 0;
        double total = 0;
        int yearActual = 2026;

        for (Autores a : autores) {
            int nacimiento = Integer.parseInt(a.getFechaNacimiento().substring(0,4));
            int fin = a.getDefuncion() 
                    ? Integer.parseInt(a.getFechaFallecimiento().substring(0,4)) 
                    : yearActual;
            total += fin - nacimiento;
        }

        return total / autores.size();
    }

    //total de Autores en la biblioteca
    public static int totalAutores(List<Autores> autores) {
        if (autores == null) return 0;
        return autores.size();
    }
}