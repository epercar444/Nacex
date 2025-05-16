package step3;

import java.io.FileOutputStream;
import java.util.Properties;
import step2segundaprueba.LeerRecurso;

public class PutTraduccion {

    public void putTraduccion(String nombreFichero, String clave, String valor) {
        LeerRecurso f = new LeerRecurso();
        Properties props = f.leerRecurso(nombreFichero);

        props.setProperty(clave, valor); // Añade o modifica

        try {
            FileOutputStream l = new FileOutputStream(nombreFichero);
            props.store(l, "Hola");
            l.close();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}
