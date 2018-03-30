package negocio;

import java.io.File;
import java.io.IOException;

import datos.DAO_Crear;
import presentacion.Control_Crear;
import presentacion.Primera_Ventana;

public class Servicio_Crear {
	DAO_Crear daoc;

	public Servicio_Crear(DAO_Crear daoc2) {
		this.daoc = daoc2;
	}

	public void Crear(String[] datos, Usuario usuario) throws IOException {
		File name =daoc.crear(datos, usuario.getNombre());
		if(name!=null) {
			//Control_Crear cc= new Control_Crear(this);
			//cc.mostarNueva(name);
			Primera_Ventana pv = new Primera_Ventana(usuario);
		}
	}
}
