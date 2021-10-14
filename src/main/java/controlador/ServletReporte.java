package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.ProveedorDAO;
import modelo.ProveedorDTO;
import modelo.UsuarioDAO;
import modelo.UsuarioDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;

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
		//CONSULTA DE NOMBRES DE CLIENTE
		Gson gson;
		PrintWriter pw=response.getWriter();
		String name;
		name=request.getParameter("dat");
		if(name!=null) {
			if(name.equals("nom")) {
				ArrayList<VentasDTO> lista=new ArrayList<VentasDTO>();
				ArrayList<ClienteDTO> nombres=new ArrayList<ClienteDTO>();
				VentasDAO ven=new VentasDAO();
				VentasDTO vto;
				ClienteDAO cli=new ClienteDAO();
				ClienteDTO cto;
				ClienteDTO cdto;
				int ced;
				String nom;
				double sumven=0, vlr;
				HttpSession sesion=request.getSession();
				lista=ven.consulta();
				for(int i=0; i<lista.size(); i++) {
					vto=lista.get(i);
					ced=vto.getCedcli();
					vlr=vto.getTotal();
					sumven+=vlr;
					cto=new ClienteDTO(ced);
					cdto=cli.consultarp(cto);
					nom=cdto.getNombre();
					JOptionPane.showMessageDialog(null, nom);
					nombres.add(cdto);
				}
				sesion.setAttribute("suma", sumven);
				gson=new Gson();
				pw.println(gson.toJson(nombres));
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession titulo=request.getSession();
		//ELECCION DE LISTADO
		if(request.getParameter("cliente")!=null) {
			JOptionPane.showMessageDialog(null, "if cliente");
			titulo.setAttribute("h2", "Listado de Clientes");
			response.sendRedirect("tablac.jsp");
		}
		else
			if(request.getParameter("usuario")!=null) {
				JOptionPane.showMessageDialog(null, "if usuario");
				titulo.setAttribute("h2", "Listado de Usuarios");
				response.sendRedirect("tablau.jsp");
			}
			else
				if(request.getParameter("ventas")!=null) {
					JOptionPane.showMessageDialog(null, "if ventas");
					titulo.setAttribute("h2", "Listado de Ventas");
					response.sendRedirect("tablav.jsp");
				}
				else
					if(request.getParameter("proveedores")!=null) {
						JOptionPane.showMessageDialog(null, "if proveedores");
						titulo.setAttribute("h2", "Consulta de Proveedores");
						response.sendRedirect("tablap.jsp");
					}
					else
						if(request.getParameter("producto")!=null) {
							JOptionPane.showMessageDialog(null, "if producto");
							titulo.setAttribute("h2", "Listado de Productos");
							response.sendRedirect("tablaprod.jsp");
						}
		String opc;
		opc=request.getParameter("dato");
		if(opc!=null) {
			Gson gson;
			PrintWriter pw=response.getWriter();
			opc=request.getParameter("dato");
			
			//CONSULTA GENERAL DE CLIENTES
			if(opc.equals("cli")) {
				ClienteDAO cl=new ClienteDAO();
				ArrayList<ClienteDTO> lista=new ArrayList<ClienteDTO>();
				lista=cl.consulta();
				JOptionPane.showMessageDialog(null, lista.size());
				if(lista!=null) {
					gson=new Gson();
					pw.println(gson.toJson(lista));
				}
				else {
					JOptionPane.showMessageDialog(null, "No existe ningun cliente");
					response.sendRedirect("tablaprod.jsp");
				}
			}
			
			//CONSULTA GENERAL DE USUARIOS
			if(opc.equals("usu")) {
				UsuarioDAO usdao=new UsuarioDAO();
				ArrayList<UsuarioDTO> lista=new ArrayList<UsuarioDTO>();
				lista=usdao.consultar();
				JOptionPane.showMessageDialog(null, lista.size());
				if(lista!=null) {
					gson=new Gson();
					pw.println(gson.toJson(lista));
				}
				else {
					JOptionPane.showMessageDialog(null, "No existe ningun usuario");
					response.sendRedirect("tablaprod.jsp");
				}
			}
			
			//CONSULTA GENERAL DE PROVEEDORES
			if(opc.equals("prov")) {
				ProveedorDAO pdao=new ProveedorDAO();
				ArrayList<ProveedorDTO> lista=new ArrayList<ProveedorDTO>();
				lista=pdao.consulta();
				JOptionPane.showMessageDialog(null, lista.size());
				if(lista!=null) {
					gson=new Gson();
					pw.println(gson.toJson(lista));
				}
				else {
					JOptionPane.showMessageDialog(null, "No existe ningun proveedor");
					response.sendRedirect("tablaprod.jsp");
				}
			}
			
			//CONSULTA GENERAL DE VENTAS
			if(opc.equals("ven")) {
				ArrayList<VentasDTO> lista=new ArrayList<VentasDTO>();
				ArrayList<String> nombres=new ArrayList<String>();
				VentasDAO ven=new VentasDAO();
				VentasDTO vto;
				ClienteDAO cli=new ClienteDAO();
				ClienteDTO cto;
				ClienteDTO cdto;
				int ced;
				String nom;
				double sumven=0, vlr;
				HttpSession sesion=request.getSession();
				lista=ven.consulta();
				for(int i=0; i<lista.size(); i++) {
					vto=lista.get(i);
					ced=vto.getCedcli();
					vlr=vto.getTotal();
					sumven+=vlr;
					cto=new ClienteDTO(ced);
					cdto=cli.consultarp(cto);
					nom=cdto.getNombre();
					nombres.add(nom);
				}
				sesion.setAttribute("suma", sumven);
				if(lista!=null) {
					gson=new Gson();
					pw.println(gson.toJson(lista));
				}
				else {
					JOptionPane.showMessageDialog(null, "No existe ninguna venta");
					response.sendRedirect("tablaprod.jsp");
				}
			}
			
			//CONSULTA GENERAL DE PRODUCTOS
			if(opc.equals("prod")) {
				ArrayList<ProductoDTO> lista=new ArrayList<ProductoDTO>();
				ProductoDAO prod=new ProductoDAO();
				lista=prod.consultag();
				JOptionPane.showMessageDialog(null, lista.size());
				if(lista!=null) {
					gson=new Gson();
					pw.println(gson.toJson(lista));
				}
				else {
					JOptionPane.showMessageDialog(null, "No existe ningun producto");
					response.sendRedirect("tablaprod.jsp");
				}
			}
		}
		
		//VOLVER
		if(request.getParameter("back")!=null){
			JOptionPane.showMessageDialog(null, "Back");
			response.sendRedirect("reportes.jsp");
		}
		else
			//CONSULTA PARTICULAR DE CLIENTE
			if(request.getParameter("cedula")!=null) {
				int doc,tel;
				String nom,dir,email;
				JOptionPane.showMessageDialog(null, "Consulta");
				int cedula;
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
							"&&direc="+dir+"&&tel="+tel+"&&email="+email+"&&h2=Listado de Clientes");
				}
			}
			else
				//CONSULTA PARTICULAR DE VENTA
				if(request.getParameter("codven")!=null){
					HttpSession sesion=request.getSession();
					VentasDTO vto;
					VentasDTO vdto;
					VentasDAO ven=new VentasDAO();
					ClienteDAO cli=new ClienteDAO();
					ClienteDTO cto;
					ClienteDTO cdto;
					int cod,ced;
					String nom;
					double sumven, vlr;
					cod=Integer.parseInt(request.getParameter("codven"));
					vto=new VentasDTO(cod);
					vdto=ven.consultaced(vto);
					if(vdto!=null) {
						vlr=vdto.getTotal();
						ced=vdto.getCedcli();
						cto=new ClienteDTO(ced);
						cdto=cli.consultarp(cto);
						nom=cdto.getNombre();
						sumven=vlr;
						sesion.setAttribute("suma", sumven);
						response.sendRedirect("tablav.jsp?vlr="+vlr+"&&ced="+ced+"&&nom="+nom+"&&sum="+sumven+
								"&&h2=Listado de Ventas");
					}
					else {
						JOptionPane.showMessageDialog(null, "No existe esa venta");
						response.sendRedirect("tablav.jsp");
					}
				}
				else
					//CONSULTA PARTICULAR DE USUARIO
					if(request.getParameter("cedusu")!=null) {
						int doc;
						String nom,email,usu,pass;
						JOptionPane.showMessageDialog(null, "Consulta Usu");
						int cedula;
						UsuarioDTO usdto ;
						UsuarioDAO us=new UsuarioDAO();
						UsuarioDTO dto;
						cedula=Integer.parseInt(request.getParameter("cedusu"));
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
									"&&correo="+email+"&&usu="+usu+"&&pass="+pass+"&&h2=Listado de Usuarios");
						}
					}
					else
						//CONSULTA PARTICULAR DE PROVEEDOR
						if(request.getParameter("nitpr")!=null) {
							int nit,tel;
							String nom,dir,ciu;
							JOptionPane.showMessageDialog(null, "Consultapp");
							int nitpr;
							ProveedorDTO pdto;
							ProveedorDAO pdao=new ProveedorDAO();
							ProveedorDTO pconp;
							nitpr=Integer.parseInt(request.getParameter("nitpr"));
							pdto=new ProveedorDTO(nitpr);
							pconp=pdao.consultar(pdto);
							if(pconp==null) {
								JOptionPane.showMessageDialog(null, "Proveedor NO existe en la base de datos");
								response.sendRedirect("tablap.jsp");
							}
							else {
								nit=pconp.getNit();
								nom=pconp.getNom();
								dir=pconp.getDir();
								tel=pconp.getTel();
								ciu=pconp.getCiudad();
								response.sendRedirect("tablap.jsp?nitpr="+nit+"&&nompr="+nom+
										"&&dirpr="+dir+"&&telpr="+tel+"&&ciupr="+ciu+"&&h2=Listado de Proveedores");
							}
						}
						else
							//CONSULTA PARTICULAR DE PRODUCTOS
							if(request.getParameter("codprod")!=null){
								int cod,nit,codigo;
								String nomprod;
								double iva,prec,venta;
								JOptionPane.showMessageDialog(null, "Consulta Producto");
								ProductoDAO prod=new ProductoDAO();
								ProductoDTO pdto;
								ProductoDTO dto;
								cod=Integer.parseInt(request.getParameter("codprod"));
								pdto=new ProductoDTO(cod);
								dto=prod.consulta(pdto);
								if(dto!=null) {
									codigo=dto.getCodigo();
									nit=dto.getNit();
									nomprod=dto.getNomprod();
									iva=dto.getIva();
									prec=dto.getPrecompra();
									venta=dto.getPrecventa();
									response.sendRedirect("tablaprod.jsp?codigo="+codigo+"&&nit="+nit+"&&nomprod="+nomprod+
											"&&iva="+iva+"&&prec="+prec+"&&venta="+venta);
								}
								else {
									JOptionPane.showMessageDialog(null, "No existe ese producto");
									response.sendRedirect("tablaprod.jsp");
								}
							}
	}
}

