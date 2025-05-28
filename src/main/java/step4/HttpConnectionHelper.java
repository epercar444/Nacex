package step4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionHelper {

    /**
     * Realiza una petición HTTP POST con o sin contenido JSON.
     * 
     * @param urlStr URL a la que se hace la petición.
     * @param body Contenido que se desea enviar (puede ser JSON o no).
     * @param isJson Indica si el contenido es de tipo JSON.
     * @return Respuesta como String.
     * @throws Exception en caso de error de conexión o lectura.
     */
    public static String post(String urlStr, String body, boolean isJson) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        if (isJson) {
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        } else {
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        }

        try (OutputStream os = connection.getOutputStream()) {
            os.write(body.getBytes("UTF-8"));
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
        }

        return response.toString();
    }
}

