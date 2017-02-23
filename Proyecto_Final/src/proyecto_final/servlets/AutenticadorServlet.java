package proyecto_final.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AutenticadorServlet
 */
//@WebServlet("/AutenticadorServlet")
public class AutenticadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticadorServlet() {
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
		String newName = request.getParameter("mail");
		String newPass = request.getParameter("pass");
		
		if("prueba".equalsIgnoreCase(newName) && "1234".equalsIgnoreCase(newPass)){
			HttpSession session = request.getSession();
			session.setAttribute("userName", newName);
			session.setAttribute("newPass", newPass);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Contenido/bienvenido.jsp");
			dispatcher.forward(request, response);
		}
	}

}
