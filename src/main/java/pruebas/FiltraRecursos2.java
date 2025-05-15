package pruebas;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import step1.*;
import pruebas.*;

public class FiltraRecursos2 {
	private static final String expRegular = ".*_[a-zA-Z]{2}.properties";
	private static final String ruta2 = "nacexShop";
	private static final String ruta1 = "web2017";
	private static final String extension = ".properties";
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	public static void main(String[] args) {
	FiltraRecursos2 c = new FiltraRecursos2();
	//System.out.println(c.filtraFicheroIdiomaconNombre(rutaDirectorio, ruta1));
	System.out.println(c.filtraIdiomaporNombre(rutaDirectorio, ruta1));
	//System.out.println(c.filtraFicheroIdiomaconNombre(rutaDirectorio, ruta2));
	System.out.println(c.filtraIdiomaporNombre(rutaDirectorio, ruta2 ));
	System.out.println(c.filtraFicheroIdiomaconNombre(rutaDirectorio, ruta1));
	//System.out.println(c.filtraNombreFichero("web2017.properties"));
	//System.out.println(c.filtraPorNombre(rutaDirectorio, ruta1));
	}
	public List<File> filtraFicheroIdiomaconNombre(String directorio1, String nombreFichero) {
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
	public List<String> filtraIdiomaporNombre(String directorio1,String nombreFichero) {
		FiltraFicheroIdiomas f = new FiltraFicheroIdiomas();
		List<String> listaIdioma = new ArrayList<String>();
		List<File> idiomas = filtraFicheroIdiomaconNombre(directorio1,nombreFichero);
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
	public String filtraNombreFichero(String nombreCompleto) {
		String nombreSinProperties = "";
		String nombreFichero = "";
		List<File> ficheros = new ArrayList<File>();
		File directorio = new File(rutaDirectorio);
		for (File f : directorio.listFiles()) {
			if (!f.getName().matches(expRegular)) {
				nombreFichero = f.getName();
				int index = nombreFichero.indexOf(extension);
				nombreSinProperties = nombreFichero.substring(0, index);
			}
		}
		return nombreSinProperties;
	}

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


