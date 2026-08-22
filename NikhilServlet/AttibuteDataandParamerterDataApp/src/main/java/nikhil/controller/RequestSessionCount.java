package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NoOfUserLogin
 */
@WebServlet("/request")
public class RequestSessionCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session= request.getSession();
		
		Integer value =(Integer)session.getAttribute("requestcount");
		System.out.println(value);
	
		if (value == null) {
			value = 1;
		}else {
			value++;
		}
		
		session.setAttribute("requestcount", value);
		out.println("<h1>the no of total  request  in this session is::"+value+"</h1>");
		out.println();
		out.close();
		
	}

}
