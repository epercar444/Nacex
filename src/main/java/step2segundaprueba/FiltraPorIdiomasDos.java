package step2segundaprueba;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import step1.FiltraFicheroIdiomas;
import step1.FiltraFicheroOrigen;
import step2.FiltraFicheroIdiomasporNombre;
import step2.FiltraNombreFichero;

public class FiltraPorIdiomasDos {
	/**
	 * filtraIdiomaporNombre: recoge la lista de ficheros del método filtraFicheroIdiomaconNombre y saca los locale de los idiomas en los que podemos encontrar dicho fichero.
	 * Si los ficheros son de por si los de idioma, devolverá null. En cambio, si el fichero es uno de los por defecto, devolverá la lista de idiomas en los que lo podemos encontrar.
	 */
	private static final String extension = ".properties";
	final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
	public List<Recurso> idiomasDos (String nombreFichero) {
		List<Recurso> idiomas = new ArrayList<Recurso>();
		FiltraFicheroIdiomasporNombre t = new FiltraFicheroIdiomasporNombre();
		FiltraFicheroOrigen c = new  FiltraFicheroOrigen();
		FiltraNombreFichero k = new FiltraNombreFichero();
		List<File> ficherosOrigen = c.filtraFicheroOrigen();
		for (File j : ficherosOrigen) {
			String nombreBueno = k.filtraNombreFichero(j.getName());
			List<File> idiomasPorNombre = t.FiltraFicheroIdiomaconNombre(rutaDirectorio, nombreBueno);
			for (File g : idiomasPorNombre) {
				Recurso u = new Recurso(g.getName());
				if (j.getName().contains(nombreFichero)) {
					idiomas.add(u);
				}
			}
		}
		return idiomas;
}
}
