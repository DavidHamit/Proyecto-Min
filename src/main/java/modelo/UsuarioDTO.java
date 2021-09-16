package modelo;

public class UsuarioDTO {
	private String usuario;
	private String password;
	private int cedula;
	//private long cedula;
	private String nombre;
	private String correo;
	
	public UsuarioDTO(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public UsuarioDTO(int cedula, String nombre, String correo, String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
		this.cedula = cedula;
		this.nombre = nombre;
		this.correo = correo;
	}
	
	public UsuarioDTO(int cedula) {
		this.cedula = cedula;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
