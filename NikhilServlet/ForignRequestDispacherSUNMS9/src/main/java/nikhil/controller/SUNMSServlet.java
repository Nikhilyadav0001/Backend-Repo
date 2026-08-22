package nikhil.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SUNMSServlet
 */
@WebServlet("/sun")
public class SUNMSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		ServletContext fc = context.getContext("/FoirgnRequestDispacherOracle9");
		System.out.println(fc.getClass().getName());
		RequestDispatcher rd = fc.getRequestDispatcher("/oracle");
		rd.forward(request, response);
	
	}

}
