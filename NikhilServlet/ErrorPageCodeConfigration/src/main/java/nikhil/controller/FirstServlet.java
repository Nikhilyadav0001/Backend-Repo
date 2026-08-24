package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		
		PrintWriter out =response.getWriter();
		if (name.equalsIgnoreCase("nikhil")&& pwd.equalsIgnoreCase("nikhil@123")) {
			out.println("<h1 style='color:green; text-align:center;'>AVAIL THE SERVICES OF NIKHILSKILLS....</h1>");
		}else {
			//calling error page
			response.sendError(401);
		}
		
		out.close();
	}

}
