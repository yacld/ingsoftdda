package presentacion;

import java.sql.SQLException;

import datos.DAO_Usuario;
import negocio.Servicio_Crear_Usuario;

public class Control_Crear_Usuario {
	Servicio_Crear_Usuario sc;
	DAO_Usuario daou = new DAO_Usuario();
	
	public Control_Crear_Usuario(Servicio_Crear_Usuario sc2) {
		sc = sc2;
		sc = new Servicio_Crear_Usuario(daou);
	}
	
	public boolean agregarUsuario(String nombre, String apellido, int asesor, String contrasenia, String nick) throws SQLException {
		if(sc.agregarUsuario(nombre, apellido, asesor, contrasenia, nick)) {
			return true;
		}else {
		return false;
		}
	}

	public void iniciar() {
		Ventana_Crear_Usuario vc= new Ventana_Crear_Usuario(this);
		vc.iniciar();
		
	}
	
	

}
