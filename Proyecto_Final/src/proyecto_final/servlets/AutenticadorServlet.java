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

import com.mysql.jdbc.Connection;

import proyecto_final.clases.Usuario;
import proyecto_final.dao.UserDao;

/**
 * Servlet implementation class AutenticadorServlet
 */
@WebServlet({"/login","/home"})
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newName = request.getParameter("mail");
		String newPass = request.getParameter("pass");
		HttpSession session = request.getSession();
		//Usuario user = dao.validateUser(newName, newPass);
		
		if("admin".equalsIgnoreCase(newName) && "admin".equalsIgnoreCase(newPass)){
			
			session.setAttribute("userName", newName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Admin");
			dispatcher.forward(request, response);
			
		}
		
		//else if(user!=null){
			//session.setAttribute("usuario", user);
		//}
		
		else if("calvazo".equalsIgnoreCase(newName) && "1234".equalsIgnoreCase(newPass)){
			session.setAttribute("userName", newName);
			response.sendRedirect("inicio");
			
		}
		else{
			request.getRequestDispatcher("Contenido/error.jsp").forward(request,response);
			
		}
	}

}
