package proyecto_final.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.List;

import proyecto_final.clases.Usuario;
import proyecto_final.dao.UserDao;

/**
 * Servlet implementation class AutenticadorServlet
 */
@WebServlet({ "/login", "/home" })
public class AutenticadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new UserDao((Connection) config.getServletContext().getAttribute("conection"));
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutenticadorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		String accion=request.getParameter("accion");
		if ("salir".equals(accion)) {
			session.invalidate();
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newName = request.getParameter("nombre");
		String newPass = request.getParameter("pass");
		HttpSession session = request.getSession();
		Usuario user = dao.validateUser(newName, newPass);

		if (user == null) {
			request.getRequestDispatcher("Contenido/error.jsp").forward(request, response);


		} 
		else if (user != null) {
			if ("admin".equalsIgnoreCase(newName) && "admin".equalsIgnoreCase(newPass)) {
				session.setAttribute("userName", newName);
				session.setAttribute("usuario", user);
				String formulario = null;
				session.setAttribute("formulario", formulario);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Filtrado/bienvenido.jsp");
				dispatcher.forward(request, response);

			}else{
			int idUser = user.getIdusuario();
			session.setAttribute("userName", newName);
			session.setAttribute("usuario", user);
			session.setAttribute("idUser", idUser);
			System.out.println(idUser);
			List<Usuario> users=dao.readUsers();
			request.setAttribute("listaUsuarios", users);
			request.getRequestDispatcher("Filtrado/bienvenido.jsp").forward(request, response);
			}
	
		}
	}

}
