package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;

/**
 * Servlet implementation class ServletVentas
 */
@WebServlet("/ServletVentas")
public class ServletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       double iva1,iva2,iva3;
       int cant1,cant2,cant3;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVentas() {
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
		HttpSession sesion=request.getSession();
		double prec1,prec2,prec3,vlr1,vlr2,vlr3,tsv,tiva,total;
		double tiva1,tiva2,tiva3;
		//CONSULTAR NOMBRE DEL CLIENTE
		if(request.getParameter("cedcli")!=null) {
			JOptionPane.showMessageDialog(null, "En if");
			int cedula;
			ClienteDTO clidto;
			ClienteDAO cli;
			ClienteDTO lista;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			clidto=new ClienteDTO(cedula);
			cli=new ClienteDAO();
			lista=cli.consultarp(clidto);
			sesion.setAttribute("cliente", lista);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
		}
		
		//CONSULTAR NOMBRE DEL PRODUCTO
		if(request.getParameter("cons1")!=null) {
			int codigo;
			ProductoDTO prodto;
			ProductoDAO prod=new ProductoDAO();
			ProductoDTO listaprod1;
			codigo=Integer.parseInt(request.getParameter("codigo1"));
			prodto=new ProductoDTO(codigo);
			listaprod1=prod.consulta(prodto);
			iva1=listaprod1.getIva();
			sesion.setAttribute("prod1", listaprod1);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
		}
		
		if(request.getParameter("cons2")!=null) {
			int codigo;
			ProductoDTO prodto;
			ProductoDAO prod=new ProductoDAO();
			ProductoDTO listaprod2;
			codigo=Integer.parseInt(request.getParameter("codigo2"));
			prodto=new ProductoDTO(codigo);
			listaprod2=prod.consulta(prodto);
			iva2=listaprod2.getIva();
			sesion.setAttribute("prod2", listaprod2);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
		}
		
		if(request.getParameter("cons3")!=null) {
			int codigo;
			ProductoDAO prod=new ProductoDAO();
			ProductoDTO prodto;
			ProductoDTO listaprod3;
			codigo=Integer.parseInt(request.getParameter("codigo3"));
			prodto=new ProductoDTO(codigo);
			listaprod3=prod.consulta(prodto);
			iva3=listaprod3.getIva();
			sesion.setAttribute("prod3", listaprod3);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
		}
		
		//CALCULO DE PRECIO DEL PRODUCTO
		if(request.getParameter("enviar")!=null) {
			prec1=Double.parseDouble(request.getParameter("precio1"));
			prec2=Double.parseDouble(request.getParameter("precio2"));
			prec3=Double.parseDouble(request.getParameter("precio3"));
			
			cant1=Integer.parseInt(request.getParameter("cant1"));
			cant2=Integer.parseInt(request.getParameter("cant2"));
			cant3=Integer.parseInt(request.getParameter("cant3"));
			
			
			
			vlr1=cant1*prec1;
			vlr2=cant2*prec2;
			vlr3=cant3*prec3;
			tsv=vlr1+vlr2+vlr3;
			tiva1=(vlr1*iva1)/100;
			tiva2=(vlr2*iva2)/100;
			tiva3=(vlr3*iva3)/100;
			tiva=tiva1+tiva2+tiva3;
			total=tsv+tiva;
			
			//REGISTRO DE VENTA
			int i=JOptionPane.showConfirmDialog(null, "Art1: $"+vlr1+"\nArt2: $"+vlr2+"\nArt3: $"+vlr3+"\nIVA 1: $"+tiva1+"\nIVA 2: $"+
					tiva2+"\nIVA 3: $"+tiva3+"\nTotal sin IVA: $"+tsv+"\nTotal IVA: $"+tiva+"\nTotal a pagar: $"+total);
			
			if(i==0) {
				VentasDTO vdto;
				VentasDAO ven=new VentasDAO();
				int cedcli, cedusu, x;
				double iva,tsiva,totalv;
				cedcli=Integer.parseInt(request.getParameter("cedula"));
				cedusu=Integer.parseInt(request.getParameter("cedusu"));
				iva=tiva;
				tsiva=tsv;
				totalv=total;
				vdto=new VentasDTO(cedcli,cedusu,iva,tsiva,totalv);
				x=ven.registrar(vdto);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Venta Registrada");
					
					//DETALLE DE VENTAS
					int cant,codprod,codventa;
					double iv,psv,pago;
					boolean result;
					VentasDTO vendto;
					VentasDAO vent=new VentasDAO();
					vendto=vent.consultacodigo();
					
					}
				
				else {
					JOptionPane.showMessageDialog(null, "No se registro la venta");
					response.sendRedirect("ventas.jsp");
				}
			}
			else
				if(i==1) {
					JOptionPane.showMessageDialog(null, "Venta NO registrada");
					response.sendRedirect("ventas.jsp");
				}
				else {
					JOptionPane.showMessageDialog(null, "Venta cancelada");
					response.sendRedirect("ventas.jsp");
				}
		}
	}

}
