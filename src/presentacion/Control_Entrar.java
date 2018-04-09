package presentacion;

import java.sql.SQLException;

import datos.DAO_Crear;
import datos.DAO_Usuario;
import negocio.Servicio_Crear;
import negocio.Servicio_Entrar;
import negocio.Usuario;

public class Control_Entrar {

	Servicio_Entrar se;
	Control_Crear cc;

	DAO_Usuario daou = new DAO_Usuario();
	int tipoErr;

	public Control_Entrar(Servicio_Entrar se2) {
		this.se = se2;
		se = new Servicio_Entrar(daou);

	}

	public void errorContrasenia() {
		tipoErr = 1;
	}

	public void errorUsuario() {
		tipoErr = 2;
	}

	public boolean inicia(String usuario, String contrasenia) {
		boolean respuesta = false;
		if(Servicio_Entrar.entrar(usuario, contrasenia) == true) {
			return true;
		}
		return false;

	}

	public void abrir(String u) throws SQLException {
		cc = new Control_Crear(new Servicio_Crear(new DAO_Crear()));
		cc.mostrarPrincipal(cc, u);
	}

	public boolean mostrar(String usuario, String contra) throws SQLException {
		if (se.mostrar(usuario, contra)) {
			//System.out.println("Fue true");
			return true;
		}
		//System.out.println("Fue false");
			return false;

	}

}
