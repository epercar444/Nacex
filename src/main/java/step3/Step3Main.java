package step3;

public class Step3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TraduccionesNoRealizadas m = new TraduccionesNoRealizadas();
		System.out.println(m.obtenerTraduccionesFaltantes("web2017", "web2017_ca"));
		TraduccionesRealizadas f = new TraduccionesRealizadas();
		System.out.println(f.obtenerTraduccionesRealizadas("web2017.properties", "web2017_ev.properties"));
	}

}
