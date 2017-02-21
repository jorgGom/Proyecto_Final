package proyecto_final.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent e)  { 
         System.out.println("******Stopped "+e.getServletContext().getContextPath());
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent e)  { 
    	 System.out.println("******Started "+e.getServletContext().getContextPath());
    	 String company=e.getServletContext().getInitParameter("CompanyName");
    	 e.getServletContext().setAttribute("attCompanyName", company);
    	 
    	 //Conectarse a la base de datos
    	 ServletContext context = e.getServletContext();
    	 String DATABASE_DRIVER = context.getInitParameter("DATABASE_DRIVER");
    	 String DATABASE_URI = context.getInitParameter("DATABASE_URI");
    	 String DATABASE_USERNAME = context.getInitParameter("DATABASE_USERNAME");
    	 String DATABASE_PASSWORD = context.getInitParameter("DATABASE_PASSWORD");
    	 //Conexion
    	 Connection conn = null;
    	 try {
    		 Class.forName(DATABASE_DRIVER);
        	 conn = DriverManager.getConnection(DATABASE_URI, DATABASE_USERNAME, DATABASE_PASSWORD);
        	 context.setAttribute("DataBase_Connection", conn);
    	 } catch (ClassNotFoundException ee) {
    		 System.out.println("No se pudo cargar el driver de la base de datos");
    		 ee.printStackTrace();
    	 } catch (SQLException ee) {
    		 System.out.println("No se pudo establecer conexi�n con la base de datos");
    		 ee.printStackTrace();
    	 }
    	 
    }
	
}
