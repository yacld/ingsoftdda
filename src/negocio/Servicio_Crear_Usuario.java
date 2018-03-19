package negocio;

import java.sql.SQLException;

import datos.DAO_Usuario;

public class Servicio_Crear_Usuario {
	DAO_Usuario daou;

	public Servicio_Crear_Usuario(DAO_Usuario daou2) {
		daou = daou2;
	}
public boolean valida(String nombre2, String nick2, String contraseña2) throws SQLException {
		
		Usuario[] usu = daou.Retrieve();
		String nom;
		String nick;
		String cont;

		for (int i = 0; i < usu.length; i++) {
			
			nom = usu[i].getNombre();
			nick = usu[i].getNick();
			cont =usu[i].getContraseña();
			if (nom.contains(nombre2) && nick.contains(nick2) && cont.contains(contraseña2)) {
				return false;
			}
		}
		
		return true;
	}

	public boolean agregarUsuario(String nombre, String apellido, int asesor, String contraseña, String nick) throws SQLException {
		if (valida(nombre, nick, contraseña) == true) {
			Usuario u = new Usuario(nombre, apellido, asesor, contraseña, nick);
			if (daou.crear(u) == true) {
				return true;
			} else {
				return false;
			}
		}else {
			//JOptionPane.showMessageDialog(null, "El usuario ya existe");
			return true;
		}	
	}

}
