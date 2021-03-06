package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.JOptionPane;

import modelo.LoginDAO;
import modelo.LoginDTO;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario,password;
		LoginDTO ld;
		LoginDAO lg;
		int x=0;
		ArrayList<LoginDTO> lista=new ArrayList<>();
		HttpSession sesion=request.getSession();
		String mensaje;
		if(request.getParameter("btnacep")!=null) {
			usuario=request.getParameter("usu");
			password=request.getParameter("pass");
			lg=new LoginDAO();
			lista=lg.login();
			if(lista!=null) {
				for(int i=0; i<lista.size(); i++) {
					ld=lista.get(i);
					if(ld.getUsuario().equals(usuario) && ld.getPassword().equals(password)) {
						x=1;
						sesion.setAttribute("usu", ld);
						response.sendRedirect("menu.jsp");
					}
				}
				if(x==0) {
					//JOptionPane.showMessageDialog(null, "Error en usuario y/o contraseņa");
					mensaje="Error en usuario y/o contraseņa";
					response.sendRedirect("index.jsp?mensaje="+mensaje);
				}
			}
			else {
				if(usuario.equals("admininicial") && password.equals("admin123456")) {
					response.sendRedirect("menu.jsp");
				}
				else {
					//JOptionPane.showMessageDialog(null, "Error en usuario y/o contraseņa");
					mensaje="Error en usuario y/o contraseņa";
					response.sendRedirect("index.jsp?mensaje="+mensaje);
				}
			}
		}
		else
			if(request.getParameter("btncan")!=null){
				//JOptionPane.showMessageDialog(null, "Fin del programa");
				sesion.setAttribute("z", "1");
				mensaje="Fin del programa";
				response.sendRedirect("index.jsp?mensaje="+mensaje);
		}
		
		//BLOQUE DE MENSAJE
		if(request.getParameter("ok")!=null) {
			String z=(String)sesion.getAttribute("z");
			if(z.equals("1")) {
				
			}
			else {
				response.sendRedirect("index.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
