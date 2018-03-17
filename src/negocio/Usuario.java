package negocio;

public class Usuario {
	private String Nombre;
	private String Apellido;
	private int Asesor;
	private String Contraseña;
	private String Nick;
	
	public Usuario(String nombre, String apellido, int asesor2, String contraseña, String nick) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Asesor = asesor2;
		Contraseña = contraseña;
		Nick = nick;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public int getAsesor() {
		return Asesor;
	}

	public void setAsesor(int asesor) {
		Asesor = asesor;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public String getNick() {
		return Nick;
	}

	public void setNick(String nick) {
		Nick = nick;
	}
	
	

}
