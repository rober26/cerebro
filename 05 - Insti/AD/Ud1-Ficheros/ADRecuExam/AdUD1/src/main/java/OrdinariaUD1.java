import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class OrdinariaUD1 {
	static final String RUTA_FICHERO_CSV = "pokemon.csv";
	static final String RUTA_FICHERO_XML = "pokemon.xml";
	static final String RUTA_FICHERO_JSON = "pokemon.json";
	static final String RUTA_FICHERO_CSV2 = "pokemon2.csv";
	static final String RUTA_FICHERO_XML2 = "pokemon2.xml";
	static final String RUTA_FICHERO_JSON2 = "pokemon2.json";

	public static void main(String[] args) {
		List<Pokemon> lista1 = leeCsv(RUTA_FICHERO_CSV);
		guardaXml(RUTA_FICHERO_XML,lista1);
		guardaXml2(RUTA_FICHERO_XML2,lista1);
		guardaJson(RUTA_FICHERO_JSON,lista1);
		guardaJson2(RUTA_FICHERO_JSON2,lista1);
		List<Pokemon> lista2 = leeXml(RUTA_FICHERO_XML);
		List<Pokemon> lista3 = leeXml2(RUTA_FICHERO_XML2);
		List<Pokemon> lista4 = leeJson(RUTA_FICHERO_JSON);
		List<Pokemon> lista5 = leeJson2(RUTA_FICHERO_JSON2);
		guardaCsv2(RUTA_FICHERO_CSV2,lista1);
		
		// Comprobaciones (opcional)
//		System.exit(0);  // borrar esta línea para hacer las comrpobaciones:
		if (lista1.size()==800) {
			System.out.println("Parece que el apartado 1 puede estar bien");
		}
		if ((lista1.size() == lista2.size()) && lista2.containsAll(lista1)) {
			System.out.println("Apartados 2 y 6 probablemente bien");
		}
		if ((lista1.size() == lista3.size()) && lista3.containsAll(lista1)) {
			System.out.println("Apartados 3 y 7 probablemente bien");
		}
		if ((lista1.size() == lista4.size()) && lista4.containsAll(lista1)) {
			System.out.println("Apartados 4 y 8 probablemente bien");
		}
		if ((lista1.size() == lista5.size()) && lista5.containsAll(lista1)) {
			System.out.println("Apartados 5 y 9 probablemente bien");
		}
		
	}
	//1
	static List<Pokemon> leeCsv(final String RUTA) {
		List<Pokemon> pokedex = new ArrayList<>();
		try (BufferedReader rd = new BufferedReader(new FileReader(RUTA))){
			String lineas;
			while ((lineas = rd.readLine()) != null){
				String[] datos = lineas.split(",");
				Pokemon pokemon = new Pokemon(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],Integer.parseInt(datos[4]),Integer.parseInt(datos[5]),Integer.parseInt(datos[6]),Integer.parseInt(datos[7]),Integer.parseInt(datos[8]),Integer.parseInt(datos[9]),Integer.parseInt(datos[10]),Integer.parseInt(datos[11]),Boolean.parseBoolean(datos[12]));
				pokedex.add(pokemon);
			}
		} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		return pokedex;
	}
	//EJ6 revisar
	static List<Pokemon> leeXml(final String RUTA) {
        XStream xs = new XStream(new DomDriver());
		xs.addPermission(AnyTypePermission.ANY);
        List<Pokemon> pokedex = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))){
            pokedex = (List<Pokemon>) xs.fromXML(br);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pokedex;
    }
	//EJ7
	static List<Pokemon> leeXml2(final String RUTA) {
		return null;
	}

	static List<Pokemon> leeJson(final String RUTA) {
		return null; // quitar
	}

	static List<Pokemon> leeJson2(final String RUTA) {
		return null; // quitar
	}

	static void guardaCsv2(final String RUTA, List<Pokemon> lista) {

	}
	//2
	static void guardaXml(final String RUTA, List<Pokemon> lista) {
		XStream xs = new XStream(new DomDriver());
		String xml = "";
		try(FileWriter wr = new FileWriter(RUTA)){
				xml = xs.toXML(lista);
				wr.write(xml);
		} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	//3 sin terminar
	static void guardaXml2(final String RUTA, List<Pokemon> lista) {
		XStream xs = new XStream(new DomDriver());
		xs.alias("Pokemon", Pokemon.class);
		xs.alias("pokedes",List.class);
		String xml = "";
		try(BufferedWriter wr = new BufferedWriter(new FileWriter(RUTA))){
			xml = xs.toXML(lista);
			wr.write(xml);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//4
	static void guardaJson(final String RUTA, List<Pokemon> lista) {
		try(BufferedWriter wr = new BufferedWriter(new FileWriter(RUTA))){
			String json = new Gson().toJson(lista);
			wr.write(json);
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	//5
	static void guardaJson2(final String RUTA, List<Pokemon> lista) {
	}

}
