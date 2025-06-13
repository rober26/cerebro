package Procesos;

//Roberto Lespe Herrera roberto.lespe@educa.madrid.org

import java.io.BufferedReader;
import java.io.FileReader;

public class GestionItinerarios {
    public static void main(String[] args) {
        System.out.println("ITINERARIOS");
        try (BufferedReader br = new BufferedReader(new FileReader("almacenamiento/reservas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                System.out.println(
                        "Vuelo: " + datos[0].trim() + " -> " + datos[1].trim() + "Fecha de salida:"+datos[2].trim() +" Asiento: " + datos[3].trim()
                );
            }
        } catch (Exception e) {
            System.out.println("No hay reservas guardadas.");
        }
    }
}