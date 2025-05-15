package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import step2segundaprueba.LeerRecurso;
public class TraduccionesNoRealizadas {
	private static final String extension = ".properties";
	public List<String> obtenerTraduccionesFaltantes(String nombreFicheroOrigen, String nombreFicheroIdioma) {
	    if (!nombreFicheroOrigen.endsWith(extension)) {
	        nombreFicheroOrigen += extension;
	    }
	    if (!nombreFicheroIdioma.endsWith(extension)) {
	        nombreFicheroIdioma += extension;
	    }
	    LeerRecurso p = new LeerRecurso();
	    Properties propiedadesOrigen = p.leerRecurso(nombreFicheroOrigen);
	    Properties propiedadesIdioma = p.leerRecurso(nombreFicheroIdioma);

	    List<String> faltan = new ArrayList<String>();

	    for (String clave : propiedadesOrigen.stringPropertyNames()) {
	        if (!propiedadesIdioma.containsKey(clave)) {
	            faltan.add(clave);
	        }
	    }

	    return faltan;
	}

}
