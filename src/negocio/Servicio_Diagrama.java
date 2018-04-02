package negocio;

import java.io.File;

import javax.swing.JPanel;
import javax.swing.JTable;

import datos.DAO_Diagrama;

public class Servicio_Diagrama {

	DAO_Diagrama daod;
	
	public Servicio_Diagrama(DAO_Diagrama daod2) {
		// TODO Auto-generated constructor stub
		daod = daod2;
	}

	public JPanel generar(JTable tabla) {
		// TODO Auto-generated method stub
		return daod.generaDiagrama(tabla);
 
	}

}
