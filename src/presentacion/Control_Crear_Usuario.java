package presentacion;

/*
 * @author Anthony Perez Rangel
 * La clase Control_Crear_Usuario se usa para Abrir la Ventana_Crear_Usuario
 * y para agregar pasar los datos que ingreso el usuario en la ventana 
 * al Servicio_Crear_Usuario .
 * 
 */

import java.sql.SQLException;

import datos.DAO_Usuario;
import negocio.Servicio_Crear_Usuario;

public class Control_Crear_Usuario {
	Servicio_Crear_Usuario sc;
	DAO_Usuario daou = new DAO_Usuario();
	
	
	/**
	 * Constructor de la clase Control_Crear_Usuario
	 * @param sc2
	 */
	public Control_Crear_Usuario(Servicio_Crear_Usuario sc2) {
		sc = sc2;
		sc = new Servicio_Crear_Usuario(daou);
	}
	
	
	
	/**
	 * Este metodo recibe los datos que ingresa el usuario y llena un objeto de la clase
	 * Servicio_Crear_Usuario en su metodo agregaUsuario, deuelve un valor booleano
	 * que representa si se pudo o no agregar el usuario(note que aveces va a devolver true
	 * aunque no se halla agregado el usuario porque este puede ya existir en la base)
	 * 
	 * @param nombre
	 * @param apellido
	 * @param asesor
	 * @param contrasenia
	 * @param nick
	 * @return
	 * @throws SQLException
	 */
	public boolean agregarUsuario(String nombre, String apellido, int asesor, String contrasenia, String nick) throws SQLException {
		if(sc.agregarUsuario(nombre, apellido, asesor, contrasenia, nick)) {
			return true;
		}else {
		return false;
		}
	}

	/**
	 * Crea un nuevo objeto de la clase Ventana_Crear_Usuario 
	 * y la inicia
	 */
	public void iniciar() {
		Ventana_Crear_Usuario vc= new Ventana_Crear_Usuario(this);
		vc.iniciar();
		
	}
	
	

}
