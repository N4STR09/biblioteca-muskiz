package Classes;

import java.util.List;
import java.util.Scanner;

public class MenuAutores {
    public static void mostrar(Scanner sc, List<Autores> autores, List<Libros> libros) {
        
        System.out.println("1. Añadir autor");
        System.out.println("2. Eliminar autor");
        System.out.println("3. Visualizar autores");
        System.out.println("4. Estadísticas de autores");
        System.out.println("5. Salir");
        int accion = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 5);
        
        switch (accion) {
            case 1:
                ServiceAutores.añadirAutor(sc, autores, libros);
                break;
            case 2:
                ServiceAutores.eliminarAutor(sc, autores, libros);
                break;
            case 3:
                ServiceAutores.visualizarAutores(sc, autores, libros);
                break;
            case 4: 
                ServiceAutores.estadisticasAutores(sc, autores, libros);
                break;
            default:
                break;
        }
    }
}
