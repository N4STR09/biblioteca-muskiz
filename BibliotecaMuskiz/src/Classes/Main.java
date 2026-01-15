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

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Ver autores");
            System.out.println("2. Salir");
            opcion = sc.nextInt();
            sc.nextLine(); //limpiar buffer de entrada

            if (opcion == 1) {
                System.out.println("---- AUTORES ----");

                for (Autores a : autores) {
                    System.out.println(a.getIdAutor() + " - " + a.getNombre()); //printeamos lo que nos devuelva los getters
                }
            }

        } while (opcion != 2);
        sc.close(); //cerramos el scanner para evitar que IDE nos tire un warning de posible data leakage si no lo cerramos
    }
}

