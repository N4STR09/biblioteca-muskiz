package Classes;

import java.util.List;
import java.util.Scanner;

public class ServiceAutores {
    public static void añadirAutor(Scanner sc, List<Autores> autores, List<Libros> libros) {
        
        //solicitud de datos al usuario
        System.out.print("Nombre del autor: ");
        String nombre = sc.nextLine();

        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();

        System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
        String fechaNacimiento = sc.nextLine();

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

        //creamos un nuevo autor
        Autores nuevoAutor = new Autores(
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
                        Autores max = UtilidadesAutores.autorMasLibros(autores);
                        System.out.println("El autor con más libros en la biblioteca es " + max.getNombre() + " con " + UtilidadesAutores.autorMasLibros(autores) + " libros");
                        break;
                    case 2:
                        Autores min = UtilidadesAutores.autorMenosLibros(autores);
                        System.out.println("El autor con menos libros en la biblioteca es " + min.getNombre() + " con " + UtilidadesAutores.autorMenosLibros(autores) + " páginas.");
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
                        String max = UtilidadesAutores.autorLibroMasLargo(autores, libros);
                        System.out.println("El autor con el libro más largo es " + max);
                        break;
                    case 2:
                        String min = UtilidadesAutores.autorLibroMasCorto(autores, libros);
                        System.out.println("El autor con el libro más corto es " + min);
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
                        String max = UtilidadesAutores.autorMasViejo(autores);
                        System.out.println("El autor más viejo es " + max);
                        break;
                    case 2:
                        String min = UtilidadesAutores.autorMasJoven(autores);
                        System.out.println("El autor más joven es " + min);
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
