package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class ServletGestion
 */
@WebServlet("/ServletGestion")
public class ServletGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestion() {
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
		UsuarioDTO udto;
		UsuarioDTO cons;
		UsuarioDAO us;
		String nom,email,usu,pass;
		int doc;
		//long doc;
		boolean y;
		//BLOQUE DE INSERTAR
		if(request.getParameter("btnins")!=null) {
			doc=Integer.parseInt(request.getParameter("cedula"));
			nom=request.getParameter("nombre");
			email=request.getParameter("correo");
			usu=request.getParameter("usu");
			pass=request.getParameter("pass");
			if(nom=="" || email=="" || usu=="" || pass=="") {
				JOptionPane.showMessageDialog(null, "Faltan datos del usuario");
				response.sendRedirect("usuarios.jsp");
			}
			else{
				udto=new UsuarioDTO(doc,nom,email,usu,pass);
				us=new UsuarioDAO();
				y=us.insertar(udto);
				if(y) {
					JOptionPane.showMessageDialog(null, "Usuario Creado");
					response.sendRedirect("usuarios.jsp");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al crear usuario");
					response.sendRedirect("usuarios.jsp");
				}
			}
		}
		
		//BLOQUE DE ELIMINAR
		if(request.getParameter("btneli")!=null) {
			doc=Integer.parseInt(request.getParameter("cedula"));
			udto=new UsuarioDTO(doc);
			us=new UsuarioDAO();
			y=us.eliminar(udto);
			if(y) {
				JOptionPane.showMessageDialog(null, "Datos del Usuario Borrados");
				response.sendRedirect("usuarios.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al eliminar");
				response.sendRedirect("usuarios.jsp");
			}
		}
		
		//BLOQUE DE CONSULTA PARTICULAR
		if(request.getParameter("btncons")!=null) {
			int cedu;
			doc=Integer.parseInt(request.getParameter("cedula"));
			udto=new UsuarioDTO(doc);
			us=new UsuarioDAO();
			cons=us.consultapar(udto);
			if(cons.getNombre().equals(null)) {
				JOptionPane.showMessageDialog(null, "Usuario inexistente");
				response.sendRedirect("usuarios.jsp");
			}
			else {
				cedu=cons.getCedula();
				nom=cons.getNombre();
				email=cons.getCorreo();
				usu=cons.getUsuario();
				pass=cons.getPassword();
				response.sendRedirect("tabla.jsp?cedula="+cedu+"&&nombre="+nom+
						"&&correo="+email+"&&usu="+usu+"pass="+pass);
			}
		}
		
		//BLOQUE DE ACTUALIZAR
		if(request.getParameter("btnact")!=null) {
			int x;
			doc=Integer.parseInt(request.getParameter("cedula"));
			nom=request.getParameter("nombre");
			email=request.getParameter("correo");
			usu=request.getParameter("usu");
			pass=request.getParameter("pass");
			udto=new UsuarioDTO(doc, nom, email, usu, pass);
			us=new UsuarioDAO();
			x=us.actualizar(udto);
			if(x!=0) {
				JOptionPane.showMessageDialog(null, "Usuario actualizado");
				response.sendRedirect("usuarios.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al actualizar");
				response.sendRedirect("usuarios.jsp");
			}
		}
	}

}
