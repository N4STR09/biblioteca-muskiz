package Classes.service;

import java.util.Scanner;

import Classes.model.Autores;
import Classes.model.Libros;
import Classes.utils.InputUtils;
import Classes.utils.UtilidadesLibros;

import java.util.List;

public class ServiceLibros {
    public static void añadirLibro(Scanner sc, List<Autores> autores, List<Libros> libros) {
        //solicitud de datos al usuario
        String titulo = InputUtils.leerString(sc, "Título del libro: ");

        System.out.println("Elige el autor del libro por ID:");
        for (Autores a : autores) {
            System.out.println(a.getIdAutor() + " - " + a.getNombre());
        }

        int idAutor = InputUtils.leerInt(sc, "ID del autor: ");

        Autores autorElegido = null;
        for (Autores a : autores) {
            if (a.getIdAutor() == idAutor) {
                autorElegido = a;
                break;
            }
        }
        
        if (autorElegido == null) {
            System.out.println("Autor no encontrado. Libro no creado.");
        } else {

            String genero = InputUtils.leerString(sc, "Género del libro: ");
            int existencias = InputUtils.leerInt(sc, "Número de existencias: ");
            int numeroPaginas = InputUtils.leerInt(sc, "Número de páginas: ");
            int anioPublicacion = InputUtils.leerInt(sc, "Año de publicación: ");
            String editorial = InputUtils.leerString(sc, "Editorial: ");
            String isbn = InputUtils.leerString(sc, "ISBN: ");
            String idioma = InputUtils.leerString(sc, "Idioma: ");
            String formato = InputUtils.leerString(sc, "Formato: ");
            String portada = InputUtils.leerString(sc, "Portada del libro: ");
            String descripcion = InputUtils.leerString(sc, "Descripción del libro: ");
            String categoria = InputUtils.leerString(sc, "Categoría del libro: ");
            boolean disponibilidad = InputUtils.leerBoolean(sc, "¿Está disponible?");

            int id = libros.size() + 1; 
            
            //creamos un nuevo libro
            Libros nuevoLibro = new Libros(
                id,
                existencias,
                numeroPaginas,
                titulo,
                autorElegido,
                genero,
                anioPublicacion,
                editorial,
                isbn,
                idioma,
                formato,
                portada,
                descripcion,
                categoria,
                disponibilidad
            );

            libros.add(nuevoLibro);

            autorElegido.addLibro(nuevoLibro.getIdLibro());

            System.out.println("Libro añadido correctamente.");
        }
    }

    public static void eliminarLibro(Scanner sc, List<Autores> autores, List<Libros> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros para eliminar.");
        } else {
            System.out.println("---- LIBROS ----");
            for (Libros a : libros) {
                System.out.println(a.getIdLibro() + " - " + a.getTitulo());
            }

            System.out.print("Introduce el ID del libro a eliminar: ");
            int idLibroEliminar = sc.nextInt();

            boolean eliminado = false;

            for (int i = 0; i < libros.size(); i++) {
                if (libros.get(i).getIdLibro() == idLibroEliminar) {
                    libros.remove(i);
                    eliminado = true;
                    System.out.println("Libro eliminado correctamente.");
                    break;
                }
            }

            if (!eliminado) {
                System.out.println("No se encontró ningún libro con ese ID.");
            }
        }
    }

    public static void mostrarLibros(Scanner sc, List<Autores> autores, List<Libros> libros) {
        System.out.println("---- LIBROS ----");
        for (Libros a : libros) {
            System.out.println(a.getIdLibro() + " - "+a.getTitulo() + " - " + a.getAutor()); //printeamos lo que nos devuelva los getters
        }

        int id = InputUtils.leerInt(sc, "Introduce el ID del libro para ver más detalles (0 para salir): ");

        if (id != 0) {
            Libros libroSeleccionado = null;
            for (Libros a : libros) {
                if (a.getIdLibro() == id) {
                    libroSeleccionado = a;
                    break;
                }
            }

            if (libroSeleccionado != null) {
                System.out.println("---- DETALLES DEL LIBRO ----");
                System.out.println("Título: " + libroSeleccionado.getTitulo());
                System.out.println("Autor: " + libroSeleccionado.getNombreAutor());
                System.out.println("Género: " + libroSeleccionado.getGenero());
                System.out.println("Número de páginas: " + libroSeleccionado.getNumeroPaginas());
                System.out.println("Año de publicación: " + libroSeleccionado.getAnioPublicacion());
                System.out.println("Editorial: " + libroSeleccionado.getEditorial());
                System.out.println("ISBN: " + libroSeleccionado.getIsbn());
                System.out.println("Idioma: " + libroSeleccionado.getIdioma());
                System.out.println("Formato: " + libroSeleccionado.getFormato());
                System.out.println("Existencias: " + libroSeleccionado.getExistencias());
                System.out.println("Disponibilidad: " + (libroSeleccionado.isDisponibilidad() ? "Disponible" : "No disponible"));
                System.out.println("Descripción: " + libroSeleccionado.getDescripcion());
                System.out.println("Categoría: " + libroSeleccionado.getCategoria());
            } else {
                System.out.println("No se encontró ningún libro con ese ID.");
            }
        }
    }

    public static void estadisticasLibros(Scanner sc, List<Autores> autores, List<Libros> libros) {
        System.out.println("---- ESTADISTICAS ----");
        System.out.println("1. Estadisticas páginas");
        System.out.println("2. Estadisticas existencias");
        System.out.println("3. Otras Estadisticas");
        System.out.println("4. Salir");
        int tipo = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 4);
        int stat;

        switch (tipo) {
            case 1:
                System.out.println("1. Media de Paginas");
                System.out.println("2. Maximo de Paginas");
                System.out.println("3. Minimo de Paginas");
                System.out.println("4. Salir");
                stat = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 4);

                switch (stat) {
                    case 1:
                        double media = UtilidadesLibros.mediaPaginas(libros);
                        System.out.println("Media de páginas: " + media);
                        break;
                    case 2:
                        List<Libros> librosMax = UtilidadesLibros.librosMaxPaginas(libros);

                        if (librosMax.isEmpty()) {
                            System.out.println("No hay libros en la biblioteca.");
                        } else {
                            int paginas = librosMax.get(0).getNumeroPaginas();
                            System.out.println("Libro/s con más páginas (" + paginas + " páginas):");

                            for (Libros l : librosMax) {
                                System.out.println("- " + l.getTitulo() + " (" + l.getAutorObj().getNombre() + ")");
                            }
                        }
                        break;
                    case 3:
                        List<Libros> librosMin = UtilidadesLibros.librosMinimoPaginas(libros);

                        if (librosMin.isEmpty()) {
                            System.out.println("No hay libros en la biblioteca.");
                        } else {
                            int paginas = librosMin.get(0).getNumeroPaginas();
                            System.out.println("Libro/s con más páginas (" + paginas + " páginas):");

                            for (Libros l : librosMin) {
                                System.out.println("- " + l.getTitulo() + " (" + l.getAutorObj().getNombre() + ")");
                            }
                        }
                        break;
                    default:
                        System.out.println("Opción no valida.");
                        break;
                }
                break;
            case 2:
                System.out.println("1. Media de Existencias");
                System.out.println("2. Maximo de Existencias");
                System.out.println("3. Minimo de Existencias");
                System.out.println("4. Salir");
                stat = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 4);

                switch (stat) {
                    case 1:
                        double media = UtilidadesLibros.mediaExistencias(libros);
                        System.out.println("Media de existencias: " + media);
                        break;
                    case 2:
                        List<Libros> librosMax = UtilidadesLibros.librosMaxExistencias(libros);

                        if (librosMax.isEmpty()) {
                            System.out.println("No hay libros en la biblioteca.");
                        } else {
                            int existencias = librosMax.get(0).getExistencias();
                            System.out.println("Libro/s con más existencias (" + existencias + " unidades):");

                            for (Libros l : librosMax) {
                                System.out.println("- " + l.getTitulo());
                            }
                        }
                        break;
                    case 3:
                        List<Libros> librosMin = UtilidadesLibros.librosMinExistencias(libros);

                        if (librosMin.isEmpty()) {
                            System.out.println("No hay libros en la biblioteca.");
                        } else {
                            int existencias = librosMin.get(0).getExistencias();
                            System.out.println("Libro/s con más existencias (" + existencias + " unidades):");

                            for (Libros l : librosMin) {
                                System.out.println("- " + l.getTitulo());
                            }
                        }
                        break;
                    default:
                        System.out.println("Opción no valida.");
                        break;
                }
                break;
            case 3:
                System.out.println("1. Porcentaje de libros disponibles");
                System.out.println("2. Cantidad de libros por género");
                System.out.println("3. Numero total de libros");
                System.out.println("4. Salir");
                stat = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 4);
                
                switch (stat) {
                    case 1:
                        double porcentaje = UtilidadesLibros.porcentajeDisponibles(libros);
                        System.out.println("Porcentaje de libros disponibles: " + porcentaje + "%");
                        break;
                    case 2:
                        System.out.println("Cantidad de libros por género:");
                        var porGenero = UtilidadesLibros.librosPorGenero(libros);
                        for (String tgenero : porGenero.keySet()) {
                            System.out.println(tgenero + ": " + porGenero.get(tgenero));
                        }
                        break;
                    case 3:
                        int total = UtilidadesLibros.totalLibros(libros);
                        System.out.println("Número total de libros: " + total);
                        break;
                    default:
                        System.out.println("Opción no valida.");
                        break;
                    }
                break;
            default:
                break;
        }
    }
}