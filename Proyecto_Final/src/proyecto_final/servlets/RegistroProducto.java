package proyecto_final.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

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
		dao = new ProductoDao((Connection)getServletContext().getAttribute("conection"));
	}

	public RegistroProducto() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("idUser");
		String action = request.getParameter("page");
		switch(action){
			
		case ("venta"):{
			request.getRequestDispatcher("Contenido/anadirProducto.jsp").forward(request, response);
			break;
		}
		
		case ("compra"):{
			
			List<Producto> pro=dao.getProductComprar(id);
			request.setAttribute("listaProductos", pro);
			request.getRequestDispatcher("Contenido/productos.jsp").forward(request, response);
			
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//nombre, apellido, contraseña, rep, email
		
		String page = request.getParameter("page");
		
		if("venta".equals(page)){
			request.getRequestDispatcher("Contenido/anadirProducto.jsp").forward(request, response);
		}
		else{
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("userName"));
		int id = (int) session.getAttribute("idUser");
		System.out.println(id);
		String nombre = request.getParameter("nombrePro");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		
		
		
		
		boolean correcto = dao.insertProduct(0, nombre, descripcion, precio, 0,id, 0);
		
		if(correcto){
			request.setAttribute("msg", "Registro realizado correctamente.");
			response.sendRedirect("/Proyecto_Final/Filtrado/bienvenido.jsp");
		}else{
			request.setAttribute("msg", "No se pudo insertar el usuario, intentalo mas tarde");
		}
		//request.getRequestDispatcher("vistas/registro.jsp").forward(request, response);
		
		}
	}

}
