package modelo;

import controlador.Conexion;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProductoDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ProductoDTO prodto;
	
	public boolean cargarproduc(String URL) {
		boolean x=false;
		try {
			ps=cnn.prepareStatement("load data infile '"+URL+"' into table productos fields terminated by ';' lines terminated by '\r\n';");
			x=ps.executeUpdate()>0;
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al cargar: "+ex);
		}
		return x;
	}
	
	public ProductoDTO consulta(ProductoDTO prod) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
			ps.setInt(1, prod.getCodigo());
			rs=ps.executeQuery();
			if(rs.next()) {
				prodto=new ProductoDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al consultar: "+ex);
		}
		
		return prodto;
	}
	
	public ArrayList<ProductoDTO> consultag(){
		ArrayList<ProductoDTO> lista=new ArrayList<ProductoDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos");
			rs=ps.executeQuery();
			while(rs.next()) {
				prodto=new ProductoDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
				lista.add(prodto);
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en consulta: "+ex);
		}
		return lista;
	}
}
