package datos;

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

	public void generador_PDF(JTable tabla) throws IOException {
		PDF pdf = new PDF();
		pdf.Generador_PDF(tabla);
		
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


	
	
	
}
