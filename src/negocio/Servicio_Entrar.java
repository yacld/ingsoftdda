package negocio;


import java.sql.SQLException;

import datos.DAO_Usuario;

public class Servicio_Entrar {
	private static DAO_Usuario daoU;
	public Servicio_Entrar(DAO_Usuario daoc) {
		Servicio_Entrar.daoU = daoc;
	}

	public static boolean entrar(String usuario, String contrasenia) {
		Usuario u;
		try {
			u = daoU.buscarUsuario(usuario);
			if (u == null) {
				return false;

			} else {
				if (u.getContrasenia().equals(contrasenia)) {
					return true;

				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}
public boolean valida(String usuario2, String contrasenia2) throws SQLException {
		
		Usuario[] usu = daoU.Retrieve();
		String usuario;
		String cont;

		for (int i = 0; i < usu.length; i++) {
			
			usuario = usu[i].getNick();
			cont =usu[i].getContrasenia();
			if (usuario.contains(usuario2) && cont.contains(contrasenia2)) {
				System.out.println("El usuario existe");
				return false;
			}
		}
		System.out.println("El usuario no existe");
		return true;
	}

	public boolean mostrar(String usuario, String contra) throws SQLException {
		if(valida(usuario,contra)== true) {
			System.out.println("Fue false");
			return false;
		}
		System.out.println("Fue true");
		return true;
	}

}