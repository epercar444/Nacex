package step1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FiltraFicheroIdiomas {
	private static final String extension = ".properties";
	private static final String expRegular = ".*_[a-zA-Z]{2}.properties";
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	/** 
	 * filtraFicheroIdiomas: busca los diferentes nombres en los que encontramos el fichero que le pasamos por parámetro.
	 * @param directorio1 será la ruta base por la que queremos filtrar
	 * @return lista de ficheros que contienen la extensión de dichos idiomas, es decir, directorio1_idioma
	 */
	public List<File> filtraFicheroIdiomas(String directorio1) {
		List<File> idiomas = new ArrayList<File>();
		File directorio = new File(rutaDirectorio);
		for (File f : directorio.listFiles()) {
			if (f.getName().matches(directorio1 + expRegular)) {
				idiomas.add(f);
			}
		}
		return idiomas;
	}
}
