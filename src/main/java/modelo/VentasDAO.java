package modelo;

import controlador.Conexion;
import java.sql.*;
import java.util.ArrayList;

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
	
	public VentasDTO consultacodigo() {
		try {
			ps=cnn.prepareStatement("SELECT MAX(codigo_venta),valor_venta,valor_IVA,valor_total_venta AS id FROM ventas");
			rs=ps.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Dentro del if");
				vdto=new VentasDTO(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4));
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en consultar: "+ex);
		}
		return vdto;
	}
	
	public VentasDTO consultaced(VentasDTO ven) {
		try {
			ps=cnn.prepareStatement("SELECT cedula_cliente, valor_total_venta FROM ventas WHERE codigo_venta=?");
			ps.setInt(1, ven.getCodigo());
			rs=ps.executeQuery();
			if(rs.next()) {
				vdto=new VentasDTO(rs.getInt(1), rs.getDouble(2));
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al consultar: "+ex);
		}
		return vdto;
	}
	
	public ArrayList<VentasDTO> consulta() {
		ArrayList<VentasDTO> lista=new ArrayList<>();
		try {
			ps=cnn.prepareStatement("SELECT cedula_cliente, valor_total_venta FROM ventas");
			rs=ps.executeQuery();
			while(rs.next()) {
				vdto=new VentasDTO(rs.getInt(1),rs.getDouble(2));
				lista.add(vdto);
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en conulta: "+ex);
		}
		return lista;
	}
}
