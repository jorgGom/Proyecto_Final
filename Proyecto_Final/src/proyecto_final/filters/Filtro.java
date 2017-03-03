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
@WebFilter("/inicio/*")
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
		HttpServletRequest request2 =(HttpServletRequest) request;    
		System.out.println(ifVar);
		
		
		
		if ("admin".equals(ifVar)) {
			chain.doFilter(request, response);}
		
		if(ifVar==null){
			String str = request2.getRequestURI();
			if(str.contains("inicio") || str.contains("Admin")){
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		        dispatcher.forward(request, response);
			}}
		
		if(!(ifVar==null) && !"admin".equals(ifVar)){
				String str = request2.getRequestURI();
				
				if(str.contains("Admin")){
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		        dispatcher.forward(request, response);}
				else{
					chain.doFilter(request, response);
				}
			}
		}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
