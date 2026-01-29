package Classes;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputUtils {

    //comprobar que no es un numero o string vacio
    public static String leerString(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty() || texto.matches("\\d+")) {
                System.out.println("El campo no puede estar vacío o contener números.");
            }
        } while (texto.isEmpty() || texto.matches("\\d+"));
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

    public static LocalDate leerFecha(Scanner sc, String mensaje) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.print(mensaje + " (AAAA-MM-DD): ");
            String entrada = sc.nextLine().trim();

            try {
                return LocalDate.parse(entrada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Formato correcto: AAAA-MM-DD");
            }
        }
    }

    public static int leerNumeroMenu(Scanner sc, String mensaje, int opcionMaxima) {
        while (true) {
            if (mensaje != null) {
                System.out.print(mensaje);
            }
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num >= 1 && num <= opcionMaxima) {
                    return num;
                }
                System.out.println("Selecciona una opción válida entre 1 y " + opcionMaxima + ".");
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        }
    }
}