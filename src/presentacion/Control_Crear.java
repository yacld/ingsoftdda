package presentacion;

import java.io.IOException;

import datos.DAO_Crear;
import negocio.Servicio_Crear;

public class Control_Crear {
	Servicio_Crear sc;
	Control_Paso cp;
	DAO_Crear daoc = new DAO_Crear();

	public Control_Crear(Servicio_Crear sc2) {
		this.sc = sc2;
		sc = new Servicio_Crear(daoc);
		
	}

	public void iniciar() {
		Ventana_Crear vc= new Ventana_Crear(this);
		vc.iniciar();
		
	}

	public void crear(String[] datos) throws IOException {
		sc.Crear(datos);
	}

}
