package negocio;

import java.sql.SQLException;

import datos.DAO_Usuario;
import presentacion.Control_Modificar;


/*Clase encrgada de la logica de negocio si es que se tiene que verificar algo
 * antes de hacer las modificaciones en la persistencia de datos * 
 * */
public class Servicio_Modificar {
	DAO_Usuario daom;
	Control_Modificar cm;
	Usuario u;
	
	public Servicio_Modificar(DAO_Usuario daom){
		this.daom =daom;
	}
// En este caso solo manda a llamar el metodo del DAO para comenzar la actualizacion de datos
	public boolean modificar(Usuario usuario){
		System.out.println("Servicio-- Usuario: "+usuario.getNombre()+usuario.getApellido()+usuario.getAsesor()+usuario.getContrasenia()+usuario.getNick());
		
		this.u=usuario;
		try {
			return daom.actualizar(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;


		

		
		
	}

}
