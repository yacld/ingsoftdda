package principal;
import java.io.File;
//prueba de branch
import java.io.IOException;

import negocio.Servicio_Crear;
import negocio.Servicio_Modificar;
import negocio.Servicio_Paso;
import negocio.Usuario;
import presentacion.Control_Crear;
import presentacion.Control_Modificar;
import presentacion.Control_Paso;
//import presentacion.Primera_Ventana;
import presentacion.Ventana_Principal;

public class Principal {
	Servicio_Paso sp;
	Servicio_Crear sc;
	Servicio_Modificar sm;
	Ventana_Principal ventana;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Principal p = new Principal();
		p.inicia();
	}
	
	public void inicia() {
		ventana = new Ventana_Principal();
		ventana.setVisible(true);
	}
	
	
	public void paso(File file) throws IOException {
		Control_Paso cp = new Control_Paso(this.sp);
		cp.iniciar(file);
	}
	
	public void Crear(Usuario usuario) {
		Control_Crear cc = new Control_Crear(this.sc);
		cc.iniciar(usuario);
	}

	public void ModificarCuenta(Usuario u) {
		Control_Modificar cc = new Control_Modificar(this.sm);
		cc.iniciar(u);

		
	}

}
