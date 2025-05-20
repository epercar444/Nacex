package step4;

public class MainTraductor {

public static void main(String[] args) {
		        // Usa tu clave API
		        String apiKey = "AIzaSyDzq1lJt6yIiCEhApDi3udPy-EY4qxWE9A";

		        // Crear el traductor
		        GoogleTranslate translator = new GoogleTranslate(apiKey);

		        // Traducir texto
		        String resultado = translator.translate("Hola, ¿cómo estás?", "es", "en");
		        System.out.println("Traducción: " + resultado);
		    }
		

	

}

