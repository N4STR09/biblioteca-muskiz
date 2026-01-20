package Classes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        List<Autores> autores = new ArrayList<>();

        Autores autor1 = new Autores( //creamos un nuevo autor con los siguientes datos
            1, // idAutor
            "Cervantes", // nombre
            "Española", // nacionalidad
            "1547-09-29", // fechaNacimiento
            true, // defuncion
            "1616-04-22", // fechaFallecimiento
            "Escritor del Siglo de Oro", // biografia
            "cervantes.jpg", // foto
            "Novela", // generoLiterario
            "Ninguno", // premios
            "Don Quijote" // obrasDestacadas
        );
        Autores autor2 = new Autores(
            2,
            "Gabriel García Márquez",
            "Colombiana",
            "1927-03-06",
            true,
            "2014-04-17",
            "Autor del realismo mágico",
            "gabo.jpg",
            "Novela",
            "Nobel",
            "Cien años de soledad"
        );
        Autores autor3 = new Autores(
            3,
            "J.K. Rowling",
            "Británica",
            "1965-07-31",
            false,
            "",
            "Autora de Harry Potter",
            "rowling.jpg",
            "Fantasía",
            "Ninguno",
            "Harry Potter"
        );
        Autores autor4 = new Autores(
            4,
            "Isabel Allende",
            "Chilena",
            "1942-08-02",
            false,
            "",
            "Autora de La casa de los espíritus",
            "allende.jpg",
            "Novela",
            "Ninguno",
            "La casa de los espíritus"
        );
        Autores autor5 = new Autores(5,
            "Mario Vargas Llosa",
            "Peruana",
            "1936-03-28",
            false,
            "",
            "Escritor y político",
            "vargas.jpg",
            "Novela",
            "Nobel",
            "La ciudad y los perros"
        );

        autores.add(autor1); //añadimos los autores
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);
        autores.add(autor5);

        List<Libros> libros = new ArrayList<>();

        Libros libro1 = new Libros(
            8,
            3,
            450,
            "Harry Potter y el Caliz de Fuego",
            autor3,
            "Fantasia",
            "2002",
            "Santillana Ediciones",
            "12jhf",
            "Español",
            "Fisico",
            "",
            "",
            "literatura",
            true
        );

        libros.add(new Libros(1, 2, 863, "Don Quijote de la Mancha", autor1, "Novela", "1605", "Francisco de Robles", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(2, 1, 350, "Novelas ejemplares", autor1, "Novela", "1613", "Juan de la Cuesta", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(3, 4, 471, "La Galatea", autor1, "Novela", "1585", "Blas de Robles", "", "Español", "Físico", "", "", "Literatura", true));

        libros.add(new Libros(4, 3, 417, "Cien años de soledad", autor2, "Novela", "1967", "Sudamericana", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(5, 2, 120, "Crónica de una muerte anunciada", autor2, "Novela", "1981", "Oveja Negra", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(6, 1, 368, "El amor en los tiempos del cólera", autor2, "Novela", "1985", "Oveja Negra", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(7, 2, 192, "El coronel no tiene quien le escriba", autor2, "Novela", "1961", "Sudamericana", "", "Español", "Físico", "", "", "Literatura", true));

        libros.add(libro1);
        libros.add(new Libros(9, 5, 223, "Harry Potter y la piedra filosofal", autor3, "Fantasía", "1997", "Bloomsbury", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(10, 4, 251, "Harry Potter y la cámara secreta", autor3, "Fantasía", "1998", "Bloomsbury", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(11, 3, 317, "Harry Potter y el prisionero de Azkaban", autor3, "Fantasía", "1999", "Bloomsbury", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(12, 2, 636, "Harry Potter y la Orden del Fénix", autor3, "Fantasía", "2003", "Bloomsbury", "", "Español", "Físico", "", "", "Literatura", true));

        libros.add(new Libros(13, 2, 432, "La casa de los espíritus", autor4, "Novela", "1982", "Plaza & Janés", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(14, 1, 368, "Eva Luna", autor4, "Novela", "1987", "Plaza & Janés", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(15, 2, 416, "Paula", autor4, "Memorias", "1994", "Plaza & Janés", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(16, 3, 384, "Hija de la fortuna", autor4, "Novela", "1999", "Plaza & Janés", "", "Español", "Físico", "", "", "Literatura", true));

        libros.add(new Libros(17, 2, 432, "La ciudad y los perros", autor5, "Novela", "1963", "Seix Barral", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(18, 1, 376, "Conversación en La Catedral", autor5, "Novela", "1969", "Seix Barral", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(19, 2, 304, "Pantaleón y las visitadoras", autor5, "Novela", "1973", "Seix Barral", "", "Español", "Físico", "", "", "Literatura", true));
        libros.add(new Libros(20, 1, 288, "La fiesta del chivo", autor5, "Novela", "2000", "Alfaguara", "", "Español", "Físico", "", "", "Literatura", true));

        Scanner sc = new Scanner(System.in);
        int opcion;
        int accion;

        do {
            System.out.println("1. Autores");
            System.out.println("2. Libros");
            System.out.println("3. Salir");
            opcion = sc.nextInt();
            sc.nextLine(); //limpiar buffer de entrada

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("1. Añadir autor");
                        System.out.println("2. Eliminar autor");
                        System.out.println("3. Visualizar autores");
                        System.out.println("4. Salir");
                        accion = sc.nextInt();
                        sc.nextLine();
                        
                        if (accion == 1) {
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

                        } else if (accion == 2) {
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
                        } else if (accion == 3) {
                            System.out.println("---- AUTORES ----");

                            for (Autores a : autores) {
                                System.out.println(a.getIdAutor() + " - " + a.getNombre()); //printeamos lo que nos devuelva los getters
                            }
                        }
                    } while (accion != 4);
                    break;
                case 2:
                    do {
                        System.out.println("1. Añadir libro");
                        System.out.println("2. Eliminar libro");
                        System.out.println("3. Visualizar libro");
                        System.out.println("4. Salir");
                        accion = sc.nextInt();
                        sc.nextLine();

                        switch (accion) {
                            case 1:
                                //solicitud de datos al usuario
                                System.out.print("Titulo del libro: ");
                                String titulo = sc.nextLine();

                                System.out.println("Elige el autor del libro por ID:");
                                for (Autores a : autores) {
                                    System.out.println(a.getIdAutor() + " - " + a.getNombre());
                                }

                                System.out.print("ID del autor: ");
                                int idAutor = sc.nextInt();
                                sc.nextLine(); // limpiar buffer

                                Autores autorElegido = null;
                                for (Autores a : autores) {
                                    if (a.getIdAutor() == idAutor) {
                                        autorElegido = a;
                                        break;
                                    }
                                }
                                
                                if (autorElegido == null) {
                                    System.out.println("Autor no encontrado. Libro no creado.");
                                    continue; //funciona como un return pero que no cierra el menú
                                }

                                System.out.print("Género del libro: ");
                                String genero = sc.nextLine();

                                int existencias = 1;
                                int numeroPaginas = 1;
                                String anioPublicacion = "";
                                String editorial = "";
                                String isbn = "";
                                String idioma = "";
                                String formato = "";
                                String portada = ""; 
                                String descripcion = "";
                                String categoria = ""; 
                                boolean disponibilidad = true;

                                int id = libros.size() + 1; //asignacion de ID automatica

                                //creamos un nuevo autor
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

                                libros.add(nuevoLibro); //lo añadimos a la lista
                                System.out.println("Libro añadido correctamente.");
                                break;
                            case 2:
                                if (libros.isEmpty()) {
                                    System.out.println("No hay libros para eliminar.");
                                } else {
                                    System.out.println("---- LIBROS ----");
                                    for (Libros a : libros) {
                                        System.out.println(a.getIdLibro() + " - " + a.getTitulo());
                                    }

                                    System.out.print("Introduce el ID del libro a eliminar: ");
                                    int idLibroEliminar = sc.nextInt();
                                    sc.nextLine(); // limpiar buffer

                                    boolean eliminado = false;

                                    for (int i = 0; i < libros.size(); i++) {
                                        if (libros.get(i).getIdLibro() == idLibroEliminar) {
                                            libros.remove(i);
                                            eliminado = true;
                                            System.out.println("Libro eliminado correctamente.");
                                            break; // importantísimo
                                        }
                                    }

                                    if (!eliminado) {
                                        System.out.println("No se encontró ningún libro con ese ID.");
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("---- LIBROS ----");

                                for (Libros a : libros) {
                                    System.out.println(a.getIdLibro() + " - "+a.getTitulo() + " - " + a.getAutor()); //printeamos lo que nos devuelva los getters
                                }
                                break;
                            }
                        } while (accion != 4);
                    break;
                default:
                    System.out.println("Esa opción no es valida. Introduce una opción permitida.");
                    break;
            }
        } while (opcion != 3);
        sc.close(); //cerramos el scanner para evitar que IDE nos tire un warning de posible data leakage si no lo cerramos
    }
}


