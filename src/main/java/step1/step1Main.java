package step1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class step1Main {
	private static final String extension = ".properties";
	private static final String nombreFchero = "web2017";
	private static final String expRegular = ".*_[a-zA-Z]{2}.properties";
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";

	public static void main(String[] args) {
		step1Main r = new step1Main();
		List<File> ficherosOrigen = r.filtraFicheroOrigen();
		System.out.println(ficherosOrigen);
		for (File f : ficherosOrigen) {
			int index = f.getName().indexOf(extension);
			String nombre = f.getName().substring(0,index);
			List<String> idiomas = r.FiltraIdioma(nombre);
			System.out.println(idiomas);
		}
	}

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

	/** 
	 * filtraFicheroIdiomas: busca los diferentes nombres en los que encontramos el fichero que le pasamos por parámetro.
	 * @param directorio1 será la ruta base por la que queremos filtrar
	 * @return lista de ficheros que contienen la extensión de dichos idiomas, es decir, directorio1_idioma
	 */
	public List<File> filtraFicheroIdiomas(String directorio1) {
		List<File> idiomas = new ArrayList<File>();
		File directorio = new File(rutaDirectorio);
		for (File f : directorio.listFiles()) {
			if (f.getName().matches(directorio1 + expRegular)  ) {
				idiomas.add(f);
			}
		}
		return idiomas;
	}

	/**
	 * FiltraIdioma: filtra los diferentes idiomas en los que encontramos los ficheros defaults.
	 * @author epercar444
	 * @param directorio1 será la ruta base.
	 * @return una lista de cadenas donde habremos guardado las iniciales de los idiomas traducidos.
	 */
	public List<String> FiltraIdioma(String directorio1) {
		List<String> listaIdioma = new ArrayList<String>();
		List<File> idiomas = filtraFicheroIdiomas(directorio1);
		for (File f : idiomas) {
			String nombreFichero = f.getName();
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