package controlador;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	Connection cnn;
	
	public Connection conexionbd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnn=DriverManager.getConnection("jdbc:mysql://localhost/tienda_reto_mintic","root","admin");
			JOptionPane.showMessageDialog(null, "Conexion ok");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error en conexion: "+ex);
		}
		return cnn;
	}
}
