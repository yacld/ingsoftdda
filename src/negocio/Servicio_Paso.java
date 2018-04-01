package negocio;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTable;

import datos.DAO_Paso;

public class Servicio_Paso {
	DAO_Paso daops;

	public Servicio_Paso(DAO_Paso daops2) {
		// TODO Auto-generated constructor stub
		this.daops =daops2;
	}
	
	public boolean editar(JTable Tabla, String importado) {
		if(daops.editar(Tabla,importado) == true) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean exportar(JFrame frmProceso, JTable Tabla) {
		if(daops.exportar(frmProceso, Tabla) == true) {
			return true;
		}else {
			return false;
		}
	}
	
	public File Importar() throws IOException {
		File file = null;
		System.out.println("Gato2");
		file = daops.importar();
		System.out.println("Gato3");
		return file;
	}

	public File iniciar() throws IOException {
		File file= null;
		file= daops.importar();
		return file;
	}

	public void generador_PDF(JTable tabla) throws IOException {
		daops.generador_PDF(tabla);
		
	}

}
