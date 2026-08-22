package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "working with request object", urlPatterns = { "/input" },loadOnStartup=10)
public class RequestParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("loading.......");
		
	}
	public RequestParameterApp() {
		System.out.println("initialistion.....");
	}
	
	public void init() throws ServletException {
		System.out.println("instansation......");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request processing request parameter app");
		
		// Collect the inputs from request object for processing
				String username = request.getParameter("username");
				String contactnumber = request.getParameter("contactno");
				String[] cources = request.getParameterValues("cources");
				String status = "Registration Succesfull";

				// Generate a table response to the enduser
				PrintWriter out = response.getWriter();
				out.println("<body align='center' bgcolor='cyan'>");
				out.println("<h1>STUDENT REGISTRATION STATUS</h1>");
				out.println("<table align='center' border='1'>");
				out.println("<tr><th>NAME</th><th>CONTACTNUMBER</th><th>COURSES</th><th>STATUS</th></tr>");
				out.println("<tr>");
				out.println("<td>" + username + "</td>");
				out.println("<td>" + contactnumber + "</td>");
				out.println("<td>");

				for (String cource : cources) {
					cource = cource + "\n";
					out.println(cource + "<br/>");
				}
				out.println("</td>");
				out.println("<td>" + status + "</td>");

				out.println("</tr>");
				out.println("</table>");
				out.println("</body>");

		
		
		
		
	}
	private void distroy() {
		System.out.println("de instansation.........");

	}

}
