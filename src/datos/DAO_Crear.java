package datos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import negocio.Usuario;

public class DAO_Crear {


	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	//final String HOSTNAME = "localhost";
	//final String DBNAME = "Generador";
	final String CONNECTION_URL = "jdbc:mysql://localhost:3306/Generador";
	final String USERNAME = "root";
	final String PASSWORD = "camara";


	
	public File crear(String[] datos, String string) throws IOException {
//		
		File name = new File(datos[0] +".xls");
		FileInputStream input = null; 
		try {
				List<JTable> tb = new ArrayList<JTable>();
				
				// -------------------
				export_excel excelExporter = new export_excel(tb, new File(name.getAbsolutePath()));
				if (excelExporter.export()) {
					
					System.out.println("Esta es la direccion "+name);
					input = new FileInputStream(name);
//					return name;
				}else{
					JOptionPane.showMessageDialog(null, "NO SE HA PODIDO CREAR");
					return null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}

		Conexion con = new Conexion();
		
		try {
			// Crea el statement
//			Statement statement = connection.createStatement();

			String sql = "INSERT INTO Plantila VALUES ('"+name.getName() + "',?"
					/*+ input*/ + "," + Long.parseLong(datos[1]) + ",'" + string + "','" + datos[2] +"')";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setBinaryStream(1, input);
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave
			// autogeneradaraduacion,String adicion

			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "PLANTILLA CREADA CON EXITO!");
			return name;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args){
		DAO_Crear daoc = new DAO_Crear();
		String[] pruebas  ={"prueba2", "110001001", "ELasesor"};
		try {
			daoc.crear(pruebas, "yacld");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
