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
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static {
		 System.out.println("demo filterLoading....");
	    }

    public DemoFilter() {
       System.out.println("demo filter instantaion");
    }

	public void destroy() {
		System.out.println("demmo filter de instantaion");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("demo filter processing");


		PrintWriter out=response.getWriter();
		out.println("<h1 style='color:green; text-align:center'>added by demo flter before refuest processing</h1>");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("demo fillter iniitialization");
		
	}

}
