package negocio;

import java.io.IOException;
import java.sql.SQLException;

import datos.DAO_Usuario;
import presentacion.Control_Modificar;

public class Servicio_Modificar {
	DAO_Usuario daom;
	Control_Modificar cm;
	Usuario u;
	
	public Servicio_Modificar(DAO_Usuario daom){
		this.daom =daom;
	}

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
