package datos;
/**
 * Aqui esta todo lo relacionado al manejo en la base de datos sobre los pasos de plantilla
 * ES la parte logica del manejo de los pasos
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import negocio.PDF;

public class DAO_Paso {
	/*final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String HOSTNAME = "localhost";
	final String DBNAME = "Generador";
	final String CONNECTION_URL = "jdbc:mysql://"+HOSTNAME +":3306/"+DBNAME;
	final String USERNAME = "root";
	final String PASSWORD = "camara";
	*/
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	//final String HOSTNAME = "localhost";
	//final String DBNAME = "Generador";
	final String CONNECTION_URL = "jdbc:mysql://localhost:3306/Generador";
	final String USERNAME = "root";
	final String PASSWORD = "camara";
	
	private JFileChooser FileChooser = new JFileChooser();

	/**
	 * Aqui uelve a crear otro archivo con el mismo nombre y ubicacion de el importado y lo reemplaza asi se actializa
	 * en el equipo
	 * @param: Tabla: daots nuevos
	 * @param: importado:ubucaion y nombre del archivo
	 * @return: true si se pudo actualizar, false si no fue asi
	 */
	public boolean editar(JTable Tabla, String importado) {
		try {
			List<JTable> tb = new ArrayList<JTable>();
			tb.add(Tabla);
			// -------------------
			export_excel excelExporter = new export_excel(tb, new File(importado));
			if (excelExporter.export()) {
				JOptionPane.showMessageDialog(null, "TABLA ACTUALIZADA CON EXITOS!");
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}
	
	/**
	 * Genera un archivo excel con los datos de la tabla y lo guardamos donde queramos
	 * @param frmProceso
	 * @param Tabla: datos de la tabla
	 * @return: true si se pudo actualizar, false si no fue asi
	 */
	public boolean exportar(JFrame frmProceso, JTable Tabla) {
		JFileChooser dialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Plantillas xls, csv", "xls", "csv");
		dialog.setFileFilter(filter);
		int opcion = dialog.showSaveDialog(frmProceso);
		
		if (opcion == JFileChooser.APPROVE_OPTION) {

			File dir = dialog.getSelectedFile();

			try {
				List<JTable> tb = new ArrayList<JTable>();
				tb.add(Tabla);
				// -------------------
				export_excel excelExporter = new export_excel(tb, new File(dir.getAbsolutePath()));
				if (excelExporter.export()) {
					JOptionPane.showMessageDialog(null, "TABLAS EXPORTADAS CON EXITO!");
					return true;
				}else{
					JOptionPane.showMessageDialog(null, "NO SE HA PODIDO EXPORTAR");
					return true;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}
		}
		return false;
	}

	/**
	 * Busca un archivo tipo excel y obtiene los datos que contenga,(obvio se recomienda que los
	 * parametros de la tabla coincidan con los del archivo)
	 * @return: retorna los datos del archivo
	 * @throws IOException
	 */
	public File importar() throws IOException {
//		System.out.println("Perro");
		FileChooser.showDialog(null, "Importar Plantilla ");
		File file =null;
//		System.out.println("Gato");
		file = FileChooser.getSelectedFile();
		//System.out.println(file.getPath());
		if (!file.getName().endsWith("xls") && !file.getName().endsWith("csv")) {


			JOptionPane.showMessageDialog(null, "Seleccione un archivo valido...", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
//			System.out.println("Gato6");
			return file;
		}
		return null;
	}

	

	/**
	 * edita los datos en la base de datos haciendo un UPDATE,primero transforma los datos a 
	 * un archivo tipo excel y luego los guarda en la base
	 * @param tabla:datos de los pasos
	 * @param nombre: nombre de la plantilla a modificar
	 * @return: true si se pudo actualizar, false si no fue asi
	 * @throws Exception
	 */
	public boolean editar1(JTable tabla, String nombre) throws Exception {
		System.out.println("Soy el nomber"+nombre);
		List<JTable> tb = new ArrayList<JTable>();
		tb.add(tabla);
		InputStream input = null;
		export_excel excelExporter = new export_excel(tb, new File(nombre));
		excelExporter.export();
		input = new FileInputStream(nombre);
		
		try {
		final String actualizar = "UPDATE Plantila SET Archivo=? WHERE Nombre=?";
		Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		PreparedStatement statement = connection.prepareStatement(actualizar);
		statement.setBinaryStream(1, input);
		statement.setString(2, nombre);
		statement.executeUpdate();
		return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * revisa si la plantilla exixte en la base de datos
	 * @param nombre: nombre de la plantilla
	 * @return: true si se pudo actualizar, false si no fue asi
	 * @throws SQLException
	 */
	public boolean existe(String nombre) throws SQLException {
		
		final String existe = "SELECT Nombre FROM Plantila WHERE Nombre = '"+ nombre+"'";
		Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(existe);
			if(rs == null) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}


	
	
	
}
