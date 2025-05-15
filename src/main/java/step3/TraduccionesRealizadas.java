package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import step2segundaprueba.LeerRecurso;

public class TraduccionesRealizadas {
	public List<String> obtenerTraduccionesRealizadas(String nombreFicheroOrigen, String nombreFicheroIdioma) {
	    LeerRecurso p = new LeerRecurso();
	    Properties propiedadesOrigen = p.leerRecurso(nombreFicheroOrigen);
	    Properties propiedadesIdioma = p.leerRecurso(nombreFicheroIdioma);

	    List<String> estan = new ArrayList<String>();

	    for (String clave : propiedadesOrigen.stringPropertyNames()) {
	        if (propiedadesIdioma.containsKey(clave)) {
	            estan.add(clave);
	        }
	    }

	    return estan;
	}

}

