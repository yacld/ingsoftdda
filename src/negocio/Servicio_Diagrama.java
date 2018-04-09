package negocio;

import java.io.File;

import javax.swing.JPanel;
import javax.swing.JTable;

import datos.DAO_Diagrama;

/**
 * 
 * @author Yaeld
 * Clase que continua el proceso de generar el diagrama
 * contiene el metodo generar que llama al dao
 */

public class Servicio_Diagrama {

	DAO_Diagrama daod;
	/**
	 * Contructor de la clase
	 * recibe e inicia el dao del diagrama
	 * @param daod2
	 */
	public Servicio_Diagrama(DAO_Diagrama daod2) {
		// TODO Auto-generated constructor stub
		daod = daod2;
	}
	/**
	 * metodo que llama al metodo generar del dao
	 * regresa el panel obtenido del dao
	 * @param tabla
	 * @return
	 */
	public JPanel generar(JTable tabla) {
		// TODO Auto-generated method stub
		return daod.generaDiagrama(tabla);
 
	}

}
