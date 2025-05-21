package step4;

public class MainTraductor {

public static void main(String[] args) {
		        String apiKey = "AIzaSyDzq1lJt6yIiCEhApDi3udPy-EY4qxWE9A";
		        GoogleTranslate translator = new GoogleTranslate(apiKey);
		        String resultado = translator.translate("Hola, ¿cómo estás?", "es", "en");
		        System.out.println("Traducción: " + resultado);
		    }
		

	

}

