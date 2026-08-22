package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderApp
 */
@WebServlet(description = "working with request headers", urlPatterns = { "/header" },loadOnStartup=5)
public class RequestHeaderApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("loading....header...");
		
	}
	public RequestHeaderApp() {
		System.out.println("initialistion....header.");
	}
	
	public void init() throws ServletException {
		System.out.println("instansation....header..");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request processing request header app");
		PrintWriter out = response.getWriter();
		Enumeration<String> headerNames = request.getHeaderNames();
		
		out.println("<body align='center'>");
		out.println("<h1 style='color:red;'>REQUEST HEADER INFORMATION</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>HEADERNAME</th><th>HEADERVALUES</th></tr>");

		while (headerNames.hasMoreElements()) {
			out.println("<tr>");

			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			out.println("<td>" + key + "</td>");
			out.println("<td>" + value + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.close();

	}

}
