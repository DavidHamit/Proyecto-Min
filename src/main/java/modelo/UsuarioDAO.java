package modelo;

import controlador.Conexion;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UsuarioDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	UsuarioDTO us;
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean insertar(UsuarioDTO ud) {
		int x;
		boolean y=false;
		try {
			us=consultapar(ud);
			if(us==null) {
				ps=cnn.prepareStatement("INSERT INTO usuarios values(?,?,?,?,?)");
				ps.setInt(1, ud.getCedula());
				ps.setString(2, ud.getNombre());
				ps.setString(3, ud.getCorreo());
				ps.setString(4, ud.getUsuario());
				ps.setString(5, ud.getPassword());
				x=ps.executeUpdate();
				if(x>0) {
					y=true;
				}
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
	
	public int actualizar(UsuarioDTO ud) {
		int x=0;
		try {
			ps=cnn.prepareStatement("UPDATE usuarios SET nombre=?, correo_electronico=?, usuario=?, clave=? WHERE cedula=?");
			ps.setString(1, ud.getNombre());
			ps.setString(2, ud.getCorreo());
			ps.setString(3, ud.getUsuario());
			ps.setString(4, ud.getPassword());
			ps.setInt(5, ud.getCedula());
			x=ps.executeUpdate();
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar dato: "+ex);
		}
		return x;
	}
	
	public ArrayList<UsuarioDTO> consulta() {
		ArrayList <UsuarioDTO> lista=new ArrayList<>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuarios");
			rs=ps.executeQuery();
			while(rs.next()) {
				us=new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				lista.add(us);			
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al consultar: "+ex);
		}
		return lista;
	}
}
