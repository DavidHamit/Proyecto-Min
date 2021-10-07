package modelo;

import controlador.Conexion;
import java.sql.*;

import javax.swing.JOptionPane;

public class VentasDAO {
	VentasDTO vdto;
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	
	public int registrar(VentasDTO ven) {
		int x=0;
		try {
			ps=cnn.prepareStatement("INSERT INTO ventas (cedula_cliente, cedula_usuario, valor_venta, valor_IVA, valor_total_venta) VALUE (?,?,?,?,?)");
			ps.setInt(1, ven.getCedcli());
			ps.setInt(2, ven.getCedusu());
			ps.setDouble(3, ven.getVlrventa());
			ps.setDouble(4, ven.getIva());
			ps.setDouble(5, ven.getTotal());
			x=ps.executeUpdate();
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al registrar: "+ex);
		}
		return x;
	}
}
