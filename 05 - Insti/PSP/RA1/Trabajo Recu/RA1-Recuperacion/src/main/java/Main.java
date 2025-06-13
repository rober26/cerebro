import java.io.*;
import java.util.Scanner;

//Roberto Lespe Herrera roberto.lespe@educa.madrid.org

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String classpath = "target/classes";
    static String JAVA = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";

    public static void main(String[] args) {
        while (true){
            System.out.println("MENU");
            System.out.println("1.Reservar vuelo");
            System.out.println("2.Gestionar vuelos");
            System.out.println("*.Salir");
            System.out.print("Selecionar opcion: ");
            String opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    try {
                        buscarYReservarVuelo();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "2":
                    try {
                        ProcessBuilder pb = new ProcessBuilder(JAVA, "-cp", classpath, "Procesos.GestionItinerarios");
                        pb.inheritIO();
                        pb.start().waitFor();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("adios");
                    return;
            }
        }
    }
    private static void buscarYReservarVuelo() throws Exception {
        System.out.print("Origen: ");
        String origen = sc.nextLine().toLowerCase().trim();
        System.out.print("Destino: ");
        String destino = sc.nextLine().toLowerCase().trim();
        System.out.print("Fecha (dd-mm-aaaa): ");
        String fecha = sc.nextLine().trim();

        // Bucar vuelos
        String vuelo = ejecutarProcesoConArgumentosYLeerSalida(
                "Procesos.BusquedaVuelos", origen, destino, fecha);

        if (vuelo == null || vuelo.isEmpty()) {
            System.out.println("No se an encontrado vuelos." + vuelo);
            return;
        }

        System.out.println("Vuelo encontrado: " + vuelo);

        // Elegir asiento
        System.out.println("Selecionar asiento");
        String asiento = seleccionarAsientoManual();

        if (asiento == null || asiento.isEmpty()) {
            System.out.println("Reserva cancelada.");
            return;
        }

        //REservar vuelo
        ejecutarReserva(vuelo, asiento);
    }


    private static String seleccionarAsientoManual() {
        String[] asientosDisponibles = {"A1", "A2", "B1", "B2", "C1", "C2"};
        System.out.println("Asientos disponibles: " + String.join(", ", asientosDisponibles));
        System.out.print("Seleccione asiento (o Enter para cancelar): ");

        String asiento = sc.nextLine().trim().toUpperCase();
        for (String a : asientosDisponibles) {
            if (a.equals(asiento)) {
                return asiento;
            }
        }
        return "";
    }

    // Nuevo metodo para reserva simplificada
    private static void ejecutarReserva(String vuelo, String asiento) throws Exception {
        try (FileWriter fw = new FileWriter("almacenamiento/reservas.txt", true)) {
            fw.write(vuelo + "," + asiento + "\n");
            System.out.println("Reserva confirmada:");
            System.out.println("Vuelo: " + vuelo);
            System.out.println("Asiento: " + asiento);

        } catch (IOException e) {
            System.err.println("Error al guardar reserva: " + e.getMessage());
        }
    }

    private static String ejecutarProcesoConArgumentosYLeerSalida(String clase, String... args) throws Exception {
        String[] comando = new String[4 + args.length];
        comando[0] = JAVA;
        comando[1] = "-cp";
        comando[2] = classpath;
        comando[3] = clase;
        System.arraycopy(args, 0, comando, 4, args.length);

        ProcessBuilder pb = new ProcessBuilder(comando);
        Process proceso = pb.start();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(proceso.getInputStream()))) {

            StringBuilder salida = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                salida.append(linea);
            }

            proceso.waitFor();
            return salida.toString().trim();
        }
    }
}