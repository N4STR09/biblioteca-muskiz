package Classes.service;

import java.util.List;
import java.util.Scanner;

<<<<<<< HEAD
import Classes.model.Autores;
import Classes.model.Libros;
import Classes.utils.ColoresUtils;
||||||| 41b469b
import Classes.model.Autores;
import Classes.model.Libros;
=======
import Classes.model.*;
import Classes.utils.ColoresUtils;
>>>>>>> reestructuracion-menu
import Classes.utils.InputUtils;
import Classes.utils.UtilidadesAutores;

import java.time.LocalDate;

public class ServiceAutores {
    
    public static void añadirAutor(Scanner sc, List<Autor> autores, List<Libro> libros) {
        
        //solicitud de datos al usuario
        String nombre = InputUtils.leerString(sc, "Nombre del autor: ");

        String nacionalidad = InputUtils.leerString(sc, "Nacionalidad: ");

        LocalDate fechaNacimiento = InputUtils.leerFecha(sc, "Fecha de nacimiento: ");

        //vamos a crear un autor que este vivo
        boolean defuncion = InputUtils.leerBoolean(sc, "¿El autor ha " + ColoresUtils.NEGRITA + "fallecido" + ColoresUtils.RESET + "?: ");
        
        LocalDate fechaFallecimiento = null;
        if (defuncion) {
            do {
                fechaFallecimiento = InputUtils.leerFecha(sc, "Fecha de fallecimiento: ");
                if (fechaFallecimiento.isBefore(fechaNacimiento)) {
                    System.out.println("La fecha de fallecimiento " + ColoresUtils.ROJO + "no puede ser anterior" + ColoresUtils.RESET + " a la fecha de nacimiento.");
                }
            } while (fechaFallecimiento.isBefore(fechaNacimiento));
        }
        
        String biografia = InputUtils.leerString(sc, "Biografía: ");
        String foto = InputUtils.leerString(sc, "Foto del autor: ");
        String generoLiterario = InputUtils.leerString(sc, "Género literario: ");
        String premios = InputUtils.leerString(sc, "Premios obtenidos: ");
        String obrasDestacadas = InputUtils.leerString(sc, "Obras destacadas: ");

        int id = autores.size() + 1; //asignacion de ID automatica

        //creamos un nuevo autor
        Autor nuevoAutor = new Autor(
            id,
            nombre,
            nacionalidad,
            fechaNacimiento,
            defuncion,
            fechaFallecimiento,
            biografia,
            foto,
            generoLiterario,
            premios,
            obrasDestacadas
        );

        autores.add(nuevoAutor); //lo añadimos a la lista
        System.out.println(ColoresUtils.VERDE + ColoresUtils.NEGRITA + "Autor añadido correctamente." + ColoresUtils.RESET);
    }

    public static void eliminarAutor(Scanner sc, List<Autor> autores, List<Libro> libros) {
        if (autores.isEmpty()) {
            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No hay autores para eliminar." + ColoresUtils.RESET);
        } else {
<<<<<<< HEAD
            System.out.println(ColoresUtils.NEGRITA + "---- AUTORES ----" + ColoresUtils.RESET);
            for (Autores a : autores) {
||||||| 41b469b
            System.out.println("---- AUTORES ----");
            for (Autores a : autores) {
=======
            System.out.println(ColoresUtils.NEGRITA + "---- AUTORES ----" + ColoresUtils.RESET);
            for (Autor a : autores) {
>>>>>>> reestructuracion-menu
                System.out.println(a.getIdAutor() + " - " + a.getNombre());
            }

            System.out.print("Introduce el" + ColoresUtils.NEGRITA + ColoresUtils.ROJO + " ID " + ColoresUtils.RESET + ColoresUtils.ROJO + "del autor a eliminar: " + ColoresUtils.RESET);
            int id = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            boolean eliminado = false;

            for (int i = 0; i < autores.size(); i++) {
                if (autores.get(i).getIdAutor() == id) {
                    autores.remove(i);
                    eliminado = true;
                    System.out.println(ColoresUtils.VERDE + ColoresUtils.NEGRITA + "Autor eliminado correctamente." + ColoresUtils.RESET);
                    break;
                }
            }

            if (!eliminado) {
                System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No se encontró ningún autor con ese ID." + ColoresUtils.RESET);
            }
        }
    }

<<<<<<< HEAD
    public static void visualizarAutores(Scanner sc, List<Autores> autores, List<Libros> libros) {
        System.out.println(ColoresUtils.NEGRITA + "---- AUTORES ----" + ColoresUtils.RESET);
||||||| 41b469b
    public static void visualizarAutores(Scanner sc, List<Autores> autores, List<Libros> libros) {
        System.out.println("---- AUTORES ----");
=======
    public static void visualizarAutores(Scanner sc, List<Autor> autores, List<Libro> libros) {
        System.out.println(ColoresUtils.NEGRITA + "---- AUTORES ----" + ColoresUtils.RESET);
>>>>>>> reestructuracion-menu

        for (Autor a : autores) {
            System.out.println(a.getIdAutor() + " - " + a.getNombre()); //printeamos lo que nos devuelva los getters
        }
        int id = InputUtils.leerInt(sc, "Introduce el ID del autor para ver detalles " + ColoresUtils.NEGRITA + "(0 para salir): " + ColoresUtils.RESET);

        if (id != 0) {
            boolean encontrado = false;

            for (Autor a : autores) {
                if (a.getIdAutor() == id) {
                    System.out.println(ColoresUtils.NEGRITA + "---- DETALLES DEL AUTOR ----" + ColoresUtils.RESET);
                    System.out.println("ID: " + a.getIdAutor());
                    System.out.println("Nombre: " + a.getNombre());
                    System.out.println("Nacionalidad: " + a.getNacionalidad());
                    System.out.println("Fecha de Nacimiento: " + a.getFechaNacimiento());
                    System.out.println("Defunción: " + (a.isDefuncion() ? ColoresUtils.VERDE + "Sí" + ColoresUtils.RESET : ColoresUtils.ROJO + "No" + ColoresUtils.RESET));
                    if (a.isDefuncion()) {
                        System.out.println("Fecha de Fallecimiento: " + a.getFechaFallecimiento());
                    }
                    System.out.println("Biografía: " + a.getBiografia());
                    System.out.println("Foto: " + a.getFoto());
                    System.out.println("Género Literario: " + a.getGeneroLiterario());
                    System.out.println("Premios: " + a.getPremios());
                    System.out.println("Obras Destacadas: " + a.getObrasDestacadas());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No se encontró ningún autor con ese ID." + ColoresUtils.RESET);
            }
        }
    }

<<<<<<< HEAD
    public static void estadisticasAutores(Scanner sc, List<Autores> autores, List<Libros> libros) {
        System.out.println(ColoresUtils.NEGRITA + "---- ESTADÍSTICAS ----" + ColoresUtils.RESET);
        System.out.println("1. Estadísticas " + ColoresUtils.AZUL + "libros por autor" + ColoresUtils.RESET);
        System.out.println("2. Estadísticas " + ColoresUtils.MORADO + "páginas por libro " + ColoresUtils.RESET + "de autor");
        System.out.println("3. " + ColoresUtils.NARANJA + "Edades " + ColoresUtils.RESET + "de autores");
        System.out.println("4. " + ColoresUtils.VERDE + "Total " + ColoresUtils.RESET + "de autores");
        System.out.println("5. " + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
||||||| 41b469b
    public static void estadisticasAutores(Scanner sc, List<Autores> autores, List<Libros> libros) {
        System.out.println("---- ESTADÍSTICAS ----");
        System.out.println("1. Estadisticas libros por autor");
        System.out.println("2. Estadisticas páginas por libro de autor");
        System.out.println("3. Edades de autores");
        System.out.println("4. Total de autores");
        System.out.println("5. Salir");
=======
    public static void estadisticasAutores(Scanner sc, List<Autor> autores, List<Libro> libros) {
        System.out.println(ColoresUtils.NEGRITA + "---- ESTADÍSTICAS ----" + ColoresUtils.RESET);
        System.out.println("1. Estadísticas " + ColoresUtils.AZUL + "libros por autor" + ColoresUtils.RESET);
        System.out.println("2. Estadísticas " + ColoresUtils.MORADO + "páginas por libro " + ColoresUtils.RESET + "de autor");
        System.out.println("3. " + ColoresUtils.NARANJA + "Edades " + ColoresUtils.RESET + "de autores");
        System.out.println("4. " + ColoresUtils.VERDE + "Total " + ColoresUtils.RESET + "de autores");
        System.out.println("5. " + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
>>>>>>> reestructuracion-menu
        int tipo = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 5);
        int stat;

        switch (tipo) {
            case 1:
                System.out.println("1. Autor con " + ColoresUtils.CYAN + "más libros" + ColoresUtils.RESET + " en la biblioteca");
                System.out.println("2. Autor con " + ColoresUtils.NARANJA + "menos libros" + ColoresUtils.RESET + " en la biblioteca");
                System.out.println("3. " + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
                stat = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 3);

                switch (stat) {
                    case 1:
                        List<Autor> maxAutores = UtilidadesAutores.autoresConMasLibros(autores);

                        if (maxAutores.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + "No hay autores en la biblioteca." + ColoresUtils.RESET);
                        } else {
                            int maxLibros = maxAutores.get(0).getNumeroLibros();

                            System.out.println("Autor/es con " + ColoresUtils.CYAN + "más libros " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + maxLibros + " libros)" + ColoresUtils.RESET);

                            for (Autor a : maxAutores) {
                                System.out.println("- " + a.getNombre());
                            }
                        }

                        break;
                    case 2:
                        List<Autor> minAutores = UtilidadesAutores.autoresConMenosLibros(autores);
                        
                        if (minAutores.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No hay autores en la biblioteca." + ColoresUtils.RESET);
                        } else {
                            int minLibros = minAutores.get(0).getNumeroLibros();

                            System.out.println("Autor/es con " + ColoresUtils.NARANJA + "menos libros " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + minLibros + " libros)" + ColoresUtils.RESET);

                            for (Autor a : minAutores) {
                                System.out.println("- " + a.getNombre());
                            }
                        }

                        break;
                    default:
                        System.out.println(ColoresUtils.NEGRITA + ColoresUtils.ROJO + "Opción no valida." + ColoresUtils.RESET);
                        break;
                }
                break;
            case 2:
                System.out.println("1. Libro " + ColoresUtils.CYAN + "más largo" + ColoresUtils.RESET);
                System.out.println("2. Libro " + ColoresUtils.NARANJA + "más corto" + ColoresUtils.RESET);
                System.out.println("3. "  + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
                stat = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 3);

                switch (stat) {
                    case 1:
                        List<Autor> autoresMaxLibro = UtilidadesAutores.autoresLibroMasLargo(autores, libros);

                        if (autoresMaxLibro == null || autoresMaxLibro.isEmpty() || libros == null || libros.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No hay autores o libros en la biblioteca." + ColoresUtils.RESET);
                        } else {

                            int maxPaginas = libros.stream()
                                    .mapToInt(Libro::getNumeroPaginas)
                                    .max()
                                    .orElse(0);

<<<<<<< HEAD
                            System.out.println("Autor/es con el libro " + ColoresUtils.CYAN + "más largo " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + maxPaginas + " páginas):" + ColoresUtils.RESET);
                            for (Autores a : autoresMaxLibro) {
||||||| 41b469b
                            System.out.println("Autor/es con el libro más largo (" + maxPaginas + " páginas):");
                            for (Autores a : autoresMaxLibro) {
=======
                            System.out.println("Autor/es con el libro " + ColoresUtils.CYAN + "más largo " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + maxPaginas + " páginas):" + ColoresUtils.RESET);
                            for (Autor a : autoresMaxLibro) {
>>>>>>> reestructuracion-menu
                                System.out.println("- " + a.getNombre());
                            }
                        }
                        break;
                    case 2:
                        List<Autor> autoresMinLibro = UtilidadesAutores.autoresLibroMasCorto(autores, libros);

                        if (autoresMinLibro == null || autoresMinLibro.isEmpty() || libros == null || libros.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No hay autores o libros en la biblioteca." + ColoresUtils.RESET);
                        } else {

                            int minPaginas = libros.stream()
                                    .mapToInt(Libro::getNumeroPaginas)
                                    .min()
                                    .orElse(0);

<<<<<<< HEAD
                            System.out.println("Autor/es con el libro " + ColoresUtils.NARANJA + "más corto " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + minPaginas + " páginas):" + ColoresUtils.RESET);
                            for (Autores a : autoresMinLibro) {
||||||| 41b469b
                            System.out.println("Autor/es con el libro más corto (" + minPaginas + " páginas):");
                            for (Autores a : autoresMinLibro) {
=======
                            System.out.println("Autor/es con el libro " + ColoresUtils.NARANJA + "más corto " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + minPaginas + " páginas):" + ColoresUtils.RESET);
                            for (Autor a : autoresMinLibro) {
>>>>>>> reestructuracion-menu
                                System.out.println("- " + a.getNombre());
                            }
                        }

                        break;
                    default:
                        System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "Opción no valida." + ColoresUtils.RESET);
                        break;
                }
                break;
            case 3:
                System.out.println("1. Autor " + ColoresUtils.CYAN + "más viejo" + ColoresUtils.RESET);
                System.out.println("2. Autor " + ColoresUtils.NARANJA + "más joven" + ColoresUtils.RESET);
                System.out.println("3. " + ColoresUtils.MORADO + "Edad media" + ColoresUtils.RESET + " de los autores");
                System.out.println("4. "  + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
                stat = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 4);

                switch (stat) {
                    case 1:
                        List<Autor> viejos = UtilidadesAutores.autoresMasViejos(autores);

                        if (viejos.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + "No hay autores en la biblioteca." + ColoresUtils.RESET);
                        } else {
<<<<<<< HEAD
                            System.out.println(ColoresUtils.CYAN + "Autor/es más viejo/s " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + viejos.get(0).getEdad() + " años)" + ColoresUtils.RESET);
                            for (Autores a : viejos) {
||||||| 41b469b
                            System.out.println("Autor/es más viejo/s (" + viejos.get(0).getEdad() + " años)");
                            for (Autores a : viejos) {
=======
                            System.out.println(ColoresUtils.CYAN + "Autor/es más viejo/s " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + viejos.get(0).getEdad() + " años)" + ColoresUtils.RESET);
                            for (Autor a : viejos) {
>>>>>>> reestructuracion-menu
                                System.out.println("- " + a.getNombre());
                            }
                        }
                        break;
                    case 2:
                        List<Autor> jovenes = UtilidadesAutores.autoresMasJovenes(autores);

                        if (jovenes.isEmpty()) {
                            System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "No hay autores en la biblioteca." + ColoresUtils.RESET);
                        } else {
<<<<<<< HEAD
                            System.out.println(ColoresUtils.NARANJA + "Autor/es más joven/es " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + jovenes.get(0).getEdad() + " años)" + ColoresUtils.RESET);
                            for (Autores a : jovenes) {
||||||| 41b469b
                            System.out.println("Autor/es más joven/es (" + jovenes.get(0).getEdad() + " años)");
                            for (Autores a : jovenes) {
=======
                            System.out.println(ColoresUtils.NARANJA + "Autor/es más joven/es " + ColoresUtils.RESET + ColoresUtils.NEGRITA + "(" + jovenes.get(0).getEdad() + " años)" + ColoresUtils.RESET);
                            for (Autor a : jovenes) {
>>>>>>> reestructuracion-menu
                                System.out.println("- " + a.getNombre());
                            }
                        }
                        break;
                    case 3:
                        double media = UtilidadesAutores.edadMediaAutores(autores);
                        System.out.println("La " + ColoresUtils.MORADO + "edad media" + ColoresUtils.RESET + " de los autores es " + ColoresUtils.NEGRITA + media + ColoresUtils.RESET);
                        break;
                    default:
                        System.out.println(ColoresUtils.ROJO + ColoresUtils.NEGRITA + "Opción no valida." + ColoresUtils.RESET);
                        break;
                }
                break;
            case 4: 
                int total = UtilidadesAutores.totalAutores(autores);
                System.out.println("El " + ColoresUtils.NEGRITA + "total" + ColoresUtils.RESET + " de autores en la biblioteca es " + ColoresUtils.VERDE + ColoresUtils.NEGRITA + total);
                break;
            default:
                break;
        }
    }
}