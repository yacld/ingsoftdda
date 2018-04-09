package negocio;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import datos.DAO_Paso;

public class Servicio_Paso {
	DAO_Paso daops;

	public Servicio_Paso(DAO_Paso daops2) {
		// TODO Auto-generated constructor stub
		this.daops =daops2;
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
	
	public boolean editar(JTable Tabla, String importado) {
		if(daops.editar(Tabla,importado) == true) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean editar1(JTable Tabla, String nombre) throws Exception {
		if(daops.editar1(Tabla,nombre) == true) {
			return true;
		}else {
			return false;
		}
	}

	public boolean existe(String nombre) throws SQLException {
		if(daops.existe(nombre)) {
			return true;
		}else {
			return false;
		}
	}

}
