package step1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FiltraFicheroOrigen {
	private static final String extension = ".properties";
	private static final String expRegular = ".*_[a-zA-Z]{2}.properties";
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	/**
	 * filtraFicheroOrigen: filtra por ficheros origen, es decir, aquellos que su nombre no tienen ninguna extensión asociada a un idioma como [ca,es,en]
	 * @return devuelve una lista de ficheros, que contiene el nombre de los ficheros origen
	 */
	public List<File> filtraFicheroOrigen() {
		List<File> ficheros = new ArrayList<File>();
		File directorio = new File(rutaDirectorio);
		for (File f : directorio.listFiles()) {
			if (!f.getName().matches(expRegular)) {
				ficheros.add(f);
			}
		}
		return ficheros;
	}
}
