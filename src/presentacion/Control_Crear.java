package presentacion;

import java.io.File;
import java.io.IOException;

import datos.DAO_Crear;
import negocio.Servicio_Crear;
import negocio.Usuario;

public class Control_Crear {
	Servicio_Crear sc;
	Control_Paso cp;
	DAO_Crear daoc = new DAO_Crear();

	public Control_Crear(Servicio_Crear sc2) {
			
		this.sc = sc2;
		sc = new Servicio_Crear(daoc);
		
	}

	public void iniciar(Usuario usuario) {
		Ventana_Crear vc= new Ventana_Crear(this);
		vc.iniciar(usuario);
		
	}

	public void crear(String[] datos, Usuario usuario) throws IOException {
		sc.Crear(datos, usuario);
	}

	public void mostarNueva(File name) {
		
		Ventana_Crear vc = new Ventana_Crear(this);	
		vc.mostrarNueva(name);
	}

}
