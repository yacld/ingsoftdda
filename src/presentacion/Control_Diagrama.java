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

public class Control_Diagrama {

	Servicio_Diagrama sd;
	DAO_Diagrama daod = new DAO_Diagrama();
	
	public Control_Diagrama() {
		// TODO Auto-generated constructor stub
		sd = new Servicio_Diagrama(daod);
	}

	public void iniciar(File file2) throws IOException {
		File file;
		file = file2;
		JPanel panel = sd.generar();//recibe panel?
		Ventana_Diagrama ventana = new Ventana_Diagrama(this, panel);//recibe panel que muestra diagrama
	}
	
	
	
	
}
