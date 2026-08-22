package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		
		String uname =request.getParameter("name");
		out.println("<h1 style='color:green; text-align:center'>welcome to  nikhil's</h1>");
		
		String url ="./test2?name="+uname;
		String encodeUrl=response.encodeURL(url);
		response.sendRedirect(encodeUrl);
		//out.println("<a href ='./test2?name="+uname+"'>click here to get the name</a>");
		
		out.close();
	}

}
