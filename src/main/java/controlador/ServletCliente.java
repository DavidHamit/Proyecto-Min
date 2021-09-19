package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
		int cedula,tel;
		String nom,dir,email;
		
		//BLOQUE DE INSERTAR
		if(request.getParameter("btnins")!=null) {
			int x;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			nom=request.getParameter("nombre");
			dir=request.getParameter("direc");
			tel=Integer.parseInt(request.getParameter("tel"));
			email=request.getParameter("email");
			cl=new ClienteDTO(cedula, nom, dir, tel, email);
			cd=new ClienteDAO();
			x=cd.insertar(cl);
			if(x!=0) {
				JOptionPane.showMessageDialog(null, "Cliente Creado");
				response.sendRedirect("clientes.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al crear");
				response.sendRedirect("clientes.jsp");
			}
		}
		
		//BLOQUE DE ELIMINAR
		if(request.getParameter("btneli")!=null) {
			String y;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			cl=new ClienteDTO(cedula);
			cd=new ClienteDAO();
			y=cd.eliminar(cl);
			if(y.equals("y")) {
				JOptionPane.showMessageDialog(null, "Datos del Cliente Borrados");
				response.sendRedirect("clientes.jsp");
			}
			else
				if(y.equals("n")) {
					JOptionPane.showMessageDialog(null, "Cliente inexistente");
					response.sendRedirect("clientes.jsp");
				}
		}
		
		//BLOQUE DE ACTUALIZAR
		if(request.getParameter("btnact")!=null) {
			boolean x;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			nom=request.getParameter("nombre");
			dir=request.getParameter("direc");
			tel=Integer.parseInt(request.getParameter("tel"));
			email=request.getParameter("email");
			cl=new ClienteDTO(cedula, nom, dir, tel, email);
			cd=new ClienteDAO();
			x=cd.actualizar(cl);
			if(x) {
				JOptionPane.showMessageDialog(null, "Datos del Cliente Actualizados");
				response.sendRedirect("clientes.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Cliente inexistente");
				response.sendRedirect("clientes.jsp");
			}
		}
		
		//BLOQUE DE CONSULTA PARTICULAR
		if(request.getParameter("btncons")!=null) {
			int doc;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			cl=new ClienteDTO(cedula);
			cd=new ClienteDAO();
			cons=cd.consultarp(cl);
			if(cons==null) {
				JOptionPane.showMessageDialog(null, "Cliente inexistente");
				response.sendRedirect("clientes.jsp");
			}
			else {
				doc=cons.getCedula();
				nom=cons.getNombre();
				dir=cons.getDireccion();
				tel=cons.getTel();
				email=cons.getEmail();
				response.sendRedirect("tablac.jsp?cedula="+doc+"&&nombre="+nom+
						"&&direc="+dir+"&&tel="+tel+"&&email="+email);
			}
		}
	}

}
