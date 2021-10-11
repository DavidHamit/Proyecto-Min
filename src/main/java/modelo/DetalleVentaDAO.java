package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	

}
