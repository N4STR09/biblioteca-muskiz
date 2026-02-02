package Classes.repository;

import Classes.setup.*;
import Classes.model.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public class BibliotecaRepository {

    private static final String AUTORES_FILE = "biblioteca-muskiz/BibliotecaMuskiz/data/autores.json";
    private static final String LIBROS_FILE = "biblioteca-muskiz/BibliotecaMuskiz/data/libros.json";

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    //autores
    public static void guardarAutores(List<Autores> autores) {
        escribirArchivo(AUTORES_FILE, autores);
    }

    public static List<Autores> cargarAutores() {
        Type type = new TypeToken<List<Autores>>(){}.getType();
        return leerArchivo(AUTORES_FILE, type);
    }

    //libros
    public static void guardarLibros(List<Libros> libros) {
        escribirArchivo(LIBROS_FILE, libros);
    }

    public static List<Libros> cargarLibros() {
        Type type = new TypeToken<List<Libros>>(){}.getType();
        return leerArchivo(LIBROS_FILE, type);
    }

    //genericos
    private static <T> void escribirArchivo(String file, T data) {
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.out.println("Error guardando " + file);
        }
    }

    private static <T> T leerArchivo(String file, Type type) {
        File f = new File(file);
        if (!f.exists()) return null;

        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            System.out.println("Error leyendo " + file);
            return null;
        }
    }
}
