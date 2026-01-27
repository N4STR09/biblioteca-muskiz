package Classes;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void mostrar(Scanner sc, List<Autores> autores, List<Libros> libros) {
        
        int opcion;

        do {
            System.out.println("1. Autores");
            System.out.println("2. Libros");
            System.out.println("3. Salir");
            opcion = sc.nextInt();
            sc.nextLine(); //limpiar buffer de entrada

            switch (opcion) {
                case 1:
                    MenuAutores.mostrar(sc, autores, libros);
                    break;
                case 2:
                    MenuLibros.mostrar(sc, autores, libros);
                default:
                    if (opcion != 3) {
                        System.out.println("Esa opción no es valida. Introduce una opción permitida.");
                    }
                    break;
            }
        } while (opcion != 3);
    }
}
