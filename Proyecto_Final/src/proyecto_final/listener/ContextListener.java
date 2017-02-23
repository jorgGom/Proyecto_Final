package proyecto_final.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;



@WebListener
public class ContextListener implements ServletContextListener {

 
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent ev)  { 
    	
    	ServletContext context = ev.getServletContext();
    	
    	String DATABASE_DRIVER = context.getInitParameter("DATABASE_DRIVER");
    	String DATABASE_URI = context.getInitParameter("DATABASE_URI");
    	String DATABASE_USERNAME = context.getInitParameter("DATABASE_USERNAME");
    	String DATABASE_PASSWORD = context.getInitParameter("DATABASE_PASSWORD");
    	
    	Connection conection = null;
    	
    	try {
			Class.forName(DATABASE_DRIVER);
			conection = (Connection) DriverManager.getConnection(DATABASE_URI,DATABASE_USERNAME,DATABASE_PASSWORD);
			context.setAttribute("conection", conection);
			System.out.println("Conexión correcta");
		} catch (ClassNotFoundException e) {
			System.out.println("No se pudo cargar el driver de la base de datos");			
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se pudo obtener la conexión de la base de datos");

		}
    }

    public void contextDestroyed(ServletContextEvent ev)  { 
         
    }
}
