package presentacion;

import datos.DAO_Usuario;
import negocio.Servicio_Crear;
import negocio.Servicio_Modificar;
import negocio.Usuario;

public class Control_Modificar {
	Servicio_Modificar sm;
	DAO_Usuario daom = new DAO_Usuario();
	Usuario u ;
	

	public Control_Modificar(Servicio_Modificar sm) {
		this.sm=sm;
		this.sm = new Servicio_Modificar(daom);
	}

	public void iniciar(Usuario u) {
		this.u=u;
	Ventana_Modificar vm = new Ventana_Modificar(this);	
	vm.iniciar(u);
	}

	public boolean modificar(Usuario usuario) {
		u=usuario;
		System.out.println("Control-- Usuario: "+usuario.getNombre()+usuario.getApellido()+usuario.getAsesor()+usuario.getContrasenia()+usuario.getNick());
		
		boolean modifica = sm.modificar(usuario);
		System.out.println("Control--- modifica "+modifica);
		
		return modifica;
		
	}

}
