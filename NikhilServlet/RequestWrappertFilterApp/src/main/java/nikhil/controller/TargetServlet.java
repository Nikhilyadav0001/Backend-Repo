package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TargetServlet
 */

//http://localhost:9999/RequestWrappertFilterApp/test?name=jee
@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	static {
		System.out.println("loading target servlet");
	}
    public TargetServlet() {
    	System.out.println("target instantation");
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("target initialization");
    }
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("target request processinng");
		PrintWriter out=response.getWriter();
		String name =  request.getParameter("name");
		
		out.println("<h1 style='color:blue, text-align:center'>entered name is::"+name+"</h1>");
		
	}
	@Override
	public void destroy() {
		System.out.println("target de instantation");
	}

}
