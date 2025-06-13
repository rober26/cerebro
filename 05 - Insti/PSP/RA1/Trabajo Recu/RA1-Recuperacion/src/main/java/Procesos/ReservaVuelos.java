package Procesos;

//Roberto Lespe Herrera roberto.lespe@educa.madrid.org

import java.io.FileWriter;

public class ReservaVuelos {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Faltan argumentos");
            return;
        }

        String vuelo = args[0];
        String asiento = args[1];

        try (FileWriter fw = new FileWriter("almacenamiento/reservas.txt", true)) {
            fw.write(vuelo + "," + asiento + "\n");
            System.out.println("Vuelop reservado: " + vuelo + " Asiento: " + asiento);
        }
    }
}
