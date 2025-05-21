package step4;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import step1.FiltraFicheroOrigen;
import step2segundaprueba.FiltraNombreFicheroDos;
import step2segundaprueba.Recurso;

public class CreaNuevoIdioma {
	private static final String extension = ".properties";
	/**
	 * añadirNuevoIdioma: añade un nuevo idioma en la lista de idiomas del fichero que le indiquemos
	 * @param idiomaNuevo idioma a añadir
	 * @param nombreFicheroOrigen nombre del fichero al que queremos añadir el idioma indicado    
	 * @return
	 */

    public String añadirNuevoIdioma(String idiomaNuevo, String nombreFicheroOrigen) {
	    if (!nombreFicheroOrigen.endsWith(extension)) {	//le añado la extension en el caso que nos pasen el nombre con el siguiente formato: "web_ca"
	        nombreFicheroOrigen += extension;
	    }
        Recurso recursoOrigen = new Recurso(nombreFicheroOrigen);
        FiltraFicheroOrigen w = new FiltraFicheroOrigen();
        List<File> ficherosOrigen = w.filtraFicheroOrigen();
        for (File g : ficherosOrigen) {
            if (g.getName().equals(nombreFicheroOrigen)) {
                FiltraNombreFicheroDos r = new FiltraNombreFicheroDos();
                String nombreRecurso = r.filtraNombreFichero(nombreFicheroOrigen);
                String nombreNuevo = nombreRecurso + "_" + idiomaNuevo + extension;
                Recurso nuevoIdioma = new Recurso(nombreNuevo);
                List<Recurso> idiomas = recursoOrigen.getIdiomas();
                if (idiomas == null) {
                    idiomas = new ArrayList<>();
                    recursoOrigen.setIdiomas(idiomas);
                }
                idiomas.add(nuevoIdioma);
                }
        }
		return recursoOrigen.toString();
    }
}
