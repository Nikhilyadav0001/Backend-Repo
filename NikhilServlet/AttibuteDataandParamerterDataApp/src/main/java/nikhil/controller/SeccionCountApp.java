package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NoOfUserLogin
 */
@WebServlet("/session")
public class SeccionCountApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session= request.getSession();
		
		Integer value =(Integer)session.getAttribute("Sessioncount");
		System.out.println(value);
		if(session.isNew()) {
		if (value == null) {
			value = 1;
		}else {
			value++;
		}
		}
		session.setAttribute("Sessioncount", value);
		out.println("<h1>the no of  session  is::"+value+"</h1>");
		out.println();
		out.close();
		
	}

}
