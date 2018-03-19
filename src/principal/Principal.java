package principal;
import java.io.File;
//prueba de branch
import java.io.IOException;

import negocio.Servicio_Crear;
import negocio.Servicio_Paso;
import presentacion.Control_Crear;
import presentacion.Control_Paso;
import presentacion.Primera_Ventana;
import presentacion.Ventana_Principal;

public class Principal {
	Servicio_Paso sp;
	Servicio_Crear sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Principal p = new Principal();
		p.inicia();
	}
	
	public void inicia() {
		Ventana_Principal ventana = new Ventana_Principal();
		ventana.setVisible(true);
	}
	
	
	public void paso(File file) throws IOException {
		Control_Paso cp = new Control_Paso(this.sp);
		cp.iniciar(file);
	}
	
	public void Crear() {
		Control_Crear cc = new Control_Crear(this.sc);
		cc.iniciar();
	}

}
