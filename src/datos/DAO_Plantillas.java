package datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

//import com.mysql.jdbc.PreparedStatement;

import negocio.Usuario;

/**
 * Clase que lee las plantillas de base de datos 
 * @author Yaeld
 * Su unica funcion es obten_plantillas
 */
public class DAO_Plantillas {

	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final static String HOSTNAME = "mydb-ealpha.cdtc5pclholt.us-west-1.rds.amazonaws.com";
	final static String DBNAME = "dbeadda";
	final static String CONNECTION_URL = "jdbc:mysql://"+HOSTNAME +":3306/"+DBNAME;
	final static String USERNAME = "masterUser";
	final static String PASSWORD = "equipoalpha";
//	public Connection connection;

	/**
	 * Funcion que llena el modelo del Jlist en primer ventana
	 * @param usuario
	 * @param listModel
	 * @return
	 * @throws SQLException
	 */
	public boolean Obten_Plantillas(String usuario, DefaultListModel<File> listModel) throws SQLException {
		
		final String todas_plantillas = "Select * from Plantilla where Usuario = '" +usuario+ "'";
//		Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
					
	     ResultSet rs = null;
	 
	     try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
	                PreparedStatement pstmt = connection.prepareStatement(todas_plantillas);){
	         
	            rs = pstmt.executeQuery();
	 
	            // write binary stream into file
	           
	            while (rs.next()) {
	            	File file = new File(rs.getString("Nombre"));
	 	            FileOutputStream output = new FileOutputStream(file);
	                InputStream input = rs.getBinaryStream("archivo");
	                byte[] buffer = new byte[1024];
	                while (input.read(buffer) > 0) {
	                    output.write(buffer);
	                }
	                listModel.addElement(file);
	            }
	            return true;
	      } catch (SQLException e) {
	            System.out.println(e.getMessage());
	      } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	          try {
	                if (rs != null) {
	                    rs.close();
	                }
	          } catch (SQLException e) {
	                System.out.println(e.getMessage());
	          }
	      }
	     return false;
		
	}
	
}
