package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import step2segundaprueba.LeerRecurso;
public class TraduccionesNoRealizadas {
	private static final String extension = ".properties";
	/**
	 * obtenerTraduccionesFaltantes: a partir de pasar por parámetro el nombre de los ficheros de los que queremos comparar sus propiedades,
	 * cargamos las propiedades de ambos, recorremos las propiedades del fichero origen y si estas no coincide con las propiedades del fichero idioma
	 * se añade a la lista de String
	 * @param nombreFicheroOrigen el nombre del fichero origen de donde cogeremos las propiedades de referencia
	 * @param nombreFicheroIdioma el nombre del fichero idioma del que leeremos las propiedades
	 * @return una lista de propiedades que no coincidan en ambos ficheros
	 */
	public List<String> obtenerTraduccionesFaltantes(String nombreFicheroOrigen, String nombreFicheroIdioma) {
	    if (!nombreFicheroOrigen.endsWith(extension)) {	//le añado la extension en el caso que nos pasen el nombre con el siguiente formato: "web_ca"
	        nombreFicheroOrigen += extension;
	    }
	    if (!nombreFicheroIdioma.endsWith(extension)) {	//le añado la extension en el caso que nos pasen el nombre con el siguiente formato: "web_ca"
	        nombreFicheroIdioma += extension;
	    }
	    LeerRecurso p = new LeerRecurso();
	    Properties propiedadesOrigen = p.leerRecurso(nombreFicheroOrigen); //cargamos las propiedades de los ficheros
	    Properties propiedadesIdioma = p.leerRecurso(nombreFicheroIdioma);

	    List<String> faltan = new ArrayList<String>();

	    for (String clave : propiedadesOrigen.stringPropertyNames()) {//Recorre el nombre de las propiedades del ficheroque le pasemos y las pasa a String
	        if (!propiedadesIdioma.containsKey(clave)) {
	            faltan.add(clave);
	        }
	    }

	    return faltan;
	}

}
