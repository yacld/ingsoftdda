package principal;
//prueba de branch
import java.io.IOException;

import negocio.Servicio_Crear_Plantilla;
import negocio.Servicio_Paso;
import presentacion.Control_Crear_Plantilla;
import presentacion.Control_Paso;
import presentacion.Primera_Ventana;

public class Principal {
	Servicio_Paso sp;
	Servicio_Crear_Plantilla sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Principal p = new Principal();
		p.inicia();
	}
	
	public void inicia() {
		Primera_Ventana ventana = new Primera_Ventana();
		ventana.iniciar();
	}
	
	
	public void paso() throws IOException {
		Control_Paso cp = new Control_Paso(this.sp);
		cp.iniciar();
	}
	
	public void Crear() {
		Control_Crear_Plantilla cc = new Control_Crear_Plantilla(this.sc);
		cc.iniciar();
	}

}
