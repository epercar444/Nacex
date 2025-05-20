package step4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleTranslate {

    private static final String API_URL = "https://translation.googleapis.com/language/translate/v2";
    private String apiKey;

    public GoogleTranslate(String apiKey) {
        this.apiKey = apiKey;
    }

    public String translate(String text, String sourceLang, String targetLang) {
        try {
            String urlStr = API_URL + "?key=" + apiKey;

            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true);

            String requestBody = String.format(
                "{\"q\":\"%s\",\"source\":\"%s\",\"target\":\"%s\",\"format\":\"text\"}",
                text, sourceLang, targetLang
            );

            OutputStream os = connection.getOutputStream();
            os.write(requestBody.getBytes("UTF-8"));
            os.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            String jsonResponse = response.toString();
            int start = jsonResponse.indexOf("\"translatedText\":\"") + 18;
            int end = jsonResponse.indexOf("\"", start);
            return jsonResponse.substring(start, end);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error during translation: " + e.getMessage();
        }
    }
}
