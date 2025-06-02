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

    public String toCSV() {
        return titulo + "," + autor + "," + anio;
    }

    @Override
    public String toString() {
        return titulo + "," + autor + "," + anio+"\n";
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
                writer.println(libro.toCSV());
            }
            System.out.println("Archivo CSV guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo CSV: " + e.getMessage());
        }

        // Paso 3: Leer el archivo CSV y asegurarse de que los datos se cargan correctamente
        System.out.println("\nLeyendo el archivo CSV:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(archivoCSV), StandardCharsets.UTF_8))) {
            String linea;
            List<Libro> librosNuevos = new ArrayList<>();
            while ((linea = reader.readLine()) != null) {
                String[] datos =  linea.split(",");
                if(datos[2].matches("[0-9]+")){
                    librosNuevos.add( new Libro(datos[0],datos[1],Integer.parseInt(datos[2])));
                }else {
                    System.out.printf(" Titulo, autor, año \n");
                }
            }
            System.out.printf(librosNuevos.toString());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}