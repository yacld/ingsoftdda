package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import negocio.Usuario;



public class DAO_Usuario {
	
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String HOSTNAME = "mydb-ealpha.cdtc5pclholt.us-west-1.rds.amazonaws.com";
	final String DBNAME = "mydb-ealpha";
	final String CONNECTION_URL = "jdbc:mysql://"+HOSTNAME +":3306/"+DBNAME;
	final String USERNAME = "masterUser";
	final String PASSWORD = "equipoalpha";
	

	public Usuario[] Retrieve() throws SQLException {
		
		final String Todos_usuarios = "Select * from Usuario";
		Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		
		
		ArrayList<Usuario> usuarioTemp = new ArrayList<Usuario>();
		try { // Crea el statement
			Statement statement = connection.createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery(Todos_usuarios);
			while (rs.next()) { // Crea una nueva instancia del objeto
				Usuario usuario = new Usuario(rs.getString("Nombre"), rs.getString("Apellido"), rs.getInt("Asesor"),

				rs.getString("Contrasenia"),rs.getString("Nick"));

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
		
		Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		try {
			// Crea el statement
			Statement statement = connection.createStatement();

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

public Usuario buscarUsuario(String usuario) throws SQLException {
		
		final String bUsuario = ("Select * from Usuario where Nick = "+usuario);
		Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		
		
		try { // Crea el statement
			Statement statement = connection.createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery(bUsuario);
				Usuario us = new Usuario(rs.getString("Nombre"), rs.getString("Apellido"), rs.getInt("Asesor"),
						rs.getString("Contrasenia"),rs.getString("Nick"));				
			return us;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}



}
