package step2segundaprueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LeerRecurso {
	/**
	 * FiltraRecursos: mediante una ruta de directorio fija y un nombre de fichero podremos filtrar los recursos que encontremos solo del nombre de fichero que le pasamos
	 */
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	public Properties leerRecurso(String nombreFichero) {
	    Properties prop = new Properties();
	    File directorio = new File(rutaDirectorio);
	        for (File f : directorio.listFiles()) {
	            if (f.getName().equals(nombreFichero)) {
	                try (FileInputStream fis = new FileInputStream(f)) {
	                    prop.load(fis);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		    return prop;
	    }
}
