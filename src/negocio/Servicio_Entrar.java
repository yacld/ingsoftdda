package negocio;


import java.sql.SQLException;

import datos.DAO_Usuario;

public class Servicio_Entrar {
	private static DAO_Usuario daoU;

	public Servicio_Entrar(DAO_Usuario daoc) {
		Servicio_Entrar.daoU = daoc;
	}

	public static Usuario entrar(String usuario, String contrasenia) {
		System.out.println("Estoy en Servicio entrar");
		Usuario u;
		try {
			u = daoU.recuperaUsuario(usuario);
			if (u == null) {
				return false;


			} else {
				if (u.getContrasenia().equals(contrasenia)) {
					return u;

				} else {
					return false;

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

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