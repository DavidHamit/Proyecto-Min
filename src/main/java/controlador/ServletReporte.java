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

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class ServletReporte
 */
@WebServlet("/ServletReporte")
public class ServletReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReporte() {
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
		if(request.getParameter("cliente")!=null) {
			JOptionPane.showMessageDialog(null, "if cliente");
			response.sendRedirect("tablac.jsp?h2=Listado de Clientes");
		}
		else
			if(request.getParameter("usuario")!=null) {
				JOptionPane.showMessageDialog(null, "if usuario");
				response.sendRedirect("tablau.jsp?h2=Listado de Usuarios");
			}
			else
				if(request.getParameter("ventas")!=null) {
					JOptionPane.showMessageDialog(null, "if ventas");
					response.sendRedirect("tablac.jsp?h2=Listado de Ventas");
				}
		String opc;
		opc=request.getParameter("dato");
		Gson gson;
		PrintWriter pw=response.getWriter();
		if(opc!=null) {
			opc=request.getParameter("dato");
			if(opc.equals("cli")) {
				ClienteDAO cl=new ClienteDAO();
				ArrayList<ClienteDTO> lista=new ArrayList<ClienteDTO>();
				lista=cl.consulta();
				JOptionPane.showMessageDialog(null, lista.size());
				gson=new Gson();
				pw.println(gson.toJson(lista));
			}
			if(opc.equals("usu")) {
				UsuarioDAO usdao=new UsuarioDAO();
				ArrayList<UsuarioDTO> lista=new ArrayList<UsuarioDTO>();
				lista=usdao.consultar();
				JOptionPane.showMessageDialog(null, lista.size());
				gson=new Gson();
				pw.println(gson.toJson(lista));
			}
		}
		if(request.getParameter("back")!=null){
			JOptionPane.showMessageDialog(null, "Back");
			response.sendRedirect("reportes.jsp");
		}
		//else
		if (request.getParameter("consc")!=null) {
			if(request.getParameter("cedula")!=null) {
				int doc,tel;
				String nom,dir,email;
				JOptionPane.showMessageDialog(null, "Consulta");int cedula;
				ClienteDTO cldto;
				ClienteDAO cli=new ClienteDAO();
				ClienteDTO dto;
				cedula=Integer.parseInt(request.getParameter("cedula"));
				cldto=new ClienteDTO(cedula);
				dto=cli.consultarp(cldto);
				if(dto==null) {
					JOptionPane.showMessageDialog(null, "Cliente Inexistente");
					response.sendRedirect("tablac.jsp");
				}
		
				else {
					doc=dto.getCedula();
					nom=dto.getNombre();
					dir=dto.getDireccion();
					tel=dto.getTel();
					email=dto.getEmail();
					response.sendRedirect("tablac.jsp?cedula="+doc+"&&nombre="+nom+
							"&&direc="+dir+"&&tel="+tel+"&&email="+email);
				}
			}
		}
			
			else {
				if(request.getParameter("cedula")!=null) {
					int doc;
					String nom,email,usu,pass;
					JOptionPane.showMessageDialog(null, "Consulta Usu");int cedula;
					UsuarioDTO usdto ;
					UsuarioDAO us=new UsuarioDAO();
					UsuarioDTO dto;
					cedula=Integer.parseInt(request.getParameter("cedula"));
					usdto=new UsuarioDTO(cedula);
					dto=us.consultapar(usdto);
					if(dto==null) {
						JOptionPane.showMessageDialog(null, "Usuario Inexistente");
						response.sendRedirect("tablau.jsp");
					}
			
					else {
						doc=dto.getCedula();
						nom=dto.getNombre();
						email=dto.getCorreo();
						usu=dto.getUsuario();
						pass=dto.getPassword();
						
						
						response.sendRedirect("tablau.jsp?cedula="+doc+"&&nombre="+nom+
								"&&correo="+email+"&&usu="+usu+"&&pass="+pass);
					}
				
			//}
		
			
	}

}
	}}

