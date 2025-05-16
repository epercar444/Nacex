package step3;

import java.util.Properties;

import step2segundaprueba.LeerRecurso;

public class GetTraducciones {
	private static final String extension = ".properties";
	/**
	 * getTraducciones: busca la traduccion de la propiedad que le pasemos por parámetro y devolverá su valor en el caso que exista
	 * y nulo en el caso que no lo haga.
	 * @param nombreFichero el nombre del fichero del que leeremos las propiedades
	 * @param nombreFicheroaBuscar el nombre de la propiedad de la que buscaremos la traducción
	 * @return la traduccion a buscar
	 */
	public String getTraducciones(String nombreFichero, String nombreFicheroaBuscar) {
	    if (!nombreFichero.endsWith(extension)) { //le añado la extension en el caso que nos pasen el nombre con el siguiente formato: "web_ca"
	        nombreFichero += extension;
	    }
	    LeerRecurso p = new LeerRecurso();
	    Properties propiedadesIdioma = p.leerRecurso(nombreFichero);
	    String traduccion = propiedadesIdioma.getProperty(nombreFicheroaBuscar);

		return traduccion;
		
	}
}
