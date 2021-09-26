package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedorDAO;
import modelo.ProveedorDTO;

/**
 * Servlet implementation class ServletProveedor
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nit;
		String nom,dir,tel,ciu;
		ProveedorDAO pdao;
		ProveedorDTO pdto;
		ProveedorDTO pcons;
		boolean z;
		String y;
		//BOTON CREAR PROVEEDOR
		if(request.getParameter("btncre")!=null) {
			nit=Integer.parseInt(request.getParameter("nit_pr"));
			nom=request.getParameter("nom_pr");
			dir=request.getParameter("dir_pr");
			tel=request.getParameter("tel_pr");
			ciu=request.getParameter("ciu_pr");
			if(nom=="" || dir=="" || tel=="" || ciu=="") {
				JOptionPane.showMessageDialog(null, "Faltan datos del Proveedor");
				response.sendRedirect("proveedores.jsp");
			}
			else{
				pdto=new ProveedorDTO(nit, nom, dir, tel, ciu);
				pdao=new ProveedorDAO();
				y=pdao.crear(pdto);
				if(y.equals("y")) {
					JOptionPane.showMessageDialog(null, "Proveedor Creado");
					response.sendRedirect("proveedores.jsp");
				}
				else 
					if(y.equals("ex")){
						JOptionPane.showMessageDialog(null, "El proveedor ya existe");
						response.sendRedirect("proveedores.jsp");
					}
			}
		}

		//BOTON BORRAR PROVEEDOR
		if(request.getParameter("btnbor")!=null) {
			nit=Integer.parseInt(request.getParameter("nit_pr"));
			pdto=new ProveedorDTO(nit);
			pdao=new ProveedorDAO();
			z=pdao.borrar(pdto);
			if(z) {
				JOptionPane.showMessageDialog(null, "Proveedor con NIT "+nit+", han sido borrados");
				response.sendRedirect("proveedores.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Proveedor inexistente");
				response.sendRedirect("proveedores.jsp");
			}
		}

		//BOTON CONSULTAR PROVEEDOR
		if(request.getParameter("btncon")!=null) {
			int ni;
			nit=Integer.parseInt(request.getParameter("nit_pr"));
			pdto=new ProveedorDTO(nit);
			pdao=new ProveedorDAO();
			pcons=pdao.consultar(pdto);
			if(pcons==null) {
				JOptionPane.showMessageDialog(null, "Proveedor inexistente");
				response.sendRedirect("proveedores.jps");
			}
			ni=pcons.getNit();
			nom=pcons.getNom();
			dir=pcons.getDir();
			tel=pcons.getTel();
			ciu=pcons.getCiudad();
			response.sendRedirect("proveedores.jsp?ni="+ni+"&&npr="+nom+"&&di="+dir+"&&te="+tel+"&&ci="+ciu);
		}

		//BOTON ACTUALIZAR PROVEEDOR
		if(request.getParameter("btnact")!=null) {
			int x;
			nit=Integer.parseInt(request.getParameter("nit_pr"));
			nom=request.getParameter("nom_pr");
			dir=request.getParameter("dir_pr");
			tel=request.getParameter("tel_pr");
			ciu=request.getParameter("ciu_pr");
			if(nom=="" || dir=="" || tel=="" || ciu=="") {
				JOptionPane.showMessageDialog(null, "Faltan datos del Proveedor");
				response.sendRedirect("proveedores.jsp");
			}
			else {
				pdto=new ProveedorDTO(nit, nom, dir, tel, ciu);
				pdao=new ProveedorDAO();
				x=pdao.actualizar(pdto);
				if(x!=0) {
					JOptionPane.showMessageDialog(null, "Los datos del Proveedor han sido actualizados");
					response.sendRedirect("proveedores.jsp");
				}
				else {
					JOptionPane.showMessageDialog(null, "Proveedor NO existe");
					response.sendRedirect("proveedores.jsp");
				}
			}
		}
	}
}
