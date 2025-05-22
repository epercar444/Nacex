package step4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleTranslate {

    private static final String API_URL = "https://translation.googleapis.com/language/translate/v2"; //url API
    private String apiKey;

    public GoogleTranslate(String apiKey) {
        this.apiKey = apiKey;
    }

    public String translate(String text, String sourceLang, String targetLang) { //constructor que recibe la claveAPI
        try {
            String urlStr = API_URL + "?key=" + apiKey; //API como parámetro

            URL url = new URL(urlStr); //objeto URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //conexion HTTP con la URL
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true); //se va a enviar un cuerpo de datos

            String requestBody = String.format(
                "{\"q\":\"%s\",\"source\":\"%s\",\"target\":\"%s\",\"format\":\"text\"}", //formato JSON
                text, sourceLang, targetLang
            );

            OutputStream os = connection.getOutputStream(); //flujo de salida para enviar los datos
            os.write(requestBody.getBytes("UTF-8"));
            os.close();

            // Lee la respuesta de la API desde el flujo de entrada
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();
            
            // Extrae el texto traducido del JSON (forma simple y manual)
            String jsonResponse = response.toString();
            int start = jsonResponse.indexOf("\"translatedText\":\"") + 18; // Busca el inicio del texto traducido
            int end = jsonResponse.indexOf("\"", start);// Encuentra el final del texto traducido
            return jsonResponse.substring(start, end);// Devuelve solo el texto traducido

        } catch (Exception e) {
            e.printStackTrace();
            return "Error during translation: " + e.getMessage(); //lanza error si hay cualquier excepción en el proceso de traducción
        }
    }
}
