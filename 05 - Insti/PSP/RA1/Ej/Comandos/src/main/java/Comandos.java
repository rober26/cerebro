import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Comandos {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        while (exit == false){
            System.out.println("1. Ping \n" +
                    "2. Listar archivos y ficheros\n" +
                    "3. Leer y cerrar procesos\n" +
                    "4.Ejecutar navegador con URl\n"+
                    "5.Salir");
            int seleccion = sc.nextInt();
            switch (seleccion){
                case 1:
                    System.out.print("url:");
                    String url = sc.next();
                    ejComand("ping", url);
                    break;
                case 2:
                    System.out.print("Archivo:");
                    String archivo = sc.next();
                    ejComand("ls", archivo);
                    break;
                case 3:
                    ejComand("ps","-e");
                    System.out.print("PID de proceso a eliminar:");
                    String pid = sc.next();
                    ejComand("kill", pid);
                    break;
                case 4:
                    System.out.print("URL:");
                    url = sc.next();
                    try {
                        Runtime.getRuntime().exec("xdg-open " + url);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Seleccion no valida");
            }
        }
    }

    public static void ejComand(String comando, String URL){
            try {
                ProcessBuilder pb = new ProcessBuilder(comando,URL);
                Process proceso = pb.start();

                //lectura de entrada
                BufferedReader rd = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String linea;
                while ((linea = rd.readLine()) != null){
                    System.out.println(linea);
                }

                proceso.waitFor();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
