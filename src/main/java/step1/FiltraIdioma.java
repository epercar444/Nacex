package step1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FiltraIdioma {
	private static final String extension = ".properties";
	private static final String expRegular = ".*_[a-zA-Z]{2}.properties";
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	/**
	 * FiltraIdioma: filtra los diferentes idiomas en los que encontramos los ficheros defaults.
	 * @author epercar444
	 * @param directorio1 será la ruta base.
	 * @return una lista de cadenas donde habremos guardado las iniciales de los idiomas traducidos.
	 */
	public List<String> FiltraIdioma(String directorio1) {
		FiltraFicheroIdiomas f = new FiltraFicheroIdiomas();
		List<String> listaIdioma = new ArrayList<String>();
		List<File> idiomas = f.filtraFicheroIdiomas(directorio1);
		for (File f1 : idiomas) {
			String nombreFichero = f1.getName();
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
