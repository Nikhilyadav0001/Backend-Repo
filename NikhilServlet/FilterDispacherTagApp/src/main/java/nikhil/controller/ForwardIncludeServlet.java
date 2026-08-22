package nikhil.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ForwardIncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static{
		System.out.println("forward and include loading ");
	}
	public ForwardIncludeServlet() {
		System.out.println("forward and include instantation");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("forward and include initialization");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("./test2");
		rd.forward(request, response);
	//	rd.include(request, response);
	}

}
