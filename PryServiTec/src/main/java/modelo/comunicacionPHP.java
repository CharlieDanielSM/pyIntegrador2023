
package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class comunicacionPHP 
{
    public static void llamarScriptPHP(String correoUsua, String archivo) {
        try {
            // URL del script PHP con parámetros
            String url = "http://localhost/pyTienda/Correo/correo.php"
                    + "?correoUsua=" + URLEncoder.encode(correoUsua, "UTF-8")
                    + "&archivo=" + URLEncoder.encode(archivo, "UTF-8");

            // Crear conexión
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            // Configurar la solicitud
            connection.setRequestMethod("GET");

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta del script PHP
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Imprimir la respuesta
                System.out.println(response.toString());
            } else {
                System.out.println("La solicitud no fue exitosa. Código de respuesta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
     public static void notificaEmpleado(String correoUsua,String nombEmple,String emailEmple,String teleEmple) {
        try {
            // URL del script PHP con parámetros
            String url = "http://localhost/pyTienda/Correo/correo.php"
                    + "?correoUsua=" + URLEncoder.encode(correoUsua, "UTF-8")
                    + "&nombEmple=" + URLEncoder.encode(nombEmple, "UTF-8")
                    + "&emailEmple=" + URLEncoder.encode(emailEmple, "UTF-8")
                    + "&teleEmple=" + URLEncoder.encode(teleEmple, "UTF-8");
            
            
            // Crear conexión
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            // Configurar la solicitud
            connection.setRequestMethod("GET");

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta del script PHP
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Imprimir la respuesta
                System.out.println(response.toString());
            } else {
                System.out.println("La solicitud no fue exitosa. Código de respuesta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
}
