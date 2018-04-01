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
			e.printStackTrace();
		}

		return true;

	}
public boolean valida(String nombre2, String contrasenia2) throws SQLException {
		
		Usuario[] usu = daoU.Retrieve();
		String nom;
		String cont;

		for (int i = 0; i < usu.length; i++) {
			
			nom = usu[i].getNombre();
			cont =usu[i].getContrasenia();
			if (nom.contains(nombre2) && cont.contains(contrasenia2)) {
				System.out.println("El usuario existe");
				return false;
			}
		}
		System.out.println("El usuario no existe");
		return true;
	}

	public boolean mostrar(String nombre, String contra) throws SQLException {
		if(valida(nombre,contra)== true) {
			System.out.println("Fue false");
			return false;
		}
		System.out.println("Fue true");
		return true;
	}

}