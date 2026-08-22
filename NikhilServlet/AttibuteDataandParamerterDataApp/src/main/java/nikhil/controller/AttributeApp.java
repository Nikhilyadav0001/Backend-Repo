package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttributeApp
 */
@WebServlet("/attribute")
public class AttributeApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		
		ServletContext context = getServletContext();
		
		context.setAttribute("name","nikhil");
		context.setAttribute("location","hayatpur");
		context.setAttribute("tech","edtech");
		context.removeAttribute("tech");
		Enumeration<String> attributeNames=context.getAttributeNames();
		
		out.println("<body align='center' bgcolor='cyan'>");
		out.println("<h1 style='text-align:center;'>SERVLETContex DATA::" + getServletName() + "</h1>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>ATTRIBUTENAME</th><th>ATTRIBUTEVALUE</th></tr>");
		
		while (attributeNames.hasMoreElements()) {
			out.println("<tr>");
			String attributeName = (String) attributeNames.nextElement();
			Object attributeValue=context.getAttribute(attributeName);
			out.println("<td>"+ attributeName+"</td>");
			out.println("<td>"+ attributeValue+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.close();
	}
	

}
