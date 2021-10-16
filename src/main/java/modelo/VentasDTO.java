package modelo;

public class VentasDTO {
	private int codigo;
	private int cedcli;
	private int cedusu;
	private double vlrventa;
	private double iva;
	private double total;
	
	public VentasDTO(int codigo, int cedcli, int cedusu, double vlrventa, double iva, double total) {
		this.codigo = codigo;
		this.cedcli = cedcli;
		this.cedusu = cedusu;
		this.vlrventa = vlrventa;
		this.iva = iva;
		this.total = total;
	}

	public VentasDTO(int cedcli, int cedusu, double vlrventa, double iva, double total) {
		this.cedcli = cedcli;
		this.cedusu = cedusu;
		this.vlrventa = vlrventa;
		this.iva = iva;
		this.total = total;
	}

	public VentasDTO(int cedcli, double iva, double vlrventa, double total) {
		super();
		this.cedcli = cedcli;
		this.vlrventa = vlrventa;
		this.iva = iva;
		this.total = total;
	}

	public VentasDTO(int cedcli, double total) {
		super();
		this.cedcli = cedcli;
		this.total = total;
	}

	public VentasDTO(int codigo) {
		this.codigo = codigo;
	}
	
	public VentasDTO(double vlrventa) {
		this.vlrventa = vlrventa;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCedcli() {
		return cedcli;
	}

	public void setCedcli(int cedcli) {
		this.cedcli = cedcli;
	}

	public int getCedusu() {
		return cedusu;
	}

	public void setCedusu(int cedusu) {
		this.cedusu = cedusu;
	}

	public double getVlrventa() {
		return vlrventa;
	}

	public void setVlrventa(double vlrventa) {
		this.vlrventa = vlrventa;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
