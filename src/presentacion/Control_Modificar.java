package presentacion;

import datos.DAO_Usuario;
import negocio.Servicio_Modificar;
import negocio.Usuario;

/*Cuenta con la logica de comunicacion entre ventana y servicio
 *  en este caso solo se manda a llamar metodos y se da un resultado a 
 * la clase ventana
 * 
 * */
public class Control_Modificar {
	Servicio_Modificar sm;
	DAO_Usuario daom = new DAO_Usuario();
	Usuario u;
	/*Constructor inicializa clase servicio
	 * 
	 * */

	public Control_Modificar(Servicio_Modificar sm) {
		this.sm=sm;
		this.sm = new Servicio_Modificar(daom);
	}
	// muestra ventana para comenzasr caso de uso 
	public void iniciar(Usuario u) {
		this.u=u;
	Ventana_Modificar vm = new Ventana_Modificar(this);	
	vm.iniciar(u);
	}
	// Manda a llamar el metodo de la clase servicio para comenzar la actualizacion
	public boolean modificar(Usuario usuario) {
		u=usuario;
		System.out.println("Control-- Usuario: "+usuario.getNombre()+usuario.getApellido()+usuario.getAsesor()+usuario.getContrasenia()+usuario.getNick());
		
		boolean modifica = sm.modificar(usuario);
		System.out.println("Control--- modifica "+modifica);
		
		return modifica;
		
	}

}
