package negocio;

import java.sql.SQLException;

import datos.DAO_Usuario;

public class Servicio_Crear_Usuario {
	DAO_Usuario daou;

	public Servicio_Crear_Usuario(DAO_Usuario daou2) {
		daou = daou2;
	}
public boolean valida(String nombre2, String nick2, String contrasenia2) throws SQLException {
		
		Usuario[] usu = daou.Retrieve();
		String nom;
		String nick;
		String cont;

		for (int i = 0; i < usu.length; i++) {
			
			nom = usu[i].getNombre();
			nick = usu[i].getNick();
			cont =usu[i].getContrasenia();
			if (nom.contains(nombre2) && nick.contains(nick2) && cont.contains(contrasenia2)) {
				return false;
			}
		}
		
		return true;
	}

	public boolean agregarUsuario(String nombre, String apellido, int asesor, String contrasenia, String nick) throws SQLException {
		if(valida(nombre,nick,contrasenia) == true) {
				Usuario u= new Usuario(nombre, apellido, asesor,contrasenia, nick);
				if(daou.crear(u) == true) {
				return true;
			}else {
				return false;
			}
		}
		return false;	
	}

}
