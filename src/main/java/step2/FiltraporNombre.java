package step2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FiltraporNombre {
	/**
	 * filtraPorNombre: pasándole por parámetro una ruta de directorio y un nombre de fichero, buscará en dicha ruta el nombre de fichero y devolverá
	 * una lista de todos los ficheros que coincidan con el nombre pasado (tanto el de origen como los de idioma)
	 */
	final static String rutaDirectorio = "src\\main\\resources";
	public List<File> filtraPorNombre (String directorio1,String nombreCompleto) {
		List<File> filtroNombre = new ArrayList<File>();
		File directorio = new File(rutaDirectorio);
		for (File f:directorio.listFiles()) {
			if (f.getName().contains(nombreCompleto)) {
				filtroNombre.add(f);
			}
		}
		return filtroNombre;
	}
}
