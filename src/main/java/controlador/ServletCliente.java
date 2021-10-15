package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.ClienteDAO;
import modelo.ClienteDTO;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
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
		ClienteDAO cd;
		ClienteDTO cl;
		ClienteDTO cons;
		int cedula=0,tel=0;
		String nom="",dir="",email="";
		PrintWriter pw=response.getWriter();
		//BLOQUE DE INSERTAR
		if(request.getParameter("btnins")!=null) {
			String mensaje;
			int x;
			/*if(request.getParameter("tel")==null || Integer.parseInt(request.getParameter("tel"))==0) {
				tel=0;
			}
			if(request.getParameter("cedula")==null || request.getParameter("cedula")=="") {
				cedula=0;
			}*/
			cedula=Integer.parseInt(request.getParameter("cedula"));
			nom=request.getParameter("nombre");
			dir=request.getParameter("direc");
			tel=Integer.parseInt(request.getParameter("tel"));
			email=request.getParameter("email");
			if(nom.equals("") || dir.equals("") || tel==0 || email.equals("")) {
				//JOptionPane.showMessageDialog(null, "Datos del cliente faltantes");
				mensaje="Datos del cliente faltantes";
				response.sendRedirect("clientes.jsp?mensaje="+mensaje);
			}
			else 
				if(cedula==0) {
					//JOptionPane.showMessageDialog(null, "Se requiere la cedula del cliente");
					mensaje="Se requiere la cedula del cliente";
					response.sendRedirect("clientes.jsp?mensaje="+mensaje);
				}
			else {
				cl=new ClienteDTO(cedula, nom, dir, tel, email);
				cd=new ClienteDAO();
				x=cd.insertar(cl);
				if(x==1) {
					//JOptionPane.showMessageDialog(null, "Cliente Creado");
					mensaje="Cliente creado";
					response.sendRedirect("clientes.jsp?mensaje="+mensaje);
				}
				else if(x==3) {
					//JOptionPane.showMessageDialog(null, "El cliente ya existe");
					mensaje="El cliente ya existe";
					response.sendRedirect("clientes.jsp?mensaje="+mensaje);
				}
			}
		}
		
		//BLOQUE DE ELIMINAR
		if(request.getParameter("btneli")!=null) {
			String y, mensaje;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			cl=new ClienteDTO(cedula);
			cd=new ClienteDAO();
			y=cd.eliminar(cl);
			if(y.equals("y")) {
				//JOptionPane.showMessageDialog(null, "Datos del Cliente Borrados");
				mensaje="Datos del Cliente Borrados";
				response.sendRedirect("clientes.jsp?mensaje="+mensaje);
			}
			else
				if(y.equals("n")) {
					//JOptionPane.showMessageDialog(null, "Cliente inexistente");
					mensaje="Cliente Inexistente";
					response.sendRedirect("clientes.jsp?mensaje="+mensaje);
				}
		}
		
		//BLOQUE DE ACTUALIZAR
		if(request.getParameter("btnact")!=null) {
			String mensaje;
			boolean x;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			nom=request.getParameter("nombre");
			dir=request.getParameter("direc");
			tel=Integer.parseInt(request.getParameter("tel"));
			email=request.getParameter("email");
			if(nom.equals("") || dir.equals("") || tel==0 || email.equals("")) {
				//JOptionPane.showMessageDialog(null, "Datos del cliente faltantes");
				mensaje="Datos del cliente faltantes";
				response.sendRedirect("clientes.jsp?mensaje="+mensaje);
			}
			else {
				cl=new ClienteDTO(cedula, nom, dir, tel, email);
				cd=new ClienteDAO();
				x=cd.actualizar(cl);
				if(x) {
					//JOptionPane.showMessageDialog(null, "Datos del Cliente Actualizados");
					mensaje="Datos del Cliente Actualizados";
					response.sendRedirect("clientes.jsp?mensaje="+mensaje);
				}			
				else {
					//JOptionPane.showMessageDialog(null, "Cliente inexistente");
					mensaje="Cliente Inexistente";
					response.sendRedirect("clientes.jsp?mensaje="+mensaje);
					if(request.getParameter("ok")!=null) {
						response.sendRedirect("clientes.jsp");
					}
				}
			}
		}
		
		//BLOQUE DE CONSULTA PARTICULAR
		if(request.getParameter("btncons")!=null) {
			String mensaje;
			int doc;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			cl=new ClienteDTO(cedula);
			cd=new ClienteDAO();
			cons=cd.consultarp(cl);
			if(cons==null) {
				//JOptionPane.showMessageDialog(null, "Cliente inexistente");
				mensaje="Cliente Inexistente";
				response.sendRedirect("clientes.jsp?mensaje="+mensaje);
			}
			else {
				doc=cons.getCedula();
				nom=cons.getNombre();
				dir=cons.getDireccion();
				tel=cons.getTel();
				email=cons.getEmail();
				response.sendRedirect("clientes.jsp?cedula="+doc+"&&nombre="+nom+
						"&&direc="+dir+"&&tel="+tel+"&&email="+email+"&&h2=Listado de Clientes");
			}
		}
		
		//BLOQUE DE CONSULTA GENERAL
		String dato=request.getParameter("dat");
		if(dato!=null) {
			if(dato.equals("cliente")) {
				//JOptionPane.showMessageDialog(null, "if cliente");
				ArrayList<ClienteDTO> lista=new ArrayList<ClienteDTO>();
				cd=new ClienteDAO();
				lista=cd.consulta();
				//JOptionPane.showMessageDialog(null, lista.size());
				Gson gson=new Gson();
				pw.println(gson.toJson(lista));
			}
		}
		
		//BLOQUE DE MENSAJE
		if(request.getParameter("ok")!=null) {
			//JOptionPane.showMessageDialog(null, "entro");
			response.sendRedirect("clientes.jsp");
		}
	}

}
