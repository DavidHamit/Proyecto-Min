package controlador;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	Connection cnn;
	
	public Connection conexionbd() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			cnn=DriverManager.getConnection("jdbc:mysql://tiendagenericagrupo43-10-32.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/tienda_G32_Equipo1","admin","123456789");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//cnn=DriverManager.getConnection("jdbc:mysql://localhost/tienda_reto_mintic","root","admin");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error en conexion: "+ex);
		}
		return cnn;
	}
}
