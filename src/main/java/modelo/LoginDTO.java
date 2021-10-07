package modelo;

public class LoginDTO {
	private String usuario;
	private String password;
	private int cedula;
	
	public LoginDTO(String usuario, String password, int cedula) {
		this.usuario = usuario;
		this.password = password;
		this.cedula = cedula;
	}
	
	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
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
	
}
