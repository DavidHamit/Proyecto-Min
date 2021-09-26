package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
		if(request.getParameter("btnacep")!=null) {
			usuario=request.getParameter("usu");
			password=request.getParameter("pass");
			lg=new LoginDAO();
			lista=lg.login();
			for(int i=0; i<lista.size(); i++) {
				ld=lista.get(i);
				if(ld.getUsuario().equals(usuario) && ld.getPassword().equals(password)) {
					x=1;
					response.sendRedirect("menu.jsp");
				}
			}
			if(x==0) {
				JOptionPane.showMessageDialog(null, "Error en usuario y/o contraseña");
				response.sendRedirect("index.jsp");
			}
			/*if(usuario.equals("admininicial") && password.equals("admin123456")) {
				response.sendRedirect("menu.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error en usuario y/o contraseña");
				response.sendRedirect("index.jsp");
			}*/
		}
		else
			if(request.getParameter("btncan")!=null){
			JOptionPane.showMessageDialog(null, "Fin del programa");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
