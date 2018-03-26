package negocio;

import datos.DAO_Diagrama;

public class Servicio_Diagrama {

	DAO_Diagrama daod;
	
	public Servicio_Diagrama(DAO_Diagrama daod2) {
		// TODO Auto-generated constructor stub
		daod = daod2;
	}

	public void generar() {
		// TODO Auto-generated method stub
		daod.generaDiagrama();
	}

}
