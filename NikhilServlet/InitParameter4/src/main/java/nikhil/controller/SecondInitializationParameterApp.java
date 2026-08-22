package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitializationParameterApp
 */
@WebServlet(
		
		urlPatterns = { "/sheer" }
		)
public class SecondInitializationParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request processing");
		System.out.println("config details::"+getServletConfig());
		System.out.println("contex details::"+getServletContext());
		
		PrintWriter out =response.getWriter();
		out.println("<body align='center' bgcolor='cyan'>");
		out.println("<h1 style='text-align:center;'>SERVLETCONFIG DATA::" + getServletName() + "</h1>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>PARAMETERNAME</th><th>PARAMETERVALUE</th></tr>");
		
		ServletConfig config = getServletConfig();
		Enumeration<String> parameterNames=config.getInitParameterNames();// or directye call get intit parameter name here no need to create any config object
		while (parameterNames.hasMoreElements()) {
			out.println("<tr>");
			String parameterName = (String) parameterNames.nextElement();
			String parameterValue=config.getInitParameter(parameterName);
			out.println("<td>"+ parameterName+"</td>");
			out.println("<td>"+ parameterValue+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		
	}

}
