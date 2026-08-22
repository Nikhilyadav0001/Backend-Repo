package nikhil.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

import nikhil.customize.CustomizedResponse;

/**
 * Servlet Filter implementation class ReverseWordFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/test" })
public class ReverseWordFilter extends HttpFilter implements Filter {
    
	private static final long serialVersionUID = 1L;
	static {
    	System.out.println("loading reverse word filter ");
    }
	
    public ReverseWordFilter() {
    	System.out.println("instantation reverse word filter ");
    }

	
	public void destroy() {
		System.out.println("de instantation reverse word filter ");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("processing filterr");

		CustomizedResponse resp=new CustomizedResponse((HttpServletResponse) response);
		// pass the request along the filter chain
		chain.doFilter(request, resp);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("initialization reverse word filter ");
	}

}
