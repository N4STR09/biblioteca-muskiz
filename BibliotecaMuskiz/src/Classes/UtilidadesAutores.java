package Classes;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesAutores {

    //autor con más libros
    public static List<Autores> autoresConMasLibros(List<Autores> autores) {
        List<Autores> resultado = new ArrayList<>();
        if (autores == null || autores.isEmpty()) return resultado;

        int maxLibros = 0;

        //calcular maximo
        for (Autores a : autores) {
            int numLibros = a.getLibrosEscritos().size();
            if (numLibros > maxLibros) {
                maxLibros = numLibros;
            }
        }

        //obtener autores con maximo
        for (Autores a : autores) {
            if (a.getLibrosEscritos().size() == maxLibros) {
                resultado.add(a);
            }
        }

        return resultado;
    }

    //autor con menos libros
    public static List<Autores> autoresConMenosLibros(List<Autores> autores) {
        List<Autores> resultado = new ArrayList<>();
        if (autores == null || autores.isEmpty()) return resultado;

        int minLibros = 100000;

        for (Autores a : autores) {
            int numLibros = a.getLibrosEscritos().size();
            if (numLibros < minLibros) {
                minLibros = numLibros;
            }
        }

        for (Autores a : autores) {
            if (a.getLibrosEscritos().size() == minLibros) {
                resultado.add(a);
            }
        }

        return resultado;
    }

    //autor con el libros mas largo
    public static List<Autores> autoresLibroMasLargo(List<Autores> autores, List<Libros> libros) {
        List<Autores> resultado = new ArrayList<>();
        if (autores == null || autores.isEmpty() || libros == null || libros.isEmpty()) return resultado;

        int maxPaginas = -1;

        //numero maximo de paginas
        for (Autores a : autores) {
            for (int idLibro : a.getLibrosEscritos()) {
                Libros l = libros.stream()
                                .filter(lib -> lib.getIdLibro() == idLibro)
                                .findFirst()
                                .orElse(null);
                if (l != null && l.getNumeroPaginas() > maxPaginas) {
                    maxPaginas = l.getNumeroPaginas();
                }
            }
        }

        //autores con un libro con max
        for (Autores a : autores) {
            for (int idLibro : a.getLibrosEscritos()) {
                Libros l = libros.stream()
                                .filter(lib -> lib.getIdLibro() == idLibro)
                                .findFirst()
                                .orElse(null);
                if (l != null && l.getNumeroPaginas() == maxPaginas) {
                    resultado.add(a);
                    break;
                }
            }
        }

        return resultado;
    }


    //autor con el libros mas corto
    public static List<Autores> autoresLibroMasCorto(List<Autores> autores, List<Libros> libros) {
        List<Autores> resultado = new ArrayList<>();
        if (autores == null || autores.isEmpty() || libros == null || libros.isEmpty()) return resultado;

        int minPaginas = 1000000;

        for (Autores a : autores) {
            for (int idLibro : a.getLibrosEscritos()) {
                Libros l = libros.stream()
                                .filter(lib -> lib.getIdLibro() == idLibro)
                                .findFirst()
                                .orElse(null);
                if (l != null && l.getNumeroPaginas() < minPaginas) {
                    minPaginas = l.getNumeroPaginas();
                }
            }
        }

        for (Autores a : autores) {
            for (int idLibro : a.getLibrosEscritos()) {
                Libros l = libros.stream()
                                .filter(lib -> lib.getIdLibro() == idLibro)
                                .findFirst()
                                .orElse(null);
                if (l != null && l.getNumeroPaginas() == minPaginas) {
                    resultado.add(a);
                    break;
                }
            }
        }

        return resultado;
    }


    //autor mas viejo
    public static List<Autores> autoresMasViejos(List<Autores> autores) {
        List<Autores> resultado = new ArrayList<>();
        if (autores == null || autores.isEmpty()) return resultado;

        int maxEdad = -1;

        //edad maxima
        for (Autores a : autores) {
            int edad = a.getEdad();
            if (edad > maxEdad) {
                maxEdad = edad;
            }
        }

        //autores con edad maxima
        for (Autores a : autores) {
            if (a.getEdad() == maxEdad) {
                resultado.add(a);
            }
        }

        return resultado;
    }


    //autor más joven
    public static List<Autores> autoresMasJovenes(List<Autores> autores) {
        List<Autores> resultado = new ArrayList<>();
        if (autores == null || autores.isEmpty()) return resultado;

        int minEdad = 1000;

        for (Autores a : autores) {
            int edad = a.getEdad();
            if (edad < minEdad) {
                minEdad = edad;
            }
        }

        for (Autores a : autores) {
            if (a.getEdad() == minEdad) {
                resultado.add(a);
            }
        }

        return resultado;
    }

    //edad media autores
    public static double edadMediaAutores(List<Autores> autores) {
        if (autores == null || autores.isEmpty()) return 0;
        double total = 0;
        int yearActual = 2026;

        for (Autores a : autores) {
            int nacimiento = a.getFechaNacimiento().getYear();
            int fin = a.getDefuncion() 
                    ? a.getFechaFallecimiento().getYear() 
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