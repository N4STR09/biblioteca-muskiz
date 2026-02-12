package Classes.menu;

import java.util.List;
import java.util.Scanner;
import Classes.model.*;
import Classes.repository.BibliotecaRepository;
import Classes.utils.*;

public class MenuPrincipal {
    public static void mostrar(Scanner sc, List<Autor> autores, List<Libro> libros) {
        int opcion;

        do {
            TitlesUtils.tituloBiblioteca();
            System.out.println("\n1. " + ColoresUtils.CYAN + "Autores" + ColoresUtils.RESET);
            System.out.println("2. " + ColoresUtils.NARANJA + "Libros" + ColoresUtils.RESET);
            System.out.println("3. " + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
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
        
        BibliotecaRepository.guardarAutores(autores);
        BibliotecaRepository.guardarLibros(libros);

    }
}
