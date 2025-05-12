import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        int contador =  (int) (Math.random()*100+1);
        String archivo = "resultados.txt";
        //File resultado = new File(archivo);
        Files.deleteIfExists(Paths.get(archivo));
        Files.createFile(Paths.get(archivo));

        String argumentos = contador + " " + archivo;
        String comando = "java -jar tarea.jar " + argumentos;
        Process procesoTarea = Runtime.getRuntime().exec(comando);

        if (procesoTarea.waitFor() == 0) {
            List<String> lineas = Files.readAllLines(Paths.get(archivo));
            int resultado = 0;
            for (String linea : lineas){
                resultado += Integer.parseInt(linea);
            }
            System.out.println("la suma es: " + resultado);
        }else {
            System.out.println("Se ha producido un error: " + procesoTarea.exitValue());
        }

    }
}
