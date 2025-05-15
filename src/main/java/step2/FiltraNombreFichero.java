package step2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FiltraNombreFichero {
	/**
	 * filtraNombreFichero: devuelve el nombre del fichero sin extensión ni idioma
	 */
	private static final String expRegular = ".*_[a-zA-Z]{2}.properties";
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	private static final String extension = ".properties";
	public String filtraNombreFichero(String nombreCompleto) {
		String nombreSinProperties = "";
		String nombreFichero = "";
		File directorio = new File(rutaDirectorio);
		for (File f : directorio.listFiles()) {
			if (!f.getName().matches(expRegular) && f.getName().contains(nombreCompleto)) {
				nombreFichero = f.getName();
				int index = nombreFichero.indexOf(extension);
				nombreSinProperties = nombreFichero.substring(0, index);
			
		}
	}
		return nombreSinProperties;
}
}
