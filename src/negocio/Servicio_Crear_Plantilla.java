package negocio;

import java.io.File;
import java.io.IOException;

import datos.DAO_Crear_Plantilla;
import presentacion.Control_Crear_Plantilla;

public class Servicio_Crear_Plantilla {
	DAO_Crear_Plantilla daoc;

	public Servicio_Crear_Plantilla(DAO_Crear_Plantilla daoc2) {
		this.daoc = daoc2;
	}

	public void Crear(String[] datos) throws IOException {
		File name =daoc.crear(datos);
		if(name!=null) {
			Control_Crear_Plantilla cc= new Control_Crear_Plantilla(this);
			cc.mostarNueva(name);
			
		}
	}
}
