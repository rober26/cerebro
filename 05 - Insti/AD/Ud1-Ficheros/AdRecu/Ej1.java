import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Ej1 {
    public static void main(String[] args) {
        //Ej1
        List<City> ciudades = leerCSV("cities.hsv");
        for (City ciudad : ciudades){
            System.out.println(ciudad);
        }

        //Ej2
        crearCSV(ciudades);

    }

    public static List<City> leerCSV(String rutaCSV){
        List<City> ciudades = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(rutaCSV))) {
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

    public static void crearCSV(List<City> ciudades){
        try (PrintWriter wt = new PrintWriter(new FileWriter("ciudades.csv"))){
            wt.println("City,CountryCode,State,TimeZone,Latitude,Longitude");
            for (City ciudad: ciudades){
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

    public static void si(){

    }
}
