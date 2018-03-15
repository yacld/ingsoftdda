package presentacion;

import java.io.File;
import java.io.IOException;

import datos.DAO_Crear_Plantilla;
import negocio.Servicio_Crear_Plantilla;

public class Control_Crear_Plantilla {
	Servicio_Crear_Plantilla sc;
	Control_Paso cp;
	DAO_Crear_Plantilla daoc = new DAO_Crear_Plantilla();

	public Control_Crear_Plantilla(Servicio_Crear_Plantilla sc2) {
			
		this.sc = sc2;
		sc = new Servicio_Crear_Plantilla(daoc);
		
	}

	public void iniciar() {
		Ventana_Crear_Plantilla vc= new Ventana_Crear_Plantilla(this);
		vc.iniciar();
		
	}

	public void crear(String[] datos) throws IOException {
		sc.Crear(datos);
	}

	public void mostarNueva(File name) {
		
		Ventana_Crear_Plantilla vc = new Ventana_Crear_Plantilla(this);	
		vc.mostrarNueva(name);
	}

}
