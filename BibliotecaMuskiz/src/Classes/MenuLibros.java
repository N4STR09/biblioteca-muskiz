package Classes;

import java.util.List;
import java.util.Scanner;

public class MenuLibros {
    public static void mostrar(Scanner sc, List<Autores> autores, List<Libros> libros) {
        int accion;
        do {
                        System.out.println("1. Añadir libro");
                        System.out.println("2. Eliminar libro");
                        System.out.println("3. Visualizar libro");
                        System.out.println("4. Estadisticas");
                        System.out.println("5. Salir");
                        accion = sc.nextInt();
                        sc.nextLine();

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
                            }
                        } while (accion != 5);
    }
}
