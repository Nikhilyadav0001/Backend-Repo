package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class CookieFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//working with cookie for session management
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		
		Cookie c1 = new Cookie(name,value);
		
		// 15 sec cokie will be avalable
		c1.setMaxAge(15);
		response.addCookie(c1);
		out.println("<h1 stylle ='color:green ; text-align:center'>COOKIE ADD SUSSFULLY</h1>");
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
		
		out.close();
		
		
	}

}
