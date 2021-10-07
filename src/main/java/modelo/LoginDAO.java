package modelo;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class LoginDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	LoginDTO ld;
	
	public ArrayList<LoginDTO> login() {
		ArrayList<LoginDTO> lista=new ArrayList<>();
		try {
			ps=cnn.prepareStatement("SELECT usuario,clave,cedula FROM usuarios");
			rs=ps.executeQuery();
			while(rs.next()) {
				ld=new LoginDTO(rs.getString(1), rs.getString(2), rs.getInt(3));
				lista.add(ld);
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en el login: "+ex);
		}
		return lista;
	}
}
