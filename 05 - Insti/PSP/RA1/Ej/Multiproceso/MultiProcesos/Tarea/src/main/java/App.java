import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length <= 1 ) {
            System.out.println("numero de parametros incorrecto.");
            System.exit(-1);
        }

        int contador = Integer.parseInt(args[0]);
        String archivo = args[1];

        if (Files.notExists(Paths.get(archivo))) {
            System.out.println("Archivo inexistente.");
            System.exit(-1);
            //Files.createFile(Paths.get(archivo));
        }

        while (contador >= 0){
            Thread.sleep(200L);
            String linea = contador + "\n";
            /*(String.valueOf(contador) + "\n").getBytes();
            (contador + "\n").getBytes();
            */
            Files.write(Paths.get(archivo),linea.getBytes(), StandardOpenOption.APPEND);
            contador--;
        }
    }
}
