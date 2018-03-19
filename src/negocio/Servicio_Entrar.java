package negocio;

import java.sql.SQLException;

import datos.DAO_Usuario;
import presentacion.Control_Entrar;

public class Servicio_Entrar {
	private static DAO_Usuario daoU;
	private static Control_Entrar controlE;

	public Servicio_Entrar(DAO_Usuario daoc) {
		this.daoU = daoc;
	}

	public static boolean entrar(String usuario, String contrasenia) {
		Usuario u;
		try {
			u = daoU.buscarUsuario(usuario);
			if (u == null) {
				controlE.errorUsuario();
				return false;

			} else {
				if (u.getContrasenia().equals(contrasenia)) {
					return true;

				} else {
					controlE.errorContrasenia();
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}

}