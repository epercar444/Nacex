package step2segundaprueba;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import step1.FiltraFicheroOrigen;
import step2.FiltraNombreFichero;
import step2.FiltraIdiomaporNombre;

public class Recurso {
	private static final String extension = ".properties";
 	private static final String expRegular = ".*_[a-zA-Z]{2}\\.properties";
	final static String rutaDirectorio = "src" + File.separator + "main" + File.separator + "resources";

	public static void main(String[] args) {
		File directorio = new File(rutaDirectorio);
		for (File f : directorio.listFiles()) {
			Recurso g = new Recurso(f.getName());
			System.out.println(g.toString());
			System.out.println(g.propiedades);
		}
	}

	private String nombreRecurso;
	private String idioma;
	private List<Recurso> idiomas;
	private Properties propiedades;

	public Recurso(String nombreFicheroCompleto) {
		super();
		FiltraNombreFicheroDos r = new FiltraNombreFicheroDos();
		this.nombreRecurso = r.filtraNombreFichero(nombreFicheroCompleto);
		FiltraPorIdiomaDos f = new FiltraPorIdiomaDos();
		this.idioma = f.filtraPorIdiomaDos(nombreFicheroCompleto);
		this.idiomas = FiltraIdiomas (nombreFicheroCompleto);
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
	public List<Recurso> FiltraIdiomas (String nombreFicheroCompleto) {
		if (!nombreFicheroCompleto.matches(expRegular)) {
			FiltraPorIdiomasDos v = new FiltraPorIdiomasDos();
			this.idiomas = v.idiomasDos(nombreFicheroCompleto);
		} else {
			this.idiomas = null;
		}
		return this.idiomas; 
	}
    public String añadirNuevoIdioma(String idiomaNuevo, String nombreFicheroOrigen) {
        Recurso recursoOrigen = new Recurso(nombreFicheroOrigen);
        FiltraFicheroOrigen w = new FiltraFicheroOrigen();
        List<File> ficherosOrigen = w.filtraFicheroOrigen();
        for (File g : ficherosOrigen) {
            if (g.getName().equals(nombreFicheroOrigen)) {
                FiltraNombreFicheroDos r = new FiltraNombreFicheroDos();
                String nombreRecurso = r.filtraNombreFichero(nombreFicheroOrigen);
                String nombreNuevo = nombreRecurso + "_" + idiomaNuevo + extension;
                Recurso nuevoIdioma = new Recurso(nombreNuevo);
                List<Recurso> idiomas = recursoOrigen.getIdiomas();
                if (idiomas == null) {
                    idiomas = new ArrayList<>();
                    recursoOrigen.setIdiomas(idiomas);
                }
                idiomas.add(nuevoIdioma);
                }
        }
		return recursoOrigen.toString();
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
