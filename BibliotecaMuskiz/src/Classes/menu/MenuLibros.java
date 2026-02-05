package Classes.menu;

import java.util.List;
import java.util.Scanner;

import Classes.model.Autores;
import Classes.model.Libros;
import Classes.service.ServiceLibros;
import Classes.utils.ColoresUtils;
import Classes.utils.InputUtils;

public class MenuLibros {
    public static void mostrar(Scanner sc, List<Autores> autores, List<Libros> libros) {
        
        System.out.println("1. " + ColoresUtils.VERDE_OSCURO + "Añadir " + ColoresUtils.RESET + "libro");
        System.out.println("2. " + ColoresUtils.ROJO_OSCURO + "Eliminar " + ColoresUtils.RESET + "libro");
        System.out.println("3. " + ColoresUtils.AZUL_INTENSO + "Visualizar " + ColoresUtils.RESET + "libro");
        System.out.println("4. " + ColoresUtils.AMARILLO_MOSTAZA + "Estadisticas" + ColoresUtils.RESET);
        System.out.println("5. " + ColoresUtils.ROJO_LADRILLO + ColoresUtils.NEGRITA + "Salir" + ColoresUtils.RESET);
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
