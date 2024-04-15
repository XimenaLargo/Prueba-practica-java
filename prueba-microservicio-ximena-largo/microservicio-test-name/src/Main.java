import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args){

        String nombre = "Ximena";

        try{
            String apiUrl = "https://sisedevco.ikeasistencia.com/api-swagger/api/v1/controller/test?name=" + nombre;

            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();

            if (statusCode == 302) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String jsonResponse = response.toString();

                String[] parts = jsonResponse.split("\"nombre\":");

                String nombreResultado =  parts[1].split(",")[0].replaceAll("}", "");

                System.out.println("Resultado encontrado: " + nombreResultado);

            } else if (statusCode == 404) {

                System.out.println("Sin resultados.");

            } else {

                System.out.println("Respuesta inesperada: " + statusCode);

            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}