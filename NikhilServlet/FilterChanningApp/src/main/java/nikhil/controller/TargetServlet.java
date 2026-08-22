package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    static {
    	System.out.println("targetServletLoading....");
    }
    public TargetServlet() {
    	System.out.println("target servlet instantation");
    }

	@Override
	public void init() throws ServletException {
		System.out.println("target servlet initialization");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" target sevlet processing...");
		
		PrintWriter out=response.getWriter();
		out.println("<h1 style='color:green; text-align:center'>this is target servlet</h1>");
		
		
	}
	
	@Override
	public void destroy() {
		System.out.println("target servlet de-instantation");
	}

}
