import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class Libro {
    String titulo;
    String autor;
    int anio;

    public Libro(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return titulo + "," + autor + "," + anio;
    }
}

public class Ej2 {
    public static void main(String[] args) {
        // Paso 1: Crear una coleccion de objetos
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("El principito", "Peter pan", 1960));
        libros.add(new Libro("Don Quijote ", "Cervantes", 1486));
        libros.add(new Libro("Alas de sangre", "Carla", 2021));
        libros.add(new Libro("La sirenita", "Disney", 1943));

        String archivoCSV = "libros.csv";

        // Paso 2: Guardar la coleccion en un archivo CSV
        try (PrintWriter writer = new PrintWriter(archivoCSV, StandardCharsets.UTF_8)) {
            writer.println("Titulo,Autor,Año");
            for (Libro libro : libros) {
                writer.println(libro);
            }
            System.out.println("Archivo CSV guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo CSV: " + e.getMessage());
        }

        // Paso 3: Leer el archivo CSV y asegurarse de que los datos se cargan correctamente
        System.out.println("\nLeyendo el archivo CSV:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(archivoCSV), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}