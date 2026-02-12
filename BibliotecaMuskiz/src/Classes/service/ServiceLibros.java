package Classes.service;

import java.util.Scanner;

import Classes.model.*;
import Classes.utils.ColoresUtils;
import Classes.utils.InputUtils;
import Classes.utils.UtilidadesLibros;

import java.util.List;

public class ServiceLibros {
    public static void añadirLibro(Scanner sc, List<Autor> autores, List<Libro> libros) {
        //solicitud de datos al usuario
        String titulo = InputUtils.leerString(sc, "Título del libro: ");

        System.out.println("Elige el autor del libro por ID:");
        for (Autor a : autores) {
            System.out.println(a.getIdAutor() + " - " + a.getNombre());
        }

        int idAutor = InputUtils.leerInt(sc, "ID del autor: ");

        Autor autorElegido = null;
        for (Autor a : autores) {
            if (a.getIdAutor() == idAutor) {
                autorElegido = a;
                break;
            }
        }
        
        if (autorElegido == null) {
            System.out.println(ColoresUtils.ROJO + "Autor " + ColoresUtils.NEGRITA + "no" + ColoresUtils.RESET + ColoresUtils.ROJO + " encontrado. Libro " + ColoresUtils.NEGRITA + "no" + ColoresUtils.RESET + ColoresUtils.ROJO + " creado.");
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
            Libro nuevoLibro = new Libro(
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

            System.out.println(ColoresUtils.VERDE + "Libro añadido " + ColoresUtils.NEGRITA + "correctamente." + ColoresUtils.RESET);
        }
    }

    public static void eliminarLibro(Scanner sc, List<Autor> autores, List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No " + ColoresUtils.RESET + ColoresUtils.ROJO + "hay libros para eliminar." + ColoresUtils.RESET);
        } else {
            System.out.println(ColoresUtils.NEGRITA + "---- LIBROS ----" + ColoresUtils.RESET);
            for (Libro a : libros) {
                System.out.println(a.getIdLibro() + " - " + a.getTitulo());
            }

            System.out.print("Introduce el " + ColoresUtils.NEGRITA + ColoresUtils.ROJO + "ID del libro a eliminar: " + ColoresUtils.RESET);
            int idLibroEliminar = sc.nextInt();

            boolean eliminado = false;

            for (int i = 0; i < libros.size(); i++) {
                if (libros.get(i).getIdLibro() == idLibroEliminar) {
                    libros.remove(i);
                    eliminado = true;
                    System.out.println(ColoresUtils.VERDE + ColoresUtils.NEGRITA + "Libro eliminado correctamente." + ColoresUtils.RESET);
                    break;
                }
            }

            if (!eliminado) {
                System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No se encontró ningún libro con ese ID." + ColoresUtils.RESET);
            }
        }
    }

    public static void mostrarLibros(Scanner sc, List<Autor> autores, List<Libro> libros) {
        System.out.println(ColoresUtils.NEGRITA + "---- LIBROS ----" + ColoresUtils.RESET);
        for (Libro a : libros) {
            System.out.println(a.getIdLibro() + " - "+a.getTitulo() + " - " + a.getAutor()); //printeamos lo que nos devuelva los getters
        }

        int id = InputUtils.leerInt(sc, "Introduce el " + ColoresUtils.SUBRAYADO + "ID del libro" + ColoresUtils.RESET + " para ver más detalles " + ColoresUtils.NEGRITA + "(0 para salir): " + ColoresUtils.RESET);

        if (id != 0) {
            Libro libroSeleccionado = null;
            for (Libro a : libros) {
                if (a.getIdLibro() == id) {
                    libroSeleccionado = a;
                    break;
                }
            }

            if (libroSeleccionado != null) {
                System.out.println(ColoresUtils.NEGRITA + "---- DETALLES DEL LIBRO ----" + ColoresUtils.RESET);
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
                System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No se encontró ningún libro con ese ID." + ColoresUtils.RESET);
            }
        }
    }

    public static void estadisticasLibros(Scanner sc, List<Autor> autores, List<Libro> libros) {
        System.out.println(ColoresUtils.NEGRITA + "---- ESTADÍSTICAS ----" + ColoresUtils.RESET);
        System.out.println("1. Estadísticas " + ColoresUtils.AZUL_OSCURO + "páginas" + ColoresUtils.RESET);
        System.out.println("2. Estadísticas " + ColoresUtils.MORADO_OSCURO + "existencias" + ColoresUtils.RESET);
        System.out.println("3. " + ColoresUtils.NEGRITA + "Otras " + ColoresUtils.RESET + "Estadísticas");
        System.out.println("4. "  + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
        int tipo = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 4);
        int stat;

        switch (tipo) {
            case 1:
                System.out.println("1. " + ColoresUtils.MORADO + "Media" + ColoresUtils.RESET + " de Páginas");
                System.out.println("2. " + ColoresUtils.CYAN + "Máximo" + ColoresUtils.RESET + " de Páginas");
                System.out.println("3. " + ColoresUtils.NARANJA + "Mínimo" + ColoresUtils.RESET + " de Páginas");
                System.out.println("4. "  + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
                stat = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 4);

                switch (stat) {
                    case 1:
                        double media = UtilidadesLibros.mediaPaginas(libros);
                        System.out.println(ColoresUtils.MORADO + "Media" + ColoresUtils.RESET + " de páginas: " + media);
                        break;
                    case 2:
                        List<Libro> librosMax = UtilidadesLibros.librosMaxPaginas(libros);

                        if (librosMax.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No hay libros en la biblioteca." + ColoresUtils.RESET);
                        } else {
                            int paginas = librosMax.get(0).getNumeroPaginas();
                            System.out.println("Libro/s con " + ColoresUtils.CYAN + "más páginas" + ColoresUtils.RESET + " (" + paginas + " páginas):");

                            for (Libro l : librosMax) {
                                System.out.println("- " + l.getTitulo() + " (" + l.getAutorObj().getNombre() + ")");
                            }
                        }
                        break;
                    case 3:
                        List<Libro> librosMin = UtilidadesLibros.librosMinimoPaginas(libros);

                        if (librosMin.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No hay libros en la biblioteca." + ColoresUtils.RESET);
                        } else {
                            int paginas = librosMin.get(0).getNumeroPaginas();
                            System.out.println("Libro/s con " + ColoresUtils.NARANJA + "menos páginas" + ColoresUtils.RESET + " (" + paginas + " páginas):");

                            for (Libro l : librosMin) {
                                System.out.println("- " + l.getTitulo() + " (" + l.getAutorObj().getNombre() + ")");
                            }
                        }
                        break;
                    default:
                        System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "Opción no valida." + ColoresUtils.RESET);
                        break;
                }
                break;
            case 2:
                System.out.println("1. " + ColoresUtils.MORADO + "Media" + ColoresUtils.RESET + " de Existencias");
                System.out.println("2. " + ColoresUtils.CYAN + "Máximo" + ColoresUtils.RESET + " de Existencias");
                System.out.println("3. " + ColoresUtils.NARANJA + "Mínimo" + ColoresUtils.RESET + " de Existencias");
                System.out.println("4. "  + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
                stat = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 4);

                switch (stat) {
                    case 1:
                        double media = UtilidadesLibros.mediaExistencias(libros);
                        System.out.println(ColoresUtils.MORADO + "Media" + ColoresUtils.RESET + " de existencias: " + ColoresUtils.NEGRITA + media + ColoresUtils.RESET);
                        break;
                    case 2:
                        List<Libro> librosMax = UtilidadesLibros.librosMaxExistencias(libros);

                        if (librosMax.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No hay libros en la biblioteca." + ColoresUtils.RESET);
                        } else {
                            int existencias = librosMax.get(0).getExistencias();
                            System.out.println("Libro/s con " + ColoresUtils.CYAN + "más existencias" + ColoresUtils.RESET + ColoresUtils.NEGRITA + " (" + existencias + " unidades):" + ColoresUtils.RESET);

                            for (Libro l : librosMax) {
                                System.out.println("- " + l.getTitulo());
                            }
                        }
                        break;
                    case 3:
                        List<Libro> librosMin = UtilidadesLibros.librosMinExistencias(libros);

                        if (librosMin.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No hay libros en la biblioteca." + ColoresUtils.RESET);
                        } else {
                            int existencias = librosMin.get(0).getExistencias();
                            System.out.println("Libro/s con menos existencias (" + existencias + " unidades):");

                            for (Libro l : librosMin) {
                                System.out.println("- " + l.getTitulo());
                            }
                        }
                        break;
                    default:
                        System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "Opción no valida." + ColoresUtils.RESET);
                        break;
                }
                break;
            case 3:
                System.out.println("1. Porcentaje de " + ColoresUtils.AMARILLO + "libros disponibles" + ColoresUtils.RESET);
                System.out.println("2. Cantidad de " + ColoresUtils.AZUL + "libros por género" + ColoresUtils.RESET);
                System.out.println("3. Número " + ColoresUtils.ROSA + "total de libros" + ColoresUtils.RESET);
                System.out.println("4. "  + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
                stat = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 4);
                
                switch (stat) {
                    case 1:
                        double porcentaje = UtilidadesLibros.porcentajeDisponibles(libros);
                        System.out.println("Porcentaje de " + ColoresUtils.AMARILLO + "libros disponibles: " + ColoresUtils.RESET + ColoresUtils.NEGRITA + porcentaje + "%" + ColoresUtils.RESET);
                        break;
                    case 2:
                        System.out.println("Cantidad de " + ColoresUtils.AZUL + "libros por género:" + ColoresUtils.RESET);
                        var porGenero = UtilidadesLibros.librosPorGenero(libros);
                        for (String tgenero : porGenero.keySet()) {
                            System.out.println(tgenero + ": " + porGenero.get(tgenero));
                        }
                        break;
                    case 3:
                        int total = UtilidadesLibros.totalLibros(libros);
                        System.out.println("Número " + ColoresUtils.ROSA + "total de libros: " + ColoresUtils.RESET + ColoresUtils.NEGRITA + total + ColoresUtils.RESET);
                        break;
                    default:
                        System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "Opción no valida." + ColoresUtils.RESET);
                        break;
                    }
                break;
            default:
                break;
        }
    }
}