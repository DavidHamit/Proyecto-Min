package modelo;

public class DetalleVentaDTO {
	private long codetven;
	private long coprod;
	private long codven;
	private int can;
	private double vrven;
	private double vrtot;
	private double vriva;
	
	public DetalleVentaDTO(long codetven, long coprod, long codven, int can, double vrven, double vrtot, double vriva) {
		super();
		this.codetven = codetven;
		this.coprod = coprod;
		this.codven = codven;
		this.can = can;
		this.vrven = vrven;
		this.vrtot = vrtot;
		this.vriva = vriva;
	}

	public DetalleVentaDTO(long coprod, long codven, int can, double vrven, double vrtot, double vriva) {
		super();
		this.coprod = coprod;
		this.codven = codven;
		this.can = can;
		this.vrven = vrven;
		this.vrtot = vrtot;
		this.vriva = vriva;
	}

	public DetalleVentaDTO(long codven) {
		this.codven = codven;
	}

	public DetalleVentaDTO(long coprod, int can, double vrven, double vrtot, double vriva) {
		super();
		this.coprod = coprod;
		this.can = can;
		this.vrven = vrven;
		this.vrtot = vrtot;
		this.vriva = vriva;
	}

	public long getCodetven() {
		return codetven;
	}

	public void setCodetven(long codetven) {
		this.codetven = codetven;
	}

	public long getCoprod() {
		return coprod;
	}

	public void setCoprod(long coprod) {
		this.coprod = coprod;
	}

	public long getCodven() {
		return codven;
	}

	public void setCodven(long codven) {
		this.codven = codven;
	}

	public int getCan() {
		return can;
	}

	public void setCan(int can) {
		this.can = can;
	}

	public double getVrven() {
		return vrven;
	}

	public void setVrven(double vrven) {
		this.vrven = vrven;
	}

	public double getVrtot() {
		return vrtot;
	}

	public void setVrtot(double vrtot) {
		this.vrtot = vrtot;
	}

	public double getVriva() {
		return vriva;
	}

	public void setVriva(double vriva) {
		this.vriva = vriva;
	}

	
	
	
}