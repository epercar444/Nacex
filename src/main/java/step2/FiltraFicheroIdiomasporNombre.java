package step2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import step1.FiltraFicheroOrigen;

public class FiltraFicheroIdiomasporNombre {
	/**
	 * filtraFicheroIdiomaconNombre: con el nombre del fichero pasado por parámetro, recorre el directorio y guarda en una lista la ruta 
	 * de los ficheros de idioma, es decir, que coincidan con el nombre del fichero pasado por parámetro
	 */
	private static final String extension = ".properties";
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	public List<File> FiltraFicheroIdiomaconNombre(String directorio1, String nombreFichero) {
		List<File> recursosIdiomas = new ArrayList<File>();
		FiltraFicheroOrigen m = new FiltraFicheroOrigen();
		List<File> ficherosOrigen = m.filtraFicheroOrigen();
		File directorio = new File(rutaDirectorio);
		for (File f : directorio.listFiles()) {
			if (f.getName().contains(nombreFichero) && !ficherosOrigen.contains(f))
				recursosIdiomas.add(f);
		}
		return recursosIdiomas;
	}
}
