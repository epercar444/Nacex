package step4;

import java.io.File;
import java.util.List;

import step1.FiltraFicheroOrigen;
import step2segundaprueba.Recurso;

public class CreaNuevoIdioma {
	final static String rutaDirectorio = "src" + File.separator + "main" + File.separator + "resources";
	public void añadirNuevoIdioma (String idiomaNuevo,String nombreFicheroOrigen) {
		FiltraFicheroOrigen w = new FiltraFicheroOrigen();
		List<File> ficherosOrigen = w.filtraFicheroOrigen();
		for (File g : ficherosOrigen) {
			while (g.getName().equals(nombreFicheroOrigen)) {
				String nombreActual = nombreFicheroOrigen + "_" + idiomaNuevo;
				Recurso f = new Recurso (rutaDirectorio, nombreActual);
			}
		}
	}
}
