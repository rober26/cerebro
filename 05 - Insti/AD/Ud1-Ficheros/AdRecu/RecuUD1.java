import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RecuUD1 {

	static String RUTA_CONFIG = "config.xml";

	public static void main(String[] args) {
		List<City> cities;
		Properties config;

		/* Líneas a comentar si se implementa el 1.3 y 1.4 */
		config = new Properties();
		config.setProperty("RUTA_HSV", "cities.hsv");
		config.setProperty("RUTA_CSV", "cities.csv");
		config.setProperty("RUTA_FICHERO_XML", "cities.xml");
		config.setProperty("RUTA_FICHERO_JSON", "cities.json");
		config.setProperty("RUTA_BINARIO", "numbers.data");

		// Ejercicio 1.3:
		guardaPropertiesXml(RUTA_CONFIG, config); // tras ejecutarlo una vez comentar desde primer comentario hasta aquí.
		/* FIN líneas a comentar */
		
		// 1.3 bis:
		config = leePropertiesXml(RUTA_CONFIG);

		// Ejercicio 1.1:
		cities = leeDeHSV(config.getProperty("RUTA_HSV"));

		// Ejericio 1.2:
		guardaEnCSV(config.getProperty("RUTA_CSV"), cities);

		// Ejercicio2.1: con varias versiones según se haga 2.1 y 2.2
		guardaXml(config.getProperty("RUTA_FICHERO_XML"), cities);

		// Ejercicio 2.3:
		List<City> cities2 = leeXml(config.getProperty("RUTA_FICHERO_XML"));

		// Ejercicio 3.1
		guardaJson(config.getProperty("RUTA_FICHERO_JSON"), cities);

		// Ejercicio 3.2
		List<City> cities3 = leeJson(config.getProperty("RUTA_FICHERO_JSON"));

		// Ejercicio 4.1
		int[] nums = { 13, 32, 1, 3, 5, 8, 10, 3 };
		guardaBinario(config.getProperty("RUTA_BINARIO"), nums);

		guardaUnBinario(config.getProperty("RUTA_BINARIO"), 3, 4);
	}
	//Ej1.3
	static void guardaPropertiesXml(final String RUTA, Properties properties) {

	}
	
	static Properties leePropertiesXml(final String RUTA) { return null; }

	//Ej1.1
	static List<City> leeDeHSV(final String RUTA) {
		List<City> ciudades = new ArrayList<>();
		try (BufferedReader rd = new BufferedReader(new FileReader(RUTA))) {
			String linea = rd.readLine();
			while ((linea = rd.readLine()) != null){
				String[] datos = linea.split("###");
				City ciudad = new City(datos[0],datos[1],datos[2],datos[3],Double.parseDouble(datos[4]),Double.parseDouble(datos[5]));
				ciudades.add(ciudad);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return ciudades;
	}

	//Ej1.2
	static void guardaEnCSV(final String RUTA, List<City> cities) {
		try (PrintWriter wt = new PrintWriter(new FileWriter(RUTA))){
			wt.println("City,CountryCode,State,TimeZone,Latitude,Longitude");
			for (City ciudad: cities){
				wt.println(
						ciudad.getName() + ","+
								ciudad.getCountryCode() + ","+
								ciudad.getState() + ","+
								ciudad.getTimeZone() + ","+
								ciudad.getLatitude() + ","+
								ciudad.getLongitude()
				);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//Ej2.1
	static void guardaXml(final String RUTA, List<City> cities) {

	}
	//2.3
	static List<City> leeXml(final String RUTA) {
		return null;
	}
	//3.1
	static void guardaJson(final String RUTA, List<City> cities) {

	}
	//3.2
	static List<City> leeJson(final String RUTA) {
		return null;
	}
	//4.1
	static void guardaBinario(final String RUTA, int[] valores) {
	}
	//4.2
	static void guardaUnBinario(final String RUTA, int posición, int valor) {
	}

}
