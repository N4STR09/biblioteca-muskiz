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
            1,
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

        Scanner sc = new Scanner(System.in);
        int opcion;
        int accion;

        do {
            System.out.println("1. Autores");
            System.out.println("2. Libros");
            System.out.println("3. Salir");
            opcion = sc.nextInt();
            sc.nextLine(); //limpiar buffer de entrada

            if (opcion == 1) {
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
            } else if (opcion == 2) {
                do {
                    System.out.println("1. Añadir libro");
                    System.out.println("2. Eliminar libro");
                    System.out.println("3. Visualizar libro");
                    System.out.println("4. Salir");
                    accion = sc.nextInt();
                    sc.nextLine();

                    if (accion == 1) {
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
                            return; // o continue si estás en un menú
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

                        libros.add(nuevoLibro); //lo añadimos a la lista */
                        System.out.println("Libro añadido correctamente.");
                    } else if (accion == 2) {
                        //TODO crear funcionalidad de eliminar libro
                    } else if (accion == 3) {
                        System.out.println("---- LIBROS ----");

                        /*for (Libros a : libros) {
                            System.out.println(a.getIdLibro() + " - " + a.getNombre()); //printeamos lo que nos devuelva los getters
                        }*/
                    }
                } while (accion != 4);
            }

        } while (opcion != 3);
        sc.close(); //cerramos el scanner para evitar que IDE nos tire un warning de posible data leakage si no lo cerramos
    }
}

