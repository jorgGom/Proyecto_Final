package proyecto_final.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter("filtrado/*")
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		String ifVar=(String)((HttpServletRequest)request).getSession().getAttribute("userName");
		
		
		
		if (ifVar!=null) {
			System.out.println("Tiene sesion");
			if (ifVar.equals(request.getServletContext().getInitParameter(""))) {
				chain.doFilter(request, response);
			}else {request.getRequestDispatcher("index.jsp").forward(request, response);
					}
		} else {
			System.out.println("No tiene sesion");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Contenido/error.jsp");
			dispatcher.forward(request, response);
		}
	}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
