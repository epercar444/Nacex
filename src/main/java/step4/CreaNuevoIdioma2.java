package step4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import step1.FiltraFicheroOrigen;
import step2segundaprueba.FiltraNombreFicheroDos;
import step2segundaprueba.Recurso;

public class CreaNuevoIdioma2 {
	private static final String extension = ".properties";
	public String añadirNuevoIdioma(String idiomaNuevo) {
	    FiltraFicheroOrigen w = new FiltraFicheroOrigen();
	    List<File> ficherosOrigen = w.filtraFicheroOrigen();
	    File ficheroSeleccionado = ficherosOrigen.get(1); // tienes que especificar a que fichero origen le quieres añadir el idioma
	    String nombreFicheroOrigen = ficheroSeleccionado.getName();
	    Recurso recursoOrigen = new Recurso(nombreFicheroOrigen);
	    FiltraNombreFicheroDos r = new FiltraNombreFicheroDos();
	    String nombreRecurso = r.filtraNombreFichero(nombreFicheroOrigen);
	    String nombreNuevo = nombreRecurso + "_" + idiomaNuevo + extension;
	    Recurso v = new Recurso(nombreNuevo);
	    List<Recurso> idiomas = recursoOrigen.getIdiomas();
	    if (idiomas == null) {
	        idiomas = new ArrayList<>();
	        recursoOrigen.setIdiomas(idiomas);
	    }
	    idiomas.add(v);

	    return recursoOrigen.toString();
	}

}
