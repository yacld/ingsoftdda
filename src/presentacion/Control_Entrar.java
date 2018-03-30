package presentacion;

import datos.DAO_Usuario;
import negocio.Servicio_Entrar;
import negocio.Usuario;

public class Control_Entrar {
	Servicio_Entrar sE;
	Usuario u;

	DAO_Usuario daou = new DAO_Usuario();
	int tipoErr;

	public Control_Entrar(Servicio_Entrar sE2) {
		this.sE=sE2;
		sE = new Servicio_Entrar(daou);
	

}

	public void errorContrasenia() {
tipoErr=1;		
	}

	public void errorUsuario() {
		tipoErr=2;
	}

	public Usuario inicia(String usuario, String contrasenia) {
		System.out.println("Estoy en control entrar");
		 u = Servicio_Entrar.entrar(usuario, contrasenia);
		return u;
		
	}

}
