package negocio;

public class Usuario {
	private String Nombre;
	private String Apellido;
	private int Asesor;
	private String Contrase�a;
	private String Nick;
	
	public Usuario(String nombre, String apellido, int asesor2, String contrase�a, String nick) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Asesor = asesor2;
		Contrase�a = contrase�a;
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

	public String getContrase�a() {
		return Contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
	}

	public String getNick() {
		return Nick;
	}

	public void setNick(String nick) {
		Nick = nick;
	}
	
	

}
