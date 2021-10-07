package modelo;

public class ProductoDTO {
	private int codigo;
	private double iva;
	private int nit;
	private String nomprod;
	private double precventa;
	private double precompra;
	
	public ProductoDTO(int codigo, String nomprod, int nit, double precompra, double iva, double precventa) {
		this.codigo = codigo;
		this.iva = iva;
		this.nit = nit;
		this.nomprod = nomprod;
		this.precventa = precventa;
		this.precompra = precompra;
	}

	public ProductoDTO(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getNomprod() {
		return nomprod;
	}

	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}

	public double getPrecventa() {
		return precventa;
	}

	public void setPrecventa(double precventa) {
		this.precventa = precventa;
	}

	public double getPrecompra() {
		return precompra;
	}

	public void setPrecompra(double precompra) {
		this.precompra = precompra;
	}
	
	
}
