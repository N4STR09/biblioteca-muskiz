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
    public static List<Libros> librosMinimoPaginas(List<Libros> libros) {
        List<Libros> min = new ArrayList<>();
        if (libros == null || libros.isEmpty()) return min;

        int minPaginas = 0;

        for (Libros l : libros) {
            if (l.getNumeroPaginas() > minPaginas) {
                minPaginas = l.getNumeroPaginas();
            }
        }

        for (Libros l : libros) {
            if (l.getNumeroPaginas() == minPaginas) {
                min.add(l);
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
    public static List<Libros> librosMaxExistencias(List<Libros> libros) {
        List<Libros> max = new ArrayList<>();
        if (libros == null || libros.isEmpty()) return max;

        int maxExistencias = 0;

        for (Libros l : libros) {
            if (l.getExistencias() > maxExistencias) {
                maxExistencias = l.getExistencias();
            }
        }

        for (Libros l : libros) {
            if (l.getExistencias() == maxExistencias) {
                max.add(l);
            }
        }

        return max;
    }


    //calculo minimo de existencias
    public static List<Libros> librosMinExistencias(List<Libros> libros) {
        List<Libros> min = new ArrayList<>();
        if (libros == null || libros.isEmpty()) return min;

        int minExistencias = 0;

        for (Libros l : libros) {
            if (l.getExistencias() > minExistencias) {
                minExistencias = l.getExistencias();
            }
        }

        for (Libros l : libros) {
            if (l.getExistencias() == minExistencias) {
                min.add(l);
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
