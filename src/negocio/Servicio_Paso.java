package negocio;

/**
 * ES una extension del Control_Paso
 */
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import datos.DAO_Paso;

public class Servicio_Paso {
	DAO_Paso daops;

	public Servicio_Paso(DAO_Paso daops2) {
		this.daops =daops2;
	}
	
	/**
	 * Exporta los datos a un archivo externo 
	 * @param frmProceso
	 * @param Tabla
	 * @return
	 */
	public boolean exportar(JFrame frmProceso, JTable Tabla) {
		if(daops.exportar(frmProceso, Tabla) == true) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Jala los datos de un archivo tipo excel a la tabla
	 * @return los datos que encontro en el archivo
	 * @throws IOException
	 */
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
	/**
	 * Metodo para tablas NO existentes en la DB
	 * @param Tabla
	 * @param importado
	 * @return
	 */
	public boolean editar(JTable Tabla, String importado) {
		if(daops.editar(Tabla,importado) == true) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * Metodo pra datos existentes en la base de datos y que quieren actualizar 
	 * @param Tabla
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	
	public boolean editar1(JTable Tabla, String nombre) throws Exception {
		if(daops.editar1(Tabla,nombre) == true) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * revisa si la plantilla existe en la DB
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public boolean existe(String nombre) throws SQLException {
		if(daops.existe(nombre)) {
			return true;
		}else {
			return false;
		}
	}

}
