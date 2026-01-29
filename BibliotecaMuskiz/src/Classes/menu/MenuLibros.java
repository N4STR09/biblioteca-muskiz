package Classes.menu;

import java.util.List;
import java.util.Scanner;

import Classes.model.Autores;
import Classes.model.Libros;
import Classes.service.ServiceLibros;
import Classes.utils.InputUtils;

public class MenuLibros {
    public static void mostrar(Scanner sc, List<Autores> autores, List<Libros> libros) {
        
        System.out.println("1. Añadir libro");
        System.out.println("2. Eliminar libro");
        System.out.println("3. Visualizar libro");
        System.out.println("4. Estadisticas");
        System.out.println("5. Salir");
        int accion = InputUtils.leerNumeroMenu(sc, "Selecciona una opción: ", 5);
        
        switch (accion) {
            case 1:
                ServiceLibros.añadirLibro(sc, autores, libros);
                break;
            case 2:
                ServiceLibros.eliminarLibro(sc, autores, libros);
                break;
            case 3:
                ServiceLibros.mostrarLibros(sc, autores, libros);
                break;
            case 4:
                ServiceLibros.estadisticasLibros(sc, autores, libros);
                break;
            default:
                break;
        }
    }
}
