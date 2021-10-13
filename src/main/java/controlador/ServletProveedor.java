package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

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
		ProveedorDAO pdao;
		ProveedorDTO pdto;
		ProveedorDTO pcons;
		int nit=0,tel=0;
		String nom="",dir="",ciu="";
		PrintWriter pw=response.getWriter();
		//BOTON CREAR PROVEEDOR
		if(request.getParameter("btncre")!=null) {
			int x;
			nit=Integer.parseInt(request.getParameter("nitpr"));
			nom=request.getParameter("nompr");
			dir=request.getParameter("dirpr");
			tel=Integer.parseInt(request.getParameter("telpr"));
			ciu=request.getParameter("ciupr");
			if(nom.equals("") || dir.equals("") || tel==0 || ciu.equals("")){
				JOptionPane.showMessageDialog(null, "Faltan datos del Proveedor");
				response.sendRedirect("proveedores.jsp");
			}
			else if(nit==0){
				JOptionPane.showMessageDialog(null, "Falta NIT del Proveedor");
				response.sendRedirect("proveedores.jsp");
				}
			else {
				pdto=new ProveedorDTO(nit, nom, dir, tel, ciu);
				pdao=new ProveedorDAO();
				x=pdao.crear(pdto);
				if(x==1) {
					JOptionPane.showMessageDialog(null, "Proveedor Creado");
					response.sendRedirect("proveedores.jsp");
				}
				else 
					if(x==3){
						JOptionPane.showMessageDialog(null, "El Proveedor ya existe");
						response.sendRedirect("proveedores.jsp");
					}
			}
		}

		//BOTON BORRAR PROVEEDOR
		if(request.getParameter("btnbor")!=null) {
			String q;
			nit=Integer.parseInt(request.getParameter("nitpr"));
			pdto=new ProveedorDTO(nit);
			pdao=new ProveedorDAO();
			q=pdao.borrar(pdto);
			if(q.equals("q")) {
				JOptionPane.showMessageDialog(null, "Proveedor con NIT "+nit+", han sido borrados");
				response.sendRedirect("proveedores.jsp");
			}
			else if(q.equals("n")){
				JOptionPane.showMessageDialog(null, "Proveedor NO existe en la base de datos");
				response.sendRedirect("proveedores.jsp");
			}
		}
		
		//BOTON ACTUALIZAR PROVEEDOR
		if(request.getParameter("btnact")!=null) {
			boolean p;
			nit=Integer.parseInt(request.getParameter("nitpr"));
			nom=request.getParameter("nompr");
			dir=request.getParameter("dirpr");
			tel=Integer.parseInt(request.getParameter("telpr"));
			ciu=request.getParameter("ciupr");
			if(nom.equals("") || dir.equals("") || tel==0 || ciu.equals("")) {
				JOptionPane.showMessageDialog(null, "Faltan datos del Proveedor");
				response.sendRedirect("proveedores.jsp");
			}
			else {
				pdto=new ProveedorDTO(nit, nom, dir, tel, ciu);
				pdao=new ProveedorDAO();
				p=pdao.actualizar(pdto);
				if(p) {
					JOptionPane.showMessageDialog(null, "Los datos del Proveedor han sido actualizados");
					response.sendRedirect("proveedores.jsp");
				}
				else {
					JOptionPane.showMessageDialog(null, "Proveedor NO existe en la base de datos");
					response.sendRedirect("proveedores.jsp");
				}
			}
		}

		//BOTON CONSULTAR PROVEEDOR
		if(request.getParameter("btncon")!=null) {
			int ni;
			nit=Integer.parseInt(request.getParameter("nitpr"));
			pdto=new ProveedorDTO(nit);
			pdao=new ProveedorDAO();
			pcons=pdao.consultar(pdto);
			if(pcons==null) {
				JOptionPane.showMessageDialog(null, "Proveedor NO existe en la base de datos");
				response.sendRedirect("proveedores.jps");
			}
			ni=pcons.getNit();
			nom=pcons.getNom();
			dir=pcons.getDir();
			tel=pcons.getTel();
			ciu=pcons.getCiudad();
			response.sendRedirect("proveedores.jsp?nitpr="+ni+"&&nompr="+nom+"&&dirpr="+dir+"&&telpr="+tel+"&&ciupr="+ciu);
		}
		
		//BOTON LISTA DE PROVEEDORES
		String dato=request.getParameter("dat");
		if(dato!=null) {
			if(dato.equals("proveedor")) {
				JOptionPane.showMessageDialog(null, "if proveedor");
				ArrayList<ProveedorDTO> lista=new ArrayList<ProveedorDTO>();
				pdao=new ProveedorDAO();
				lista=pdao.consulta();
				JOptionPane.showMessageDialog(null, lista.size());
				Gson gson=new Gson();
				pw.println(gson.toJson(lista));
			}
		}
	}
}
