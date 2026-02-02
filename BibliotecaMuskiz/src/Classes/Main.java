package Classes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.menu.MenuPrincipal;
import Classes.model.Autores;
import Classes.model.Libros;
import Classes.setup.Inicializaciones;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Autores> autores = new ArrayList<>();
        List<Libros> libros = new ArrayList<>();

        Inicializaciones.inicializar(autores, libros);

        MenuPrincipal.mostrar(sc, autores, libros);
        sc.close(); //cerramos el scanner para evitar que IDE nos tire un warning de posible data leakage si no lo cerramos
    }
}