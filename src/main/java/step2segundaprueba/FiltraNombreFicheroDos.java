package step2segundaprueba;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FiltraNombreFicheroDos {
	/**
	 * filtraNombreFichero: devuelve el nombre del fichero sin extensión pero dejando los idiomas ya que crea un nuevo recurso con cada uno de ellos
	 */
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	private static final String extension = ".properties";
	public String filtraNombreFichero(String nombreCompleto) {
		String nombreSinProperties = "";
		String nombreFichero = "";
		File directorio = new File(rutaDirectorio);
		for (File f : directorio.listFiles()) {
			if (f.getName().endsWith(extension) && f.getName().contains(nombreCompleto)) {
				nombreFichero = f.getName();
				nombreSinProperties = nombreFichero.replace(".properties", "");
		}
	}
		return nombreSinProperties;
}
}

