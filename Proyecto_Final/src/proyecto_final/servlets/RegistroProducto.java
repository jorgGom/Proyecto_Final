package proyecto_final.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proyecto_final.clases.Producto;
import proyecto_final.dao.ProductoDao;

/**
 * Servlet implementation class RegistroProducto
 */
@WebServlet("/RegistroProducto")
public class RegistroProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductoDao dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new ProductoDao((Connection) getServletContext().getAttribute("conection"));
	}

	public RegistroProducto() {
		super();
		// TODO Auto-generated constructor stub

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = request.getParameter("page");
		switch (action) {

		case ("venta"): {
			request.getRequestDispatcher("Contenido/anadirProducto.jsp").forward(request, response);
			break;
		}

		case ("compra"): {
			int idUser = (int) session.getAttribute("idUser");
			System.out.println(idUser + "comprobacion");
			List<Producto> pro = dao.getProductComprar(idUser);
			request.setAttribute("listaProductos", pro);
			request.getRequestDispatcher("Contenido/productos.jsp").forward(request, response);
			break;
		}
		case ("modificar"): {
			String idModS = request.getParameter("idPro");
			int idMod = Integer.parseInt(idModS);
			session.setAttribute("idMod", idMod);
			session.removeAttribute("formulario");
			String formulario = "form";
			session.setAttribute("formulario", formulario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("inicio?page=productosVenta");
			dispatcher.forward(request, response);

			break;
		}
		case ("eliminar"): {
			String idP = request.getParameter("idPro");
			int idPro = Integer.parseInt(idP);
			dao.deleteProducto(idPro);
			RequestDispatcher dispatcher = request.getRequestDispatcher("inicio?page=productosVenta");
			dispatcher.forward(request, response);

			break;
		}
		case ("comprar"): {
			String idP = request.getParameter("idPro");
			int idPro = Integer.parseInt(idP);
			int idComp = (int) session.getAttribute("idUser");
			dao.comprarProducto(idPro, idComp);
			response.sendRedirect("inicio?page=productosComprados");
		}
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// nombre, apellido, contraseña, rep, email

		String page = request.getParameter("page");
		if("modProducto".equals(page)){
			
			HttpSession session =request.getSession();
			int idPro = (int) session.getAttribute("idMod");
			String nombre=request.getParameter("nom");
			String descripcion=request.getParameter("desc").trim();
			String precio=request.getParameter("pre");
			session.removeAttribute("formulario");
			System.out.println("Datos llegados " + idPro + " " + nombre + " " + descripcion + " " + precio);
			dao.modProduct(idPro, nombre, descripcion, precio);
			
			response.sendRedirect("inicio?page=productosVenta");
		}

		else if ("venta".equals(page)) {
			request.getRequestDispatcher("Contenido/anadirProducto.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			System.out.println(session.getAttribute("userName"));
			int id = (int) session.getAttribute("idUser");
			System.out.println(id);
			String nombre = request.getParameter("nombrePro");
			String descripcion = request.getParameter("descripcion");
			String precio = request.getParameter("precio");

			boolean correcto = dao.insertProduct(0, nombre, descripcion, precio, 0, id, 0);

			if (correcto) {
				request.setAttribute("msg", "Registro realizado correctamente.");
				response.sendRedirect("inicio?page=productosVenta");
			} else {
				request.setAttribute("msg", "No se pudo insertar el usuario, intentalo mas tarde");
			}
			// request.getRequestDispatcher("vistas/registro.jsp").forward(request,
			// response);

		}
	}

}
