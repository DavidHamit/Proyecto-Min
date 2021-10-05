package modelo;

import controlador.Conexion;
import java.sql.*;

import javax.swing.JOptionPane;

public class ProductoDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	
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
}
