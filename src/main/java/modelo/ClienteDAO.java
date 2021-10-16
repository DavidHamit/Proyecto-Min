package modelo;

import controlador.Conexion;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ClienteDAO {
	
	Conexion con=new Conexion();
	ClienteDTO cd;
	Connection cnn=con.conexionbd();
	ResultSet rs;
	PreparedStatement ps;
	
	public int insertar(ClienteDTO cl) {
		int x=0;
		try {
			cd=consultarp(cl);
			Integer doc=cl.getCedula();
			if(cd==null) {
				if(doc.equals(null)) {
					x=2;
				}
				ps=cnn.prepareStatement("INSERT INTO clientes values(?,?,?,?,?)");
				ps.setInt(1, cl.getCedula());
				ps.setString(2, cl.getNombre());
				ps.setString(3, cl.getDireccion());
				ps.setInt(4, cl.getTel());
				ps.setString(5, cl.getEmail());
				x=ps.executeUpdate();
			}
			else {
				x=3;
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar: "+ex);
		}
		return x;
	}
	
	public String eliminar(ClienteDTO cl) {
		String x="";
		int y;
		try {
			ps=cnn.prepareStatement("DELETE FROM clientes WHERE cedula=?");
			ps.setInt(1, cl.getCedula());
			y=ps.executeUpdate();
			if(y>0) {
				x="y";
			}
			else {
				x="n";
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Error al eliminar: "+ex);
		}
		return x;
	}
	
	public boolean actualizar(ClienteDTO cl) {
		
		boolean x=false;
		int y;
		try {
			ps=cnn.prepareStatement("UPDATE clientes SET nombre=?, direccion=?, telefono=?, correo_electronico=? WHERE cedula=?");
			ps.setString(1, cl.getNombre());
			ps.setString(2, cl.getDireccion());
			ps.setInt(3, cl.getTel());
			ps.setString(4, cl.getEmail());
			ps.setInt(5, cl.getCedula());
			y=ps.executeUpdate();
			if(y!=0) {
				x=true;
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar: "+ex);
		}
		return x;
	}
	
public ClienteDTO consultarp(ClienteDTO cl) {
		
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes WHERE cedula=?");
			ps.setInt(1, cl.getCedula());
			rs=ps.executeQuery();
			if(rs.next()) {
				cd=new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al consultar: "+ex);
		}
		return cd;
	}

	
	public ArrayList<ClienteDTO> consulta(){
		ArrayList<ClienteDTO> lista=new ArrayList<>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes");
			rs=ps.executeQuery();
			while(rs.next()) {
				cd=new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				lista.add(cd);
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en consulta: "+ex);
		}
		return lista;
	}

}
