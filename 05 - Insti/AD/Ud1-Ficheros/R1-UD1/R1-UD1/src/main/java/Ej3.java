import java.io.*;

// Clase que implementa Serializable para que sus objetos puedan ser guardados en un archivo
class Persona implements Serializable {
    private static final long serialVersionUID = 1L; // Versión de serialización
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
    }
}

public class Ej3 {
    public static void main(String[] args) {
        String archivo = "personas.dat"; // Nombre del archivo binario

        // **Paso 1: Guardar objetos en un archivo binario**
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            // Crear objetos
            Persona p1 = new Persona("Juan", 30);
            Persona p2 = new Persona("María", 25);

            // Escribir los objetos en el archivo
            oos.writeObject(p1);
            oos.writeObject(p2);

            System.out.println("Objetos guardados correctamente en " + archivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }

        // **Paso 2: Leer los objetos desde el archivo binario**
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            // Leer los objetos del archivo
            Persona persona1 = (Persona) ois.readObject();
            Persona persona2 = (Persona) ois.readObject();

            // Mostrar los objetos leídos
            System.out.println("\nObjetos leídos del archivo:");
            System.out.println(persona1);
            System.out.println(persona2);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

