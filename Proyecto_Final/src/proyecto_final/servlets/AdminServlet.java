package proyecto_final.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
	private Usuario user;
	
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new UserDao((Connection) config.getServletContext().getAttribute("conection"));
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		String accion=request.getParameter("accion");
		
		if("modificar".equals(accion)){
			
			
		String idModS = request.getParameter("id");
		int idMod = Integer.parseInt(idModS);
		session.setAttribute("idMod", idMod);
		session.removeAttribute("formulario");
		String formulario = "form";
		session.setAttribute("formulario", formulario );
		RequestDispatcher dispatcher = request.getRequestDispatcher("inicio?page=listaUsuarios");
		dispatcher.forward(request, response);
		
		
		
			
			
			
			/*String idS=request.getParameter("id");
			int id = Integer.parseInt(idS);
			String nombre=request.getParameter("nom");
			String apellido=request.getParameter("ape");
			String email=request.getParameter("mail");
			String password=request.getParameter("pass");
			System.out.println("Llegan los parametros "+ id + " " + nombre + " " + apellido +  " " + email +  " " + password);
			
			dao.modUser(id, nombre, apellido, email, password);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");*/
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("inicio?page=listaUsuarios");
			//dispatcher.forward(request, response);
			
		}
		else if("eliminar".equals(accion)){
			//int id=(int) session.getAttribute(accion);
			String idS=request.getParameter("id");
			int id = Integer.parseInt(idS);
			dao.deleteUser(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("inicio?page=listaUsuarios");
			dispatcher.forward(request, response);
			//response.sendRedirect("Filtrado/bienvenido.jsp");
		}
		
		else{
			request.getRequestDispatcher("Proyecto_Final/Filtrado/bienvenido.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("Filtrado/bienvenido.jsp").forward(request, response);
		
		String action=request.getParameter("action");
		
		HttpSession session =request.getSession();
		int id=(int) session.getAttribute("idMod");
			
		String nombre=request.getParameter("nom");
		String apellido=request.getParameter("ape");
		String email=request.getParameter("mail");
		String password=request.getParameter("pass");
		session.removeAttribute("formulario");
		
		dao.modUser(id, nombre, apellido, email, password);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("inicio?page=listaUsuarios");
		dispatcher.forward(request, response);
		
		

		
		/*
		if ("eliminar".equals(action)){
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
			*/
			
			
			

		} 
			
	}


