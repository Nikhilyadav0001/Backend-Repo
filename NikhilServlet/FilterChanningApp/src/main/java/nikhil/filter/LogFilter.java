package nikhil.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;



public class LogFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FilterConfig fconfig;
	static {
		 System.out.println("log filterLoading....");
	    }
    public LogFilter() {
    	System.out.println("log filter instantation");
    }

	public void destroy() {
		fconfig=null;
		System.out.println("log filter de instantaion");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(" log filter processing");
		
		ServletContext context =fconfig.getServletContext();
		HttpServletRequest req=(HttpServletRequest)request;
		
		PrintWriter out =response.getWriter();
		out.println("<h1 style='color:blue; text-align:center'>added by log flter before request processing</h1>");
		//server log details
		context.log("request iis comming from ::"+req.getRemoteHost()+"url::"+req.getRequestURL()
						+"at::"+  new java.util.Date());
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.println("<h1 style='color:blue; text-align:center'>added by log flter after request processing</h1>");		
	}


	public void init(FilterConfig fconfig) throws ServletException {
		this.fconfig=fconfig;
		System.out.println("log filter initialization");
	}

}
