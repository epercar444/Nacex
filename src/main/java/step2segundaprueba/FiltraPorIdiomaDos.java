package step2segundaprueba;

public class FiltraPorIdiomaDos {
	/**
	 * filtraPorIdiomaDos: por defecto el idioma sería "es", que es el idioma que tienen los ficheros por defecto. Si los ficheros son los de idioma,
	 * se quedará con su idioma, separando por "_" y quitando el .properties
	 */
	private static final String extension = ".properties";
	private static final String expRegular = ".*_[a-zA-Z]{2}.properties";
	public String filtraPorIdiomaDos (String nombreFichero) {
		String idioma = "es";
		if (nombreFichero.matches(expRegular)) {
			String [] nombrePartes = nombreFichero.split("_");
			idioma = nombrePartes[1].replace(extension, "");
		}
		return idioma;
	}
}
