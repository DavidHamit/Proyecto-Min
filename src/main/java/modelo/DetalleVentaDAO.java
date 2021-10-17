package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class DetalleVentaDAO {
	DetalleVentaDTO dd;
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	
	public int ingresardetventa (DetalleVentaDTO dvdd) {
		int x=0;
		try {
			ps=cnn.prepareStatement("INSERT INTO detalleventas (codigo_productos,codigo_venta,cantidad,valor_venta,valor_total,valor_iva) VALUES(?,?,?,?,?,?)");
			ps.setLong(1, dvdd.getCoprod());
			ps.setLong(2, dvdd.getCodven());
			ps.setInt(3, dvdd.getCan());
			ps.setDouble(4, dvdd.getVrven());
			ps.setDouble(5, dvdd.getVrtot());
			ps.setDouble(6, dvdd.getVriva());
			x=ps.executeUpdate();
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al ingresar datos en tabla Detalle de Ventas"+ex);
		}
		return x;
		
	}

	public ArrayList<DetalleVentaDTO> detconsulta() {
		ArrayList<DetalleVentaDTO> lista=new ArrayList<DetalleVentaDTO>();
		try {
			ps=cnn.prepareStatement("SELECT codigo_productos, codigo_venta, cantidad, valor_venta, valor_total, valor_iva FROM detalleventas");
			rs=ps.executeQuery();
			while(rs.next()) {
				dd=new DetalleVentaDTO(rs.getLong(1), rs.getLong(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
				lista.add(dd);
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en consultar: "+ex);
		}
		return lista;
	}

	public DetalleVentaDTO detalleventa(DetalleVentaDTO dto) {
		try {
			ps=cnn.prepareStatement("SELECT codigo_productos, cantidad, valor_venta, valor_total, valor_iva FROM detalleventas WHERE codigo_venta=?");
			ps.setLong(1, dto.getCodven());
			rs=ps.executeQuery();
			while(rs.next()) {
				dd=new DetalleVentaDTO(rs.getLong(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en consultar: "+ex);
		}
		return dd;
	}
	
	

}
