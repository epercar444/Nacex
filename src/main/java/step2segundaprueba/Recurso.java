package step2segundaprueba;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import step2.FiltraNombreFichero;
import step2.FiltraIdiomaporNombre;

public class Recurso {
	private static final String extension = ".properties";
	private static final String expRegular = ".*_[a-zA-Z]{2}\\.properties";
	final static String rutaDirectorio = "src" + File.separator + "main" + File.separator + "resources";

	public static void main(String[] args) {
		File directorio = new File(rutaDirectorio);
		for (File f : directorio.listFiles()) {
			Recurso g = new Recurso(rutaDirectorio, f.getName());
			System.out.println(g.toString());
			System.out.println(g.propiedades);
		}
	}

	private String nombreRecurso;
	private String idioma;
	private List<Recurso> idiomas;
	private Properties propiedades;

	public Recurso(String rutaCarpeta, String nombreFicheroCompleto) {
		super();
		FiltraNombreFicheroDos r = new FiltraNombreFicheroDos();
		this.nombreRecurso = r.filtraNombreFichero(nombreFicheroCompleto);
		FiltraPorIdiomaDos f = new FiltraPorIdiomaDos();
		this.idioma = f.filtraPorIdiomaDos(nombreFicheroCompleto);
		if (!nombreFicheroCompleto.matches(expRegular)) {
			FiltraPorIdiomasDos v = new FiltraPorIdiomasDos();
			this.idiomas = v.idiomasDos(nombreFicheroCompleto);
		} else {
			this.idiomas = null;
		}
		LeerRecurso u = new LeerRecurso();
		this.propiedades = u.leerRecurso(nombreFicheroCompleto);
	}
	
	public List<String> obtenerTraduccionesRealizadas(String nombreFicheroOrigen, String nombreFicheroIdioma) {
	    LeerRecurso p = new LeerRecurso();
	    Properties propiedadesOrigen = p.leerRecurso(nombreFicheroOrigen);
	    Properties propiedadesIdioma = p.leerRecurso(nombreFicheroIdioma);

	    List<String> estan = new ArrayList<String>();

	    for (String clave : propiedadesOrigen.stringPropertyNames()) {
	        if (propiedadesIdioma.containsKey(clave)) {
	            estan.add(clave);
	        }
	    }

	    return estan;
	}

	@Override
	public String toString() {
		return "Recurso [nombreRecurso=" + nombreRecurso + ", idioma=" + idioma + ", idiomas=" + idiomas + "]";
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public List<Recurso> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Recurso> idiomas) {
		this.idiomas = idiomas;
	}

	public Properties getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}
}
