package Classes.menu;

import java.util.List;
import java.util.Scanner;

import Classes.model.Autores;
import Classes.model.Libros;
import Classes.utils.InputUtils;

public class MenuPrincipal {
    public static void mostrar(Scanner sc, List<Autores> autores, List<Libros> libros) {
        int opcion;

        do {
            System.out.println("1. Autores");
            System.out.println("2. Libros");
            System.out.println("3. Salir");
            opcion = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 3);

            switch (opcion) {
                case 1:
                    MenuAutores.mostrar(sc, autores, libros);
                    break;
                case 2:
                    MenuLibros.mostrar(sc, autores, libros);
                default:
                    break;
            }
        } while (opcion != 3);
    }
}
