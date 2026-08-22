package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("first servelt do get");
		System.out.println("request object:"+ request.hashCode());
		System.out.println("response object:"+ response.hashCode());
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style ='color:red; text-align:centre;'>OUTPUT FROM FIRST SERVLET</h1>");
		
		request.setAttribute("name", "nikhil");
		request.setAttribute("age", "17");
		//frowording request using request dispacher
		RequestDispatcher rd = request.getRequestDispatcher("/second");
		rd.forward(request, response);
		System.out.println("request comming back to "+getClass().getName());
		out.close();
	
	}

}
