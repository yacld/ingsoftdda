package negocio;

public class Usuario {
	private String Nombre;
	private String Apellido;
	private int Asesor;
	private String Contrasenia;
	private String Nick;
	
	public Usuario(String nombre, String apellido, int asesor2, String contrasenia, String nick) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Asesor = asesor2;
		Contrasenia = contrasenia;
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

	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}

	public String getNick() {
		return Nick;
	}

	public void setNick(String nick) {
		Nick = nick;
	}
	
	

}
