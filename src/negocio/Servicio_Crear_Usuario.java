package negocio;
/**
 * @author anthony
 * La clase Servicio_Crear_Usuario se encarga de pasar los datos al DAO_Usuario
 * y que este los maneje, este servicio maneja los objetos de tipo Usuario para
 * pasar los datos
 * 
 */

import java.sql.SQLException;

import javax.swing.JOptionPane;

import datos.DAO_Usuario;

public class Servicio_Crear_Usuario {
	DAO_Usuario daou;

	/**
	 * Constructor del Servicio
	 * @param daou2
	 */
	public Servicio_Crear_Usuario(DAO_Usuario daou2) {
		daou = daou2;
	}
	
	
	
	/**
	 * ESte metodo revisa si el usuario ya esxiste e la base de datos,
	 * Dependiendo el resultado devuelve una respuesta en forma de booleano 
	 * 
	 * @param nombre2
	 * @param nick2
	 * @param contrasenia2
	 * @return
	 * @throws SQLException
	 */
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

/**
 * Metodo booleano para insertar usuarios en la base de datos
 * , prImero valida si ya existe y  si no es asi, entonces si les pasa los datos al DAO
 * 
 * @param nombre
 * @param apellido
 * @param asesor
 * @param contraseña
 * @param nick
 * @return
 * @throws SQLException
 */

	public boolean agregarUsuario(String nombre, String apellido, int asesor, String contraseña, String nick) throws SQLException {
		if (valida(nombre, nick, contraseña) == true) {
			Usuario u = new Usuario(nombre, apellido, asesor, contraseña, nick);
			if (daou.crear(u) == true) {
				return true;
			} else {
				return false;
			}
		}else {
			JOptionPane.showMessageDialog(null, "El usuario ya existe");
			return true;
		}	
	}

}
