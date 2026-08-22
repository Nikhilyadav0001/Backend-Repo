package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet1
 */
@WebServlet("/test1")
public class SessionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (session.isNew()) {
			out.println("<h1 style='color:red; text-align:center'>NEW SESSON GOT CREATED WITH SESSION ID::"
					+session.getId()+"</h1>");
			
		}else {
			out.println("<h1 style='color:red; text-align:center'>EXISTING SESSON GOT USED WITH SESSION ID::"
					+session.getId()+"</h1>");
		}
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		
		session.setAttribute(name, value);
		
		//15 sec later session will expire
		session.setMaxInactiveInterval(15);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
		
		out.close();
	}
}
