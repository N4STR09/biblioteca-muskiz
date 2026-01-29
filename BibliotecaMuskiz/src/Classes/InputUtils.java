package Classes;

import java.util.Scanner;

public class InputUtils {

    public static String leerString(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El campo no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public static int leerInt(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num > 0) return num;
                System.out.println("Debe ser mayor que 0.");
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        }
    }

    public static boolean leerBoolean(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje + " (s/n): ");
            String entrada = sc.nextLine().trim().toLowerCase();

            if (entrada.equals("s") || entrada.equals("si")) {
                return true;
            }
            if (entrada.equals("n") || entrada.equals("no")) {
                return false;
            }

            System.out.println("Respuesta inválida. Usa 's' o 'n'.");
        }
    }

}
