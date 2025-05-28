package step4;

public class GoogleTranslate {

    private static final String API_URL = "https://translation.googleapis.com/language/translate/v2";
    private String apiKey;

    public GoogleTranslate(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Traduce texto detectando automáticamente el idioma original.
     * 
     * @param text Texto a traducir.
     * @param targetLang Idioma destino (por ejemplo, "en", "es", "fr").
     * @return Texto traducido o mensaje de error.
     */
    public String translate(String text, String targetLang) {
        try {
            String urlStr = API_URL + "?key=" + apiKey;

            String requestBody = String.format(
                "{\"q\":\"%s\",\"target\":\"%s\",\"format\":\"text\"}",
                text, targetLang
            );

            String jsonResponse = HttpConnectionHelper.post(urlStr, requestBody, true);

            // Extrae el texto traducido del JSON (simple y manual)
            int start = jsonResponse.indexOf("\"translatedText\":\"") + 18;
            int end = jsonResponse.indexOf("\"", start);
            return jsonResponse.substring(start, end);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error during translation: " + e.getMessage();
        }
    }
}
