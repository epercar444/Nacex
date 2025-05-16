package step3;

import step2segundaprueba.LeerRecurso;

public class Step3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TraduccionesNoRealizadas m = new TraduccionesNoRealizadas();
		//System.out.println(m.obtenerTraduccionesFaltantes("web2017", "web2017_ca"));
		TraduccionesRealizadas f = new TraduccionesRealizadas();
		//System.out.println(f.obtenerTraduccionesRealizadas("web2017.properties", "web2017_ev.properties"));
		GetTraducciones b = new GetTraducciones();
		System.out.println(b.getTraducciones("web2017_ca", "contacto.correo.electronico"));
		//System.out.println(b.getTraducciones("web2017_ca", "hola"));
		PutTraduccion h = new PutTraduccion();
		h.putTraduccion("web2017_ca.properties", "contacto.correo.electronico", "hola");
		System.out.println(b.getTraducciones("web2017_ca", "contacto.correo.electronico"));
		LeerRecurso t = new LeerRecurso();
		// System.out.println(t.leerRecurso("web2017_ca.properties"));
	}

}
//Correu electrònic