package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.ProductoDAO;
import modelo.ProductoDTO;

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
		//CONSULTAR PRODUCTO
		if(request.getParameter("cons")!=null) {
			JOptionPane.showMessageDialog(null, "Dentro");			
			int codigo;
			ProductoDAO prod=new ProductoDAO();
			ProductoDTO prdto;
			ProductoDTO pdto;
			codigo=Integer.parseInt(request.getParameter("codigo"));
			prdto=new ProductoDTO(codigo);
			pdto=prod.consulta(prdto);
			if(pdto!=null) {
				int cod,nit;
				double vlr,iva,total;
				String nomprod;
				cod=pdto.getCodigo();
				nit=pdto.getNit();
				nomprod=pdto.getNomprod();
				vlr=pdto.getPrecompra();
				iva=pdto.getIva();
				total=pdto.getPrecventa();
				response.sendRedirect("productos.jsp?cod="+cod+"&&nomprod="+nomprod+"&&nit="+nit+"&&vlr="+vlr+
								"&&iva="+iva+"&&total="+total);
				}
			}
				
		//CONSULTA GENERAL
		String dato;
		dato=request.getParameter("dat");
		if(dato!=null) {
			Gson gson;
			PrintWriter pw=response.getWriter();
			ArrayList<ProductoDTO> lista=new ArrayList<ProductoDTO>();
			ProductoDAO prod=new ProductoDAO();
			if(dato.equals("prod")) {
			JOptionPane.showMessageDialog(null, "if producto");
			lista=prod.consultag();
			JOptionPane.showMessageDialog(null, lista.size());
			gson=new Gson();
			pw.println(gson.toJson(lista));
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part archivo=null;
		archivo=request.getPart("exam");
		JOptionPane.showMessageDialog(null, archivo);
		//String url="C:\\\\Users\\\\david\\\\git\\\\Proyecto-Min\\\\src\\\\main\\\\webapp\\\\documentos\\\\";
		String url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";

		//CARGAR PRODUCTO
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
						response.sendRedirect("productos.jsp");
					}
					else {
						JOptionPane.showMessageDialog(null, "Error: datos leidos invalidos");
						response.sendRedirect("productos.jsp");
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
