package Classes.utils;


public class TitlesUtils {
    public static void tituloBiblioteca(){
        System.out.println(ColoresUtils.AZUL + "______ _ _     _ _       _                  ___  ___          _    _     " + ColoresUtils.RESET);
        System.out.println(ColoresUtils.AZUL + "| ___ (_) |   | (_)     | |                 |  \\/  |         | |  (_)    " + ColoresUtils.RESET);
        System.out.println(ColoresUtils.AZUL + "| |_/ /_| |__ | |_  ___ | |_ ___  ___ __ _  | .  . |_   _ ___| | ___ ____" + ColoresUtils.RESET);
        System.out.println(ColoresUtils.AZUL + "| ___ \\ | '_ \\| | |/ _ \\| __/ _ \\/ __/ _` | | |\\/| | | | / __| |/ / |_  /" + ColoresUtils.RESET);
        System.out.println(ColoresUtils.AZUL + "| |_/ / | |_) | | | (_) | ||  __/ (_| (_| | | |  | | |_| \\__ \\   <| |/ / " + ColoresUtils.RESET);
        System.out.println(ColoresUtils.AZUL + "\\____/|_|_.__/|_|_|\\___/ \\__\\___|\\___\\__,_| \\_|  |_/\\__,_|___/_|\\_\\_/___|" + ColoresUtils.RESET);
    }

    public static void tituloAutores(){
        System.out.println(ColoresUtils.MORADO + "   _         _                      ");
        System.out.println("  /_\\  _   _| |_ ___  _ __ ___  ___ ");
        System.out.println(" //_\\\\| | | | __/ _ \\| '__/ _ \\/ __|");
        System.out.println("/  _  \\ |_| | || (_) | | |  __/\\__ \\");
        System.out.println("\\_/ \\_/\\__,_|\\__\\___/|_|  \\___||___/" + ColoresUtils.RESET);
    }

    public static void tituloLibros(){
        System.out.println(ColoresUtils.ROSA + "   __ _ _                   ");
        System.out.println("  / /(_) |__  _ __ ___  ___ ");
        System.out.println(" / / | | '_ \\| '__/ _ \\/ __|");
        System.out.println("/ /__| | |_) | | | (_) \\__ \\");
        System.out.println("\\____/_|_.__/|_|  \\___/|___/" + ColoresUtils.RESET);
    }
    
    public static void tituloNuevoAutor(){
        System.out.println(ColoresUtils.VERDE + "     __                           _         _             ");
        System.out.println("  /\\ \\ \\_   _  _____   _____     /_\\  _   _| |_ ___  _ __ ");
        System.out.println(" /  \\/ / | | |/ _ \\ \\ / / _ \\   //_\\\\| | | | __/ _ \\| '__|");
        System.out.println("/ /\\  /| |_| |  __/\\ V / (_) | /  _  \\ |_| | || (_) | |   ");
        System.out.println("\\_\\ \\/  \\__,_|\\___| \\_/ \\___/  \\_/ \\_/\\__,_|\\__\\___/|_|   " + ColoresUtils.RESET);
    }
    
    public static void tituloNuevoLibro(){
        System.out.println(ColoresUtils.VERDE_OSCURO + "     __                           __ _ _               ");
        System.out.println("  /\\ \\ \\_   _  _____   _____     / /(_) |__  _ __ ___  ");
        System.out.println(" /  \\/ / | | |/ _ \\ \\ / / _ \\   / / | | '_ \\| '__/ _ \\ ");
        System.out.println("/ /\\  /| |_| |  __/\\ V / (_) | / /__| | |_) | | | (_) |");
        System.out.println("\\_\\ \\/  \\__,_|\\___| \\_/ \\___/  \\____/_|_.__/|_|  \\___/ " + ColoresUtils.RESET);
    }
    
    public static void tituloEliminarAutor() {
        System.out.println(ColoresUtils.ROJO + "  ______   _           _                                  _             "); 
        System.out.println(" |  ____| (_)         (_)                      /\\        | |            ");
        System.out.println(" | |__  |  _ _ __ ___  _ _ __   __ _ _ __     /  \\  _   _| |_ ___  _ __ ");
        System.out.println(" |  __| | | | '_ ` _ \\| | '_ \\ / _` | '__|   / /\\ \\| | | | __/ _ \\| '__|");
        System.out.println(" | |____| | | | | | | | | | | | (_| | |     / ____ \\ |_| | || (_) | |  "); 
        System.out.println(" |______|_|_|_| |_| |_|_|_| |_|\\__,_|_|    /_/    \\_\\__,_|\\__\\___/|_|   " + ColoresUtils.RESET);
    }

    
    public static void tituloEliminarLibro() {
        System.out.println(ColoresUtils.ROJO_OSCURO + "  ______ _ _           _                    _      _ _               ");
        System.out.println(" |  ____| (_)         (_)                  | |    (_) |              ");
        System.out.println(" | |__  | |_ _ __ ___  _ _ __   __ _ _ __  | |     _| |__  _ __ ___  ");
        System.out.println(" |  __| | | | '_ ` _ \\| | '_ \\ / _` | '__| | |    | | '_ \\| '__/ _ \\ ");
        System.out.println(" | |____| | | | | | | | | | | | (_| | |    | |____| | |_) | | | (_) |");
        System.out.println(" |______|_|_|_| |_| |_|_|_| |_|\\__,_|_|    |______|_|_.__/|_|  \\___/ " + ColoresUtils.RESET);
    }

    public static void tituloEstadisticas(){
        System.out.println(ColoresUtils.AMARILLO + " _____    _            _ _     _   _               ");
        System.out.println("|  ___|  | |          | (_)   | | (_)              ");
        System.out.println("| |__ ___| |_ __ _  __| |_ ___| |_ _  ___ __ _ ___ ");
        System.out.println("|  __/ __| __/ _` |/ _` | / __| __| |/ __/ _` / __|");
        System.out.println("| |__\\__ \\ || (_| | (_| | \\__ \\ |_| | (_| (_| \\__ \\");
        System.out.println("\\____/___/\\__\\__,_|\\__,_|_|___/\\__|_|\\___\\__,_|___/" + ColoresUtils.RESET);
    }
}