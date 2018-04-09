package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import negocio.Usuario;

public class Conexion {
	/*final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/Generador";
	final static String USERNAME = "root";
	final static String PASSWORD = "123456";
	
	*/
	
	
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final static String HOSTNAME = "mydb-ealpha.cdtc5pclholt.us-west-1.rds.amazonaws.com";
	final static String DBNAME = "dbeadda";
	final static String CONNECTION_URL = "jdbc:mysql://"+HOSTNAME +":3306/"+DBNAME;
	final static String USERNAME = "masterUser";
	final static String PASSWORD = "equipoalpha";
	public Connection connection;

	Conexion(){
		try {
			connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		
//		final String Todos_usuarios = "Select * from Usuario";
		try {
			Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			System.out.println("conectado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
