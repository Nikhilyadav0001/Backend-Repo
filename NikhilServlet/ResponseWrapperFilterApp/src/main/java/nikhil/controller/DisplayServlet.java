package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/test")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    static {
    	System.out.println("loading sispaly servlet ");
    }
    public DisplayServlet() {
    	System.out.println("diaplaay servlet instantation");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("diaplay servlet initialisation");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("diaply servlet request processing");
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		System.out.println("this writer is::"+out.getClass().getName());
		
		out.println("<body align='center'>");
		out.println("<h1 style='color:red; text-align:center'>");
		out.println(name);
		out.println("</h1>");
		out.println("</body>");
		
		
	}

}
