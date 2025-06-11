import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        String archivo = "numeros.dat";
        // **Paso 1: Crear un array de 20 números enteros**
        int cantidadNumeros = 20;
        int[] numeros = new int[cantidadNumeros];

        // **Paso 2: Verificar si el archivo existe y cargar los números, o crearlo con ceros**
        File file = new File(archivo);

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            if (file.exists() && file.length() >= cantidadNumeros * 4) {
                System.out.println("Leyendo numeros desde el archivo...");
                for (int i = 0; i < cantidadNumeros; i++) {
                    numeros[i] = raf.readInt();
                }
            } else {
                System.out.println("El archivo no existe. Creando archivo con 20 ceros...");
                for (int i = 0; i < cantidadNumeros; i++) {
                    raf.writeInt(0);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al manejar el archivo: " + e.getMessage());
        }

        // **Paso 3: Modificar un número en el archivo sin alterar el resto**
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
             Scanner scanner = new Scanner(System.in)) {

            // Mostrar los números actuales en el archivo
            System.out.println("\nNúmeros actuales en el archivo:");
            for (int i = 0; i < cantidadNumeros; i++) {
                System.out.println("Índice " + i + ": " + numeros[i]);
            }

            // Pedir al usuario modificar un número
            System.out.print("\nIngrese el índice (0-19) del número a modificar: ");
            int indice = scanner.nextInt();

            if (indice < 0 || indice >= cantidadNumeros) {
                System.out.println("Índice fuera de rango.");
                return;
            }

            System.out.print("Ingrese el nuevo valor: ");
            int nuevoValor = scanner.nextInt();

            // Moverse a la posicion en el archivo y escribir el nuevo numero
            raf.seek(indice * 4); // 4 bytes por cada int
            raf.writeInt(nuevoValor);

            System.out.println("Número en el índice " + indice + " actualizado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
        }
    }
}
