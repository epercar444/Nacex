package step2;

import java.io.File;
import java.util.List;

import step1.FiltraFicheroOrigen;

public class step2Main {
	final static String rutaDirectorio ="src"+File.separator+"main"+File.separator+"resources";
	public static void main(String[] args) {
		FiltraFicheroOrigen p = new FiltraFicheroOrigen();
		List<File> ficherosOrigen = p.filtraFicheroOrigen();
		for (File f : ficherosOrigen) {
			Recurso recurso = new Recurso(rutaDirectorio, f.getName());
			System.out.println(recurso.toString());
			//System.out.println(recurso.propiedades);
		}
	}

}
