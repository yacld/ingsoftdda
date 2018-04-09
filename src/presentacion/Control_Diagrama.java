package presentacion;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import datos.DAO_Diagrama;
import datos.DAO_Paso;
import negocio.Servicio_Diagrama;
import negocio.Servicio_Paso;


/**
 * 
 * @author Yaeld
 * Clase que contiene el metodo que inicia el proceso de generar el diagrama
 * 
 */
public class Control_Diagrama {

	Servicio_Diagrama sd;
	DAO_Diagrama daod = new DAO_Diagrama();
	/**
	 * Constructor de la clase
	 */
	public Control_Diagrama() {
		// TODO Auto-generated constructor stub
		sd = new Servicio_Diagrama(daod);
	}
	/**
	 * Metodo que recibe panel al llamar el metodo generar de la clase servicio diagrama
	 * recibe tabla con los elementos para generar el diagrama
	 * crea un objeto Ventana_Diagrama el cual inicia la ventana y la muestra
	 * @param tabla
	 * @throws IOException
	 */
	public void iniciar(JTable tabla) throws IOException {
		try{
			JPanel panel = sd.generar(tabla);
			Ventana_Diagrama ventana = new Ventana_Diagrama(panel);//recibe panel que muestra diagrama
		}catch(Exception e){
		}
	
	}
	/**
	 * Metodo que nos servira para las pruebas
	 * hace lo mismo que el metodo inicia a excepcion de crear una ventana
	 * @param tabla
	 * @return
	 * @throws IOException
	 */
	public boolean generar(JTable tabla) throws IOException {
		try{
			JPanel panel = sd.generar(tabla);
			return true;
		}catch(Exception e){
			return false;
		}
	
	}
	
	
}
