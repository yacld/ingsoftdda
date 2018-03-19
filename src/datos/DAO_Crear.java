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

public class DAO_Crear {

	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String HOSTNAME = "mydb-ealpha.cdtc5pclholt.us-west-1.rds.amazonaws.com";
	final String DBNAME = "dbeadda";
	final String CONNECTION_URL = "jdbc:mysql://"+HOSTNAME +":3306/"+DBNAME;
	final String USERNAME = "masterUser";
	final String PASSWORD = "equipoalpha";
	
	public File crear(String[] datos, String usuario) throws IOException {
//		
		File name = new File(datos[0] +".xls");
		FileInputStream input = null; 
		try {
				List<JTable> tb = new ArrayList<JTable>();
				
				// -------------------
				export_excel excelExporter = new export_excel(tb, new File(name.getAbsolutePath()));
				if (excelExporter.export()) {
					JOptionPane.showMessageDialog(null, "TABLAS CREADA CON EXITO!");
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


		Connection connection=null;
		try {
			connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// Crea el statement
//			Statement statement = connection.createStatement();
			String sql = "INSERT INTO Plantilla VALUES ('"+name.getName() + "',?"
					/*+ input*/ + "," + Long.parseLong(datos[1]) + ",'" + usuario + "','" + datos[2] +"')";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setBinaryStream(1, input);
			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave
			// autogeneradaraduacion,String adicion

			pstmt.executeUpdate();
			return name;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args){
		DAO_Crear daoc = new DAO_Crear();
		String[] pruebas  ={"prueba", "110001000", "ELasesor"};
		try {
			daoc.crear(pruebas, "yacl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
