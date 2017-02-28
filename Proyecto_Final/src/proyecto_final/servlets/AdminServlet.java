package proyecto_final.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.sql.*;

import proyecto_final.clases.Usuario;
import proyecto_final.dao.UserDao;
/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao dao;
	
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Proyecto_Final/Filtrado/bienvenido.jsp").forward(request, response);
		HttpSession session =request.getSession();
		String accion=request.getParameter("accion");
		
		if("modificar".equals(accion)){
			int id=(int) session.getAttribute(accion);
			request.setAttribute("idUser", id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Filtrado/listaUsuarios.jsp");
			dispatcher.forward(request, response);
		}
		else if("eliminar".equals(accion)){
			int id=(int) session.getAttribute(accion);
			request.setAttribute("idUser", id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Filtrado/listaUsuarios.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Filtrado/bienvenido.jsp").forward(request, response);
		
		String action=request.getParameter("action");
		
		if (action.equals("eliminar")){
			try {
				String id=request.getParameter("id");
				dao.deleteUser(Integer.parseInt(id));
				
				List<Usuario> users=dao.readUsers();
				request.setAttribute("ListUsuarios", users);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Filtrado/listaUsuarios.jsp");
				dispatcher.forward(request, response);
				
			} catch (Exception e) {
				response.sendRedirect("inicio");
			}
			
			
			
			

		} 
			
	}

}
