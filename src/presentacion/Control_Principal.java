package presentacion;

import datos.DAO_Crear;
import datos.DAO_Usuario;
import negocio.Servicio_Crear;
import negocio.Servicio_Crear_Usuario;
import negocio.Servicio_Entrar;

public class Control_Principal {
	Servicio_Crear_Usuario sC;
	Servicio_Entrar sE;

	Control_Crear_Usuario cC;
	Control_Entrar cE;

	DAO_Usuario daoc;

	public Control_Principal() {

		sC = new Servicio_Crear_Usuario(daoc);
		sE = new Servicio_Entrar(daoc);
		cC = new Control_Crear_Usuario(sC);
		cE = new Control_Entrar(sE);

	}

	public void inicia_Crear_Usuario() {
		Ventana_Crear_Usuario v =new Ventana_Crear_Usuario (cC);
		v.iniciar();

	}

	public void inicia_Entrar() {

		Ventana_Entrar v =new Ventana_Entrar(cE); 
		v.iniciar();
	}

}
