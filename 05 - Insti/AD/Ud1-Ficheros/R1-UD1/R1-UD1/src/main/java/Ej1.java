import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Ej1 {
    public static void main(String[] args) throws IOException {
        // **Paso 1: Crear un objeto Properties y agregar pares clave/valor**
        Properties propiedades = new Properties();
        propiedades.setProperty("usuario", "admin");
        propiedades.setProperty("contraseña", "1234");
        propiedades.setProperty("NivelPermisos", "4");

        // **Paso 2: Guardar los datos en un archivo de texto y en formato XML**
        FileOutputStream file = new FileOutputStream("config.properties");
        FileOutputStream fileXML = new FileOutputStream("config.xml");

        propiedades.store(file, "Configuracion"); // Guarda en formato .properties
        propiedades.storeToXML(fileXML, "Configuración en XML"); // Guarda en formato XML

        // Cerrar los flujos de salida
        file.close();
        fileXML.close();

        // **Paso 3: Verificar que los datos se guardaron correctamente cargándolos desde el archivo .properties**
        FileInputStream fileInput = new FileInputStream("config.properties");
        propiedades.load(fileInput); // Cargar desde archivo de texto
        System.out.println("Datos cargados desde config.properties:");
        System.out.println(propiedades);

        fileInput.close();

        // **Paso 4: Cargar los datos desde el archivo XML**
        FileInputStream fileInputXML = new FileInputStream("config.xml");
        propiedades.loadFromXML(fileInputXML); // Cargar desde XML
        System.out.println("\nDatos cargados desde config.xml:");
        System.out.println(propiedades);

        fileInputXML.close();
    }

}
