package negocio;

import java.io.File;
import java.io.IOException;

import datos.DAO_Crear;
import presentacion.Control_Crear;

public class Servicio_Crear {
	DAO_Crear daoc;

	public Servicio_Crear(DAO_Crear daoc2) {
		this.daoc = daoc2;
	}

	public void Crear(String[] datos) throws IOException {
		File name =daoc.crear(datos);
		if(name!=null) {
			Control_Crear cc= new Control_Crear(this);
			cc.mostarNueva(name);
			
		}
	}
}
