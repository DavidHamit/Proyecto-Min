package modelo;

import controlador.Conexion;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProveedorDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	ProveedorDTO pr;
	PreparedStatement ps;
	ResultSet rs;

	public int crear(ProveedorDTO pd) {
		int p=0;
		try {
			pr=consultar(pd);
			Integer ni=pd.getNit();
			if(pr==null) {
				if(ni.equals(null)) {
					p=2;
				}
				ps=cnn.prepareStatement("INSERT INTO proveedores VALUES (?,?,?,?,?)");
				ps.setInt(1, pd.getNit());
				ps.setString(2, pd.getNom());
				ps.setString(3, pd.getDir());
				ps.setInt(4, pd.getTel());
				ps.setString(5, pd.getCiudad());
				p=ps.executeUpdate();
			}
			else {
				p=3;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al crear: "+ex);
		}
		return p;
	}

	public String borrar(ProveedorDTO pr) {
		String p="";
		int q;
		try {
			ps=cnn.prepareStatement("DELETE FROM proveedores WHERE NIT_pr=?");
			ps.setInt(1, pr.getNit());
			q=ps.executeUpdate();
			if(q>0) {
				p="q";
			}
			else {
				p="n";
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al borrar: "+e);
		}
		return p;

	}
	
	public boolean actualizar(ProveedorDTO pd) {
		boolean p=false;
		int q;
		try {
			ps=cnn.prepareStatement("UPDATE proveedores SET nombre_proveedor=?,direccion_pr=?,telefono_pr=?,ciudad_pr=? WHERE NIT_pr=?");
			ps.setString(1, pd.getNom());
			ps.setString(2, pd.getDir());
			ps.setInt(3, pd.getTel());
			ps.setString(4, pd.getCiudad());
			ps.setInt(5, pd.getNit());
			q=ps.executeUpdate();
			if(q!=0) {
				p=true;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar Proveedor"+ex);
			}
		return p;
	}

	public ProveedorDTO consultar(ProveedorDTO prd) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedores WHERE NIT_pr=?");
			ps.setInt(1, prd.getNit());
			rs=ps.executeQuery();
			if(rs.next()) {
				pr=new ProveedorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al consultar dato: "+ex);
		}
		return pr;
	}

	
	
	public ArrayList<ProveedorDTO> consulta(){
		ArrayList<ProveedorDTO> lista=new ArrayList<>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedores");
			rs=ps.executeQuery();
			while(rs.next()) {
				pr=new ProveedorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				lista.add(pr);
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en consulta: "+ex);
		}
		return lista;
	}
}
