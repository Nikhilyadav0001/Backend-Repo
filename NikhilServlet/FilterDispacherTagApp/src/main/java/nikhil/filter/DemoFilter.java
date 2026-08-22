package nikhil.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;


public class DemoFilter extends HttpFilter implements Filter {
    
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("filter loading ::demo filter");
	}
    public DemoFilter() {
       System.out.println("filter instantiation");
    }

	
	public void destroy() {
		System.out.println("filter de-instantiation");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter request processiong ");
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:green; text-align:center;'>ADDED BY FILTER BEFORE REQUEST processing...</h1>");
		
		
		
		chain.doFilter(request, response);
		out.println("<h1 style='color:green; text-align:center;'>ADDED BY FILTER AFTER REQUEST processing...</h1>");
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter initialization ::init");
	}

	

}
