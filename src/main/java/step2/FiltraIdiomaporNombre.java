package step2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import step1.FiltraFicheroIdiomas;

public class FiltraIdiomaporNombre {
	/**
	 * filtraIdiomaporNombre: recoge la lista de ficheros del método filtraFicheroIdiomaconNombre y saca los locale de los idiomas en los que podemos encontrar dicho fichero
	 */
	private static final String extension = ".properties";
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	public List<String> FiltraIdiomaporNombre(String directorio1,String nombreFichero) {
		FiltraFicheroIdiomas f = new FiltraFicheroIdiomas();
		List<String> listaIdioma = new ArrayList<String>();
		FiltraFicheroIdiomasporNombre c = new FiltraFicheroIdiomasporNombre();
		List<File> idiomas = c.FiltraFicheroIdiomaconNombre(directorio1,nombreFichero);
		System.out.println(idiomas);
		for (File f1 : idiomas) {
			nombreFichero = f1.getName();
			int index = nombreFichero.indexOf(extension);
			if (nombreFichero.split("_").length > 2) {
				listaIdioma.add(nombreFichero.substring(index - 4, index));
			}
			else {
				listaIdioma.add(nombreFichero.substring(index - 2, index));
			}
		}
		return listaIdioma;
	}
}
