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
 * Servlet implementation class FirstServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/nsecond servlet .do get()");
		System.out.println("request object:"+ request.hashCode());
		System.out.println("response object:"+ response.hashCode());
		
		PrintWriter out =response.getWriter();
		
		
		Enumeration<String> attributeNames=request.getAttributeNames();
		
		out.println("<body align='center' bgcolor='cyan'>");
		out.println("<h1 style ='color:red; text-align:centre;'>OUTPUT FROM FIRST SERVLET</h1>");
		out.println("<h3 style='text-align:center;'>SERVLETContex DATA::" + getServletName() + "</h3>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>ATTRIBUTENAME</th><th>ATTRIBUTEVALUE</th></tr>");
		
		while (attributeNames.hasMoreElements()) {
			out.println("<tr>");
			String attributeName = (String) attributeNames.nextElement();
			Object attributeValue=request.getAttribute(attributeName);
			out.println("<td>"+ attributeName+"</td>");
			out.println("<td>"+ attributeValue+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.close();
	
	}

}
