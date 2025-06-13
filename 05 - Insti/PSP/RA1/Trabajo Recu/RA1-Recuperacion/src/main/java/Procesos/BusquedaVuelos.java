package Procesos;

//Roberto Lespe Herrera roberto.lespe@educa.madrid.org

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class BusquedaVuelos {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("");
            return;
        }

        String origen = args[0].toLowerCase();
        String destino = args[1].toLowerCase();
        String fecha = args[2];

        String archivoVuelos = "almacenamiento/vuelos.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoVuelos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3 &&
                        origen.equalsIgnoreCase(partes[0].trim()) &&
                        destino.equalsIgnoreCase(partes[1].trim()) &&
                        fecha.equalsIgnoreCase(partes[2].trim())) {

                    System.out.println(partes[0].trim() + "," + partes[1].trim() + "," + partes[2].trim());
                    return;
                }
            }
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("");
        }
    }
}
