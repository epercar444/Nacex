package step2segundaprueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import step1.FiltraFicheroIdiomas;
import step1.FiltraFicheroOrigen;
import step2.FiltraFicheroIdiomasporNombre;

public class step2seguundaparteMain {
		private static final String extension = ".properties";
		private static final String expRegular = ".*_[a-zA-Z]{2}.properties";
		final static String rutaDirectorio = "src"+File.separator+"main"+File.separator+"resources";
		public static void main(String[] args) throws FileNotFoundException {
			File directorio = new File(rutaDirectorio);
			FiltraFicheroOrigen m = new FiltraFicheroOrigen();
			List<File> ficherosOrigen = m.filtraFicheroOrigen();
			for (File f : ficherosOrigen) {
				Recurso g = new Recurso(f.getName());
				//System.out.println(g.toString());
				//System.out.println(g.propiedades);
	}
			

		}
}
