package proyecto_final.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proyecto_final.dao.UserDao;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao dao;
       
	
	
	
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new UserDao((Connection)getServletContext().getAttribute("conection"));
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			response.sendRedirect("inicio");
		}else{
			request.setAttribute("msg", "No se pudo insertar el usuario, intentalo mas tarde");
		}
		//request.getRequestDispatcher("vistas/registro.jsp").forward(request, response);
		
		
	}

}
