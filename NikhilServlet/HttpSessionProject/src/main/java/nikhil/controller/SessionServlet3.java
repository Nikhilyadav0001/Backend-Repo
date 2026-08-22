package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/test3")
public class SessionServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Enumeration<String> HeaderNames = request.getHeaderNames();
			
		out.println("<h1 style='color:red; text-align:center'>SESSON INFO</h1>");
		out.println("<table align ='center' border='1'>");
		out.println("<tr><th>HEADERNAME</th><th>HEADERVALUE</th></tr>");
			
		while (HeaderNames.hasMoreElements()) {				
			out.println("<tr>");
			String HeaderName = (String) HeaderNames.nextElement();
			Object value = request.getHeader(HeaderName);
				
			out.println("<td>"+HeaderName+"</td>");
			out.println("<td>"+value+"</td>");
				
			out.println("</tr>");	
		}
		out.println("</table>");
		
	}
}
