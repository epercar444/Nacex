package step4;

import java.io.File;

import step2segundaprueba.Recurso;
import step3.TraduccionesNoRealizadas;

public class Step4Main {
	final static String rutaDirectorio = "src" + File.separator + "main" + File.separator + "resources";
	public static void main(String[] args) {
		CreaNuevoIdioma n = new CreaNuevoIdioma();
		System.out.println(n.añadirNuevoIdioma("nd", "web2017"));
		System.out.println(n.añadirNuevoIdioma("nd", "nacexShop.properties"));
		TraduccionesNoRealizadas v = new TraduccionesNoRealizadas();
		//System.out.println(v.obtenerTraduccionesFaltantes("web2017", "web2017_nd"));
	}

}
