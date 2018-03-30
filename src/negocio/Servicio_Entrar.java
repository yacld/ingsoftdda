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

	public static Usuario entrar(String usuario, String contrasenia) {
		System.out.println("Estoy en Servicio entrar");
		Usuario u;
		try {
			u = daoU.recuperaUsuario(usuario);
			if (u == null) {
				controlE.errorUsuario();
				return u;

			} else {
				if (u.getContrasenia().equals(contrasenia)) {
					return null;

				} else {
					controlE.errorContrasenia();
					return null;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}