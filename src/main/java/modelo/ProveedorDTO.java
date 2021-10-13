package modelo;

public class ProveedorDTO {
	private int nit;
	private String nom;
	private String dir;
	private int tel;
	private String ciudad;
	
	public ProveedorDTO(int nit, String nom, String dir, int tel, String ciudad) {
		super();
		this.nit = nit;
		this.nom = nom;
		this.dir = dir;
		this.tel = tel;
		this.ciudad = ciudad;
	}

	public ProveedorDTO(int nit) {
		this.nit = nit;
	}

	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}

