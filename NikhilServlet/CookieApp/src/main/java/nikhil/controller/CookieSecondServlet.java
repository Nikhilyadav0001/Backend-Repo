package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test2")
public class CookieSecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Cookie[] cookies =request.getCookies();
		if (cookies == null) {
			out.println("<h1 stylle ='color:red text-align:center'>No cookies are associated with this request object</h1>");
		} else {
			out.println("<h1 stylle ='color:green text-align:center'>cookie info</h1>");
			out.println("<table border='1' align='center'>");
			out.println("<tr><th>COOKIENAME</th><th>COOKIEVALUE</th></tr>");
			
			for(Cookie cookie : cookies) {
				out.println("<tr>");
				String Name = cookie.getName();
				String Value = cookie.getValue();
				
				out.println("<td>"+ Name+"</td>");
				out.println("<td>"+ Value+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		
		}
		out.close();
		
		
	}

}
