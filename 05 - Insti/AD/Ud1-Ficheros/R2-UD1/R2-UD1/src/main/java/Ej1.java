import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Libro{

    String Autor;
    String Titulo;
    int Anio;

    public Libro( String titulo,String autor, int anio) {
        Autor = autor;
        Titulo = titulo;
        Anio = anio;
    }

    public String getAutor() {return Autor;}

    public void setAutor(String autor) {Autor = autor;}

    public String getTitulo() {return Titulo;}

    public void setTitulo(String titulo) {Titulo = titulo;}

    public int getAnio() {return Anio;}

    public void setAnio(int anio) {Anio = anio;}

    @Override
    public String toString() {
        return Titulo + "," + Autor + "," + Anio ;
    }
}

public class Ej1 {

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
        try (FileReader reader = new FileReader(archivoXML);){
            List<Libro> librodesearizado = (List<Libro>) xStream.fromXML(reader);
            for (Libro libro : librodesearizado){
                System.out.println(libro);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
