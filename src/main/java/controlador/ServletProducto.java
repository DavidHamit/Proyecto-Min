package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.ProductoDAO;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
@MultipartConfig
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
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
		Part archivo=null;
		JOptionPane.showMessageDialog(null, archivo);
		JOptionPane.showMessageDialog(null, request.getPart("exam"));
		archivo=request.getPart("exam");
		JOptionPane.showMessageDialog(null, archivo);
		//String url="C:\\\\Users\\\\Usuario\\\\git\\\\Proyecto-Min\\\\src\\\\main\\\\webapp\\\\documentos\\\\";
		String url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
		if(request.getParameter("btncarg")!=null) {
			if(request.getPart("exam")!=null) {
				try {
					InputStream file=archivo.getInputStream();
					File copia=new File(url+"Lineas.csv");
					FileOutputStream write=new FileOutputStream(copia);
					int num=file.read();
					while(num!=-1) {
						write.write(num);
						num=file.read();
					}
					file.close();
					write.close();
					boolean x;
					JOptionPane.showMessageDialog(null, "Se cargo archivo");
					ProductoDAO prod=new ProductoDAO();
					x=prod.cargarproduc(url+"Lineas.csv");
					if(x) {
						JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente");
					}
					else {
						JOptionPane.showMessageDialog(null, "Error: datos leidos invalidos");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: formato de archivo invalido");
					response.sendRedirect("productos.jsp");
					//JOptionPane.showMessageDialog(null, "Error: "+ex);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "ERROR: no se selecciono archivo para cargar");
				response.sendRedirect("productos.jsp");
			}
		}
	}

}
