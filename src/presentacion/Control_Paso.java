package presentacion;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTable;

import datos.DAO_Paso;
import negocio.Servicio_Paso;


public class Control_Paso {

	Servicio_Paso sp;
	DAO_Paso daops = new DAO_Paso();
	String us;
	
	public Control_Paso(Servicio_Paso sp2) {
		// TODO Auto-generated constructor stub
		sp = sp2;
		sp = new Servicio_Paso(daops);
	}

	public void iniciar(File file2, String usuario) throws IOException {
		File file;
		file = file2;
		us = usuario;
		Tabla ventana = new Tabla(this, file);
		ventana.frmProceso.setVisible(true);
		
	}
	
	public boolean editar(JTable Tabla, String importado) {
		if(sp.editar(Tabla, importado) == true) {
			return true;
		}else {
			return false;
		}
		
	}
	public void exportar(JFrame frmProceso, JTable Tabla) {
		sp.exportar(frmProceso, Tabla);
		
	}
	public File importar() throws IOException {
		File file=null;
//		System.out.println("Gato4");
		file = sp.Importar();
//		System.out.println("Gato5");
		return file;
	}
	
}
