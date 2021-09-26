package modelo;

import controlador.Conexion;
import java.sql.*;

import javax.swing.JOptionPane;

public class ProveedorDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	ProveedorDTO pr;
	PreparedStatement ps;
	ResultSet rs;

	public String crear(ProveedorDTO pd) {
		int p;
		String c="";
		try {
			pr=consultar(pd);
			if(ps==null) {
				ps=cnn.prepareStatement("INSERT INTO proveedores VALUES (?,?,?,?,?)");
				ps.setInt(1, pr.getNit());
				ps.setString(2, pr.getNom());
				ps.setString(3, pr.getDir());
				ps.setString(4, pr.getTel());
				ps.setString(5, pr.getCiudad());
				p=ps.executeUpdate();
				if(p>0) {
					c="y";
				}
			}
			else {
				c="ex";
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear: "+e);
		}
		return c;
	}

	public boolean borrar(ProveedorDTO pr) {
		int p;
		boolean b=false;
		try {
			ps=cnn.prepareStatement("DELETE FROM proveedores WHERE NIT_pr=?");
			ps.setInt(1, pr.getNit());
			p=ps.executeUpdate();
			if(p>0) {
				b=true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al borrar: "+e);
		}
		return b;

	}

	public ProveedorDTO consultar(ProveedorDTO prd) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedores WHERE NIT_pr=?");
			ps.setInt(1, prd.getNit());
			rs=ps.executeQuery();
			if(rs.next()) {
				pr=new ProveedorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar dato: "+e);
			e.printStackTrace();
		}
		return pr;
	}

	public int actualizar(ProveedorDTO pd) {
		int z=0;
		try {
			ps=cnn.prepareStatement("UPDATE proveedores SET nombre_proveedor=?,direccion_pr=?,telefono_pr=?,ciudad_pr=? WHERE NIT_pr=?");
			ps.setString(1, pd.getNom());
			ps.setString(2, pd.getDir());
			ps.setString(3, pd.getTel());
			ps.setString(4, pd.getCiudad());
			ps.setInt(5, pd.getNit());
			z=ps.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar Proveedor"+e);
			e.printStackTrace();
		}
		return z;
	}
}
