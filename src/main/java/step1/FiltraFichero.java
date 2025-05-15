package step1;

import java.io.File;
import java.util.List;

import step1.*;

public class FiltraFichero {
	private static final String extension = ".properties";
	private static final String expRegular = ".*_[a-zA-Z]{2}.properties";
	final static String rutaDirectorio = "C:\\Users\\epercar444\\Desktop\\eclipse-workspace\\NacexE\\src\\main\\resources";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiltraFicheroOrigen o = new FiltraFicheroOrigen();
		FiltraIdioma i = new FiltraIdioma();
		List<File> ficherosOrigen = o.filtraFicheroOrigen();
		System.out.println(ficherosOrigen);
		for (File f : ficherosOrigen) {
			int index = f.getName().indexOf(extension);
			String nombre = f.getName().substring(0,index);
			List<String> idiomas = i.FiltraIdioma(nombre);
			System.out.println(idiomas);
	}

} }
