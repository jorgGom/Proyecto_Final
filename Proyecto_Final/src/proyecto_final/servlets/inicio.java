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
import javax.websocket.Session;

import proyecto_final.clases.Producto;
import proyecto_final.clases.Usuario;
import proyecto_final.dao.ProductoDao;
import proyecto_final.dao.UserDao;

/**
 * Servlet implementation class inicio
 */
@WebServlet("/inicio")
public class inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private UserDao dao;
	private ProductoDao daoPro;
    /**
     * @see HttpServlet#HttpServlet()
     */

    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new UserDao((Connection) config.getServletContext().getAttribute("conection"));
		daoPro = new ProductoDao((Connection) config.getServletContext().getAttribute("conection")); 
	}
	
    public inicio() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		HttpSession session =request.getSession();
		
		if("productosVenta".equals(page)){
			int idUser = (int) session.getAttribute("idUser");
			List<Producto> pro=daoPro.getProductUser(idUser);
			request.setAttribute("listaProductos", pro);
			request.getRequestDispatcher("Contenido/productos.jsp").forward(request, response);
			return;
		}
		else if("listaUsuarios".equals(page)){
			List<Usuario> users=dao.readUsers();
			request.setAttribute("listaUsuarios", users);
			request.getRequestDispatcher("Filtrado/listaUsuarios.jsp").forward(request, response);
			return;
			}
		
		else if("productosComprados".equals(page)){
			request.getRequestDispatcher("Contenido/productos.jsp").forward(request, response);
			return;
		}
		//response.sendRedirect("inicio?action=new");
		request.getRequestDispatcher("Filtrado/bienvenido.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Usuario> users=dao.readUsers();
		request.setAttribute("listaUsuarios", users);
		request.getRequestDispatcher("Filtrado/listaUsuarios.jsp").forward(request, response);
		
	}

}
