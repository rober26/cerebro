import java.io.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Ej1 {
    public static void main(String[] args) {

        // **Paso 1: Crear un objeto Properties y agregar pares clave/valor**
        Properties propiedades = new Properties();
       /*
        propiedades.setProperty("usuario", "admin");
        propiedades.setProperty("contraseña", "1234");
        propiedades.setProperty("NivelPermisos", "4");
    */
        // **Paso 2: Guardar los datos en un archivo de texto y en formato XML**
        /*try(
            FileOutputStream file = new FileOutputStream("config.properties");
            FileOutputStream fileXML = new FileOutputStream("config.xml");
            )  {
            propiedades.store(file, "Configuracion"); // Guarda en formato .properties
            propiedades.storeToXML(fileXML, "Configuración en XML"); // Guarda en formato XML
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        // **Paso 3: Verificar que los datos se guardaron correctamente cargándolos desde el archivo .properties**
        try(
                FileInputStream fileInput = new FileInputStream("config.properties");
                ){
            propiedades.load(fileInput); // Cargar desde archivo de texto
            System.out.println("Datos cargados desde config.properties:");
            System.out.println(propiedades);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // **Paso 4: Cargar los datos desde el archivo XML**
        try(
                FileInputStream fileInputXML = new FileInputStream("config.xml");
                )
        {
            propiedades.loadFromXML(fileInputXML); // Cargar desde XML
            System.out.println("\nDatos cargados desde config.xml:");
            System.out.println(propiedades);
        } catch (InvalidPropertiesFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
