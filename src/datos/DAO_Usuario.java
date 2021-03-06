package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import negocio.Usuario;



public class DAO_Usuario {


	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String HOSTNAME = "localhost";
	final String DBNAME = "Generador";
	final String CONNECTION_URL = "jdbc:mysql://"+HOSTNAME +":3306/"+DBNAME;
	final String USERNAME = "root";


	final String PASSWORD = "123456";
	

	Conexion con;
	public Usuario[] Retrieve() throws SQLException {
		
		final String Todos_usuarios = "Select * from Usuario";

		con = new Conexion();
//		Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		

		
		ArrayList<Usuario> usuarioTemp = new ArrayList<Usuario>();
		try { // Crea el statement
			Statement statement = con.connection.createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery(Todos_usuarios);
			while (rs.next()) { // Crea una nueva instancia del objeto
				Usuario usuario = new Usuario(rs.getString("Nombre"), rs.getString("Apellido"), rs.getInt("Asesor"),

				rs.getString("Contrase�a"),rs.getString("Nick"));

				usuarioTemp.add(usuario);
			}
			Usuario usuarioTempArreglo[] = new Usuario[usuarioTemp.size()];
			usuarioTemp.toArray(usuarioTempArreglo);
			return usuarioTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean crear(Usuario u) throws SQLException {
		

		con = new Conexion();

		try {
			// Crea el statement
			Statement statement = con.connection.createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave
			// autogeneradaraduacion,String adicion

			statement.execute("INSERT INTO Usuario VALUES ('"+u.getNick() + "','"
					+ u.getContrasenia() + "','" + u.getNombre() + "','" + u.getApellido() + "','" + u.getAsesor() +"')",


					Statement.RETURN_GENERATED_KEYS);
			return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}


public Usuario recuperaUsuario(String usuario) throws SQLException {

		
		final String bUsuario = ("Select * from Usuario where Nick = '"+usuario+"'");
		//Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		con = new Conexion();

		
		try { // Crea el statement
			Statement statement = con.connection.createStatement();
			// Recibe los resutados
			ResultSet rs=null;
			rs = statement.executeQuery(bUsuario);
			Usuario usuario2 =null;
			while(rs.next()){
			usuario2 = new Usuario(rs.getString("Nombre"), rs.getString("Apellido"), rs.getInt("Asesor"),
					rs.getString("Contrase�a"),rs.getString("Nick"));
			}
			return usuario2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


// Metodo encarfgado de la actualizacion directa con la base de datos,
//en este caso por medio del nick que seria la llave primaria
public boolean actualizar(Usuario usuario) throws SQLException {
	boolean actualizar=false;
	final String aUsuario=
			"UPDATE Usuario SET Nombre=?"+/*usuario.getNombre()*/", Apellido=?"+/*usuario.getApellido()+*/
						", Asesor=?"/*+usuario.getAsesor()*/+", Contrase�a=?"/*+usuario.getContrasenia()*/						
						+" WHERE Nick= ?"/*'"+usuario.getNick()+*/;
	
	/*"UPDATE USUARIO SET nombre='Brandon', apellido = 'Leon Rangel', asesor=0, contraseña =1234,"
	+ " WHERE nick = 'branleon' ";

*/

	//Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
	con = new Conexion();
	try {

		PreparedStatement stm = con.connection.prepareStatement(aUsuario);
		//Statement stm=con.connection.createStatement();
		stm.setString(1, usuario.getNombre());
		stm.setString(2, usuario.getApellido());
		stm.setInt(3, usuario.getAsesor());
		stm.setString(4, usuario.getContrasenia());
		stm.setString(5, usuario.getNick());
		stm.executeUpdate();
		actualizar=true;

		return actualizar;
	} catch (SQLException e) {
		System.out.println("Error: método actualizar");
		e.printStackTrace();

		return actualizar;
	}		
}



}
