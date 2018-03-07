package negocio;

import java.io.IOException;

import datos.DAO_Crear;

public class Servicio_Crear {
	DAO_Crear daoc;

	public Servicio_Crear(DAO_Crear daoc2) {
		this.daoc = daoc2;
	}

	public void Crear(String[] datos) throws IOException {
		daoc.crear(datos);
	}

}
