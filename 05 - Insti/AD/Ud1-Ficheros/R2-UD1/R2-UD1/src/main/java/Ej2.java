import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Ej2 {

    public static void main(String[] args) {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{Libro.class});
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("El principito", "Peter pan", 1960));
        libros.add(new Libro("Don Quijote ", "Cervantes", 1486));
        libros.add(new Libro("Alas de sangre", "Carla", 2021));
        libros.add(new Libro("La sirenita", "Disney", 1943));


        //alias
        xStream.alias("libro",Libro.class);
        //Pasar lista a XML
        String xml = xStream.toXML(libros);
        //Guardar XML en un archivo
        String archivoXML = "Libros.xml";
        try (FileWriter writer = new FileWriter(archivoXML);){
            writer.write(xml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Pasar archivo XML a lista
        List<Libro> librodesearizado;
        try (FileReader reader = new FileReader(archivoXML);){
            librodesearizado = (List<Libro>) xStream.fromXML(reader);
            for (Libro libro : librodesearizado){
                System.out.println(libro);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Pasar XML a JSON
        String Json = "Libros.json";
        try (FileWriter writer = new FileWriter("Libros.JSON")){
            XStream xStreamJson = new XStream(new JsonHierarchicalStreamDriver());
            xStreamJson.alias("libro", Libro.class);
            String json = xStreamJson.toXML(librodesearizado);
            writer.write(json);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Pasar JSON a objetos
        Gson gson = new Gson();
        try (FileReader jsonFile = new FileReader(Json)) {
            Type listType = new TypeToken<List<Libro>>() {}.getType();
            List<Libro> librosJson = gson.fromJson(jsonFile, listType);
            for (Libro libro : librosJson) {
                System.out.println(libro);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
