package Classes.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Classes.model.Libros;

public class UtilidadesLibros {
    
    //calculo media de paginas
    public static double mediaPaginas(List<Libros> libros) {
        if (libros == null || libros.isEmpty()) {
            return 0;
        }

        int totalPaginas = 0;
        for (Libros libro : libros) {
            totalPaginas += libro.getNumeroPaginas();
        }

        return (double) totalPaginas / libros.size();
    }

    //calculo maximo de paginas
    public static List<Libros> librosMaxPaginas(List<Libros> libros) {
        List<Libros> max = new ArrayList<>();
        if (libros == null || libros.isEmpty()) return max;

        int maxPaginas = 0;

        for (Libros l : libros) {
            if (l.getNumeroPaginas() > maxPaginas) {
                maxPaginas = l.getNumeroPaginas();
            }
        }

        for (Libros l : libros) {
            if (l.getNumeroPaginas() == maxPaginas) {
                max.add(l);
            }
        }

        return max;
    }

    //calculo minimo de paginas
    public static Libros minPaginas(List<Libros> libros) {
        if (libros == null || libros.isEmpty()) return null;

        Libros min = libros.get(0);
        for (Libros libro : libros) {
            if (libro.getNumeroPaginas() < min.getNumeroPaginas()) {
                min = libro;
            }
        }
        return min;
    }

    //calculo media de existencias
    public static double mediaExistencias(List<Libros> libros) {
        if (libros == null || libros.isEmpty()) {
            return 0;
        }

        int totalExistencias = 0;
        for (Libros libro : libros) {
            totalExistencias += libro.getExistencias();
        }

        return (double) totalExistencias / libros.size();
    }

    //calculo maximo de existencias
    public static Libros maxExistencias(List<Libros> libros) {
        if (libros == null || libros.isEmpty()) return null;

        Libros max = libros.get(0);
        for (Libros libro : libros) {
            if (libro.getExistencias() > max.getExistencias()) {
                max = libro;
            }
        }
        return max;
    }

    //calculo minimo de existencias
    public static Libros minExistencias(List<Libros> libros) {
        if (libros == null || libros.isEmpty()) return null;

        Libros min = libros.get(0);
        for (Libros libro : libros) {
            if (libro.getExistencias() < min.getExistencias()) {
                min = libro;
            }
        }
        return min;
    }

    //calculo de porcentaje de libros disponibles
    public static double porcentajeDisponibles(List<Libros> libros) {
        if (libros == null || libros.isEmpty()) return 0;

        int disponibles = 0;
        for (Libros libro : libros) {
            if (libro.isDisponibilidad()) {
                disponibles++;
            }
        }

        return (double) disponibles / libros.size() * 100; //sacar el porcentaje
    }

    //calculo de cantidad de libros por genero
    public static Map<String, Integer> librosPorGenero(List<Libros> libros) {
        Map<String, Integer> conteo = new HashMap<>();
        if (libros == null || libros.isEmpty()) return conteo;

        for (Libros libro : libros) {
            String tgenero = libro.getGenero();
            conteo.put(tgenero, conteo.getOrDefault(tgenero, 0) + 1);
        }

        return conteo;
    }

    //calculo de total de libros existentes
    public static int totalLibros(List<Libros> libros) {
        if (libros == null) return 0;
        return libros.size();
    }
}
