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
import proyecto_final.clases.Usuario;
import proyecto_final.dao.ProductoDao;
import proyecto_final.dao.UserDao;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet({ "/registro", "/busqueda" })
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao dao;     
	private ProductoDao daoPro;
	
	
	
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new UserDao((Connection)getServletContext().getAttribute("conection"));
		daoPro = new ProductoDao((Connection)getServletContext().getAttribute("conection"));
	}

	public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prueba = "prueba";
		String producto = request.getParameter("buscar");
		System.out.println(producto);
		if(producto.equalsIgnoreCase("")){
		List<Producto> lista = daoPro.readProductos();
		request.setAttribute("lista", lista);
		request.setAttribute("prueba", prueba);
		request.getRequestDispatcher("Contenido/busqueda.jsp").forward(request, response);}
		else if(!producto.equalsIgnoreCase("")){
			List<Producto> lista = daoPro.getProduct(producto);
			request.setAttribute("lista", lista);
			request.setAttribute("prueba", prueba);
			request.getRequestDispatcher("Contenido/busqueda.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//nombre, apellido, contraseña, rep, email
		
		
		HttpSession session = request.getSession();
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		
		boolean correcto = dao.insertUser(nombre, apellido, email, pass);
		
		if(correcto){
			request.setAttribute("msg", "Registro realizado correctamente.");
			//request.getRequestDispatcher("Contenido/login.jsp").forward(request, response);
			response.sendRedirect("Contenido/login.jsp");
		}else{
			request.setAttribute("msg", "No se pudo insertar el usuario, intentalo mas tarde");
		}
		//request.getRequestDispatcher("vistas/registro.jsp").forward(request, response);
		
		
	}

}
