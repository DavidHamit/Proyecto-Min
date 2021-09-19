package modelo;

public class ClienteDTO {
	private int cedula;
	private String nombre;
	private String direccion;
	private int tel;
	private String email;
	
	public ClienteDTO(int cedula, String nombre, String direccion, int tel, String email) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tel = tel;
		this.email = email;
	}

	public ClienteDTO(int cedula) {
		this.cedula = cedula;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
