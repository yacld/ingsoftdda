package negocio;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import datos.DAO_Crear;
import datos.DAO_Plantillas;
import presentacion.Control_Crear;
import presentacion.Primera_Ventana;

public class Servicio_Crear {
	DAO_Crear daoc;
	DAO_Plantillas daop = new DAO_Plantillas();

	public Servicio_Crear(DAO_Crear daoc2) {
		this.daoc = daoc2;
	}


	public boolean Crear(String[] datos, String usuario) throws IOException {
		File name =daoc.crear(datos, usuario);

		if(name!=null) {
			//Control_Crear cc= new Control_Crear(this);
			//cc.mostarNueva(name);
			return true;
		}
		return false;
	}

	public boolean obtenPlantillas(String nombre, DefaultListModel<File> listModel) throws SQLException {
		if(daop.Obten_Plantillas(nombre, listModel)) {
			return true;
		}
		return false;
	}
}
