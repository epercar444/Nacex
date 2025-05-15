package step2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import step1.FiltraFicheroOrigen;

public class Recurso {
	final static String rutaDirectorio ="src"+File.separator+"main"+File.separator+"resources";
	private String nombreRecurso; 
	private Locale idioma;
	private List<String>idiomas;
	private List<Properties> propiedades;


	public Recurso(String rutaCarpeta, String nombreFicheroCompleto) {
		super();
		FiltraNombreFichero f = new FiltraNombreFichero();
		this.nombreRecurso =  f.filtraNombreFichero(nombreFicheroCompleto);
		this.idioma = Locale.getDefault();
		FiltraIdiomaporNombre n = new FiltraIdiomaporNombre();
		this.idiomas = n.FiltraIdiomaporNombre(rutaDirectorio, nombreRecurso);
		FiltraRecursos m = new FiltraRecursos();
		this.propiedades = m.filtraRecursos(nombreRecurso);
		
	}
	@Override
	public String toString() {
		return "Recurso [nombreRecurso=" + nombreRecurso + ",idioma=" + idioma +", idiomas=" + idiomas;
	}
	public String getNombreRecurso() {
		return nombreRecurso;
	}
	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}
	public Locale getIdioma() {
		return idioma;
	}
	public void setIdioma(Locale idioma) {
		this.idioma = idioma;
	}
	public List<String> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<String> idiomas) {
		this.idiomas = idiomas;
	}
	public List<Properties> getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(List<Properties> propiedades) {
		this.propiedades = propiedades;
	}
	
	
}



