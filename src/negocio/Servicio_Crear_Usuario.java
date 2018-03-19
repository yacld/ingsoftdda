package negocio;

import java.sql.SQLException;

import datos.DAO_Usuario;

public class Servicio_Crear_Usuario {
	DAO_Usuario daou;

	public Servicio_Crear_Usuario(DAO_Usuario daou2) {
		daou = daou2;
	}
public boolean valida(String nombre2, String nick2, String contrase�a2) throws SQLException {
		
		Usuario[] usu = daou.Retrieve();
		String nom;
		String nick;
		String cont;

		for (int i = 0; i < usu.length; i++) {
			
			nom = usu[i].getNombre();
			nick = usu[i].getNick();
			cont =usu[i].getContrase�a();
			if (nom.contains(nombre2) && nick.contains(nick2) && cont.contains(contrase�a2)) {
				return false;
			}
		}
		
		return true;
	}

	public boolean agregarUsuario(String nombre, String apellido, int asesor, String contrase�a, String nick) throws SQLException {
		if(valida(nombre,nick,contrase�a) == true) {
				Usuario u= new Usuario(nombre, apellido, asesor,contrase�a, nick);
				if(daou.crear(u) == true) {
				return true;
			}else {
				return false;
			}
		}
		return false;	
	}

}
