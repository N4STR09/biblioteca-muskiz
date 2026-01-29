package Classes;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class ServiceAutores {
    public static void añadirAutor(Scanner sc, List<Autores> autores, List<Libros> libros) {
        
        //solicitud de datos al usuario
        String nombre = InputUtils.leerString(sc, "Nombre del autor: ");

        String nacionalidad = InputUtils.leerString(sc, "Nacionalidad: ");

        LocalDate fechaNacimiento = InputUtils.leerFecha(sc, "Fecha de nacimiento: ");

        //vamos a crear un autor que este vivo
        boolean defuncion = false;
        String fechaFallecimiento = "";
        //omitimos esta informacion de momento
        String biografia = "";
        String foto = "";
        String generoLiterario = "";
        String premios = "";
        String obrasDestacadas = "";

        int id = autores.size() + 1; //asignacion de ID automatica

        // 2. CONVERSIÓN AQUÍ (este bloque)
        LocalDate fechaNacimientoLD = fechaNacimiento;

        LocalDate fechaFallecimientoLD = null;
        if (defuncion && !fechaFallecimiento.isBlank()) {
            fechaFallecimientoLD = LocalDate.parse(fechaFallecimiento);
        }

        //creamos un nuevo autor
        Autores nuevoAutor = new Autores(
            id,
            nombre,
            nacionalidad,
            fechaNacimientoLD,
            defuncion,
            fechaFallecimientoLD,
            biografia,
            foto,
            generoLiterario,
            premios,
            obrasDestacadas
        );

        autores.add(nuevoAutor); //lo añadimos a la lista
        System.out.println("Autor añadido correctamente.");
    }

    public static void eliminarAutor(Scanner sc, List<Autores> autores, List<Libros> libros) {
        if (autores.isEmpty()) {
            System.out.println("No hay autores para eliminar.");
        } else {
            System.out.println("---- AUTORES ----");
            for (Autores a : autores) {
                System.out.println(a.getIdAutor() + " - " + a.getNombre());
            }

            System.out.print("Introduce el ID del autor a eliminar: ");
            int id = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            boolean eliminado = false;

            for (int i = 0; i < autores.size(); i++) {
                if (autores.get(i).getIdAutor() == id) {
                    autores.remove(i);
                    eliminado = true;
                    System.out.println("Autor eliminado correctamente.");
                    break;
                }
            }

            if (!eliminado) {
                System.out.println("No se encontró ningún autor con ese ID.");
            }
        }
    }

    public static void visualizarAutores(Scanner sc, List<Autores> autores, List<Libros> libros) {
        System.out.println("---- AUTORES ----");

        for (Autores a : autores) {
            System.out.println(a.getIdAutor() + " - " + a.getNombre()); //printeamos lo que nos devuelva los getters
        }
    }

    public static void estadisticasAutores(Scanner sc, List<Autores> autores, List<Libros> libros) {
        System.out.println("---- ESTADÍSTICAS ----");
        System.out.println("1. Estadisticas libros por autor");
        System.out.println("2. Estadisticas páginas por libro de autor");
        System.out.println("3. Edades de autores");
        System.out.println("4. Total de autores");
        System.out.println("5. Salir");
        int tipo = sc.nextInt();
        int stat;

        switch (tipo) {
            case 1:
                System.out.println("1. Autor con más libros en la biblioteca");
                System.out.println("2. Autor con menos libros en la biblioteca");
                System.out.println("3. Salir");
                stat = sc.nextInt();

                switch (stat) {
                    case 1:
                        List<Autores> maxAutores = UtilidadesAutores.autoresConMasLibros(autores);

                        if (maxAutores.isEmpty()) {
                            System.out.println("No hay autores en la biblioteca.");
                        } else {
                            int maxLibros = maxAutores.get(0).getNumeroLibros();

                            System.out.println("Autor/es con más libros (" + maxLibros + " libros)");

                            for (Autores a : maxAutores) {
                                System.out.println("- " + a.getNombre());
                            }
                        }

                        break;
                    case 2:
                        List<Autores> minAutores = UtilidadesAutores.autoresConMenosLibros(autores);
                        
                        if (minAutores.isEmpty()) {
                            System.out.println("No hay autores en la biblioteca.");
                        } else {
                            int minLibros = minAutores.get(0).getNumeroLibros();

                            System.out.println("Autor/es con menos libros (" + minLibros + " libros)");

                            for (Autores a : minAutores) {
                                System.out.println("- " + a.getNombre());
                            }
                        }

                        break;
                    default:
                        System.out.println("Opción no valida.");
                        break;
                }
                break;
            case 2:
                System.out.println("1. Libro más largo");
                System.out.println("2. Libro más corto");
                System.out.println("3. Salir");
                stat = sc.nextInt();

                switch (stat) {
                    case 1:
                        List<Autores> autoresMaxLibro = UtilidadesAutores.autoresLibroMasLargo(autores, libros);

                        if (autoresMaxLibro == null || autoresMaxLibro.isEmpty() || libros == null || libros.isEmpty()) {
                            System.out.println("No hay autores o libros en la biblioteca.");
                        } else {

                            int maxPaginas = libros.stream()
                                    .mapToInt(Libros::getNumeroPaginas)
                                    .max()
                                    .orElse(0);

                            System.out.println("Autor/es con el libro más largo (" + maxPaginas + " páginas):");
                            for (Autores a : autoresMaxLibro) {
                                System.out.println("- " + a.getNombre());
                            }
                        }
                        break;
                    case 2:
                        List<Autores> autoresMinLibro = UtilidadesAutores.autoresLibroMasCorto(autores, libros);

                        if (autoresMinLibro == null || autoresMinLibro.isEmpty() || libros == null || libros.isEmpty()) {
                            System.out.println("No hay autores o libros en la biblioteca.");
                        } else {

                            int minPaginas = libros.stream()
                                    .mapToInt(Libros::getNumeroPaginas)
                                    .min()
                                    .orElse(0);

                            System.out.println("Autor/es con el libro más corto (" + minPaginas + " páginas):");
                            for (Autores a : autoresMinLibro) {
                                System.out.println("- " + a.getNombre());
                            }
                        }

                        break;
                    default:
                        System.out.println("Opción no valida.");
                        break;
                }
                break;
            case 3:
                System.out.println("1. Autor más viejo");
                System.out.println("2. Autor más joven");
                System.out.println("3. Edad media de los autores");
                System.out.println("4. Salir");
                stat = sc.nextInt();

                switch (stat) {
                    case 1:
                        List<Autores> viejos = UtilidadesAutores.autoresMasViejos(autores);

                        if (viejos.isEmpty()) {
                            System.out.println("No hay autores en la biblioteca.");
                        } else {
                            System.out.println("Autor/es más viejo/s (" + viejos.get(0).getEdad() + " años)");
                            for (Autores a : viejos) {
                                System.out.println("- " + a.getNombre());
                            }
                        }
                        break;
                    case 2:
                        List<Autores> jovenes = UtilidadesAutores.autoresMasJovenes(autores);

                        if (jovenes.isEmpty()) {
                            System.out.println("No hay autores en la biblioteca.");
                        } else {
                            System.out.println("Autor/es más joven/es (" + jovenes.get(0).getEdad() + " años)");
                            for (Autores a : jovenes) {
                                System.out.println("- " + a.getNombre());
                            }
                        }
                        break;
                    case 3:
                        double media = UtilidadesAutores.edadMediaAutores(autores);
                        System.out.println("La edad media de los autores es " + media);
                        break;
                    default:
                        System.out.println("Opción no valida.");
                        break;
                }
                break;
            case 4: 
                int total = UtilidadesAutores.totalAutores(autores);
                System.out.println("El total de autores en la biblioteca es " + total);
                break;
            default:
                break;
        }
    }
}