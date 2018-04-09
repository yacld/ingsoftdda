package principal;
import java.io.File;
//prueba de branch
import java.io.IOException;

import negocio.Servicio_Crear;
import negocio.Servicio_Paso;
import negocio.Usuario;
import presentacion.Control_Crear;
import presentacion.Control_Paso;
import presentacion.Ventana_Inicio;
//import presentacion.Primera_Ventana;
import presentacion.Ventana_Principal;

public class Principal {
	Servicio_Paso sp;
	Servicio_Crear sc;
	
	
	/**
	 * Clase donde se comienza todo el sistema,
	 * @param args
	 */
	public static void main(String[] args) {

		Principal p = new Principal();
		p.inicia();
	}
	
	/**
	 * Abre la ventana de inicio, esta ventana no recibe ningun control debido 
	 * a que Principal actua como un control general del sistema
	 */
	public void inicia() {
		Ventana_Inicio ventana = new Ventana_Inicio();
		ventana.frame.setVisible(true);
	}
	
	/**
	 * PAsa el poder al Control_Paso que es el encargado de controlar lo relacionado a las tablas de pasos en 
	 * la plantilla, ya sea exportar, importar, modificar
	 * 
	 * @param file:la plantilla a abrir
	 * @param nombre: el nombre de la plantilla, tiene diversas utilidades
	 * @throws IOException
	 */
	public void paso(File file, String nombre) throws IOException {
		Control_Paso cp = new Control_Paso(this.sp);
		cp.iniciar(file,nombre);
	}
	
	/**
	 * PAsa el poder al Control_Crear que se encarga de lo relacionado a la creacion de plantillas
	 * y su muestra, sin llegar a interferir con el Control_Paso
	 * 
	 * @param usuario, necesita saber a que usuario adjuntar la referencia de la plantilla
	 * 
	 */
	public void Crear(String usuario) {
		Control_Crear cc = new Control_Crear(this.sc);
		cc.iniciar(usuario);
	}

}
