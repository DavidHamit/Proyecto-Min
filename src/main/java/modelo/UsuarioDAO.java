package modelo;

import controlador.Conexion;
import java.sql.*;

import javax.swing.JOptionPane;

public class UsuarioDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	UsuarioDTO us;
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean insertar(UsuarioDTO us) {
		int x;
		boolean y=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO usuarios values(?,?,?,?,?)");
			ps.setInt(1, us.getCedula());
			ps.setString(2, us.getNombre());
			ps.setString(3, us.getCorreo());
			ps.setString(4, us.getUsuario());
			ps.setString(5, us.getPassword());
			x=ps.executeUpdate();
			if(x>0) {
				y=true;
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar dato: "+ex);
		}
		return y;
	}
	
	public boolean eliminar(UsuarioDTO us) {
		boolean y=false;
		int x;
		try {
			ps=cnn.prepareStatement("DELETE FROM usuarios WHERE cedula=?");
			ps.setInt(1, us.getCedula());
			x=ps.executeUpdate();
			if(x!=0) {
				y=true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuario inexistente");
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar dato"+ex);
		}
		return y;
	}
	
	public UsuarioDTO consultapar(UsuarioDTO ud) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula=?");
			ps.setInt(1, ud.getCedula());
			rs=ps.executeQuery();
			if(rs.next()) {
				us=new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar dato: "+ex);
		}
		return us;
	}
}
