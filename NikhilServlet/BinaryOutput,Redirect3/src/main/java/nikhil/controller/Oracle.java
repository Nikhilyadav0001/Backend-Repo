package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SunMsServlet
 */
@WebServlet(name = "Oracle", urlPatterns = { "/oracle" })
public class Oracle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("loading oracle instance");
	}
	
	
    
    public Oracle() {
       System.out.println("instan oracle responce");
    }

	
	public void init() throws ServletException {
		System.out.println("initilization oracle responce");
	}

	
	public void destroy() {
		System.out.println("de instacetion oracle rres");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("request pocessing:: oracle");
		PrintWriter out =response.getWriter();
		out.println("<h1>welcome to oracle</h1>");
		out.close();
		
		
	}

}
