package datos;

public class Conexion {
	
	Object[][] data = null;

	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String CONNECTION_URL = "jdbc:mysql://localhost:3306/Ejemplo_Usuario";
	final String USERNAME = "root";
	final String PASSWORD = "camara";
	
	final String QUERY = "Select * from Usuario";
	
	

}
