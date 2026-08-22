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
import javax.servlet.http.HttpServletRequest;

import nikhil.customized.CustomizedRequest;

/**
 * Servlet Filter implementation class WordChangeFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/test" })
public class WordChangeFilter extends HttpFilter implements Filter {
 
	static {
		System.out.println("loading filter");
	}

	public WordChangeFilter() {
      System.out.println("word change filter instantation");
    }

	public void destroy() {
		System.out.println("word change  de instantation");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		CustomizedRequest req = new CustomizedRequest((HttpServletRequest) request);

		// pass the request along the filter chain
		chain.doFilter(req, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("word change filter initialization");
	}

}
