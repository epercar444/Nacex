package step2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FiltraRecursos {
	/**
	 * FiltraRecursos: mediante una ruta de directorio fija y un nombre de fichero podremos filtrar los recursos que encontremos tanto del nombre que le pasamos
	 * como la de todos los ficheros de idiomas que compartan el nombre del fichero origen
	 */
	final static String rutaDirectorio ="src"+File.separator+"main"+File.separator+"resources";
	public List<Properties> filtraRecursos(String nombreFichero) {
	    List<Properties> recursos = new ArrayList<>();
	    FiltraporNombre c = new FiltraporNombre();
	    List<File> filtroNombre = c.filtraPorNombre(rutaDirectorio, nombreFichero); 
 	    for (File f : filtroNombre) {
	        Properties prop = new Properties();
	        try (FileInputStream fis = new FileInputStream(f)) {
	            prop.load(fis);
	            recursos.add(prop);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return recursos;
	}
}
