package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/showBalance") not required for thihs case as we have configured it in the web.xml
public class ShowBalanceApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if (request.isUserInRole("nikhil")) {
			out.println(
					"<h1 style='color:red; text-align:center;'>Authentication Mode :: " + request.getAuthType() + "</h1>");
			out.println("<h1 style='color:red; text-align:center;'>Logged Username :: " + request.getUserPrincipal() + "</h1>");
			out.println("<h1 style='color:red; text-align:center;'>Account balance is :: " + new Random().nextInt(200000)
					+ "</h1>");
		} else {
			out.println("<h1 style='color:red; text-align:center;'>you are not nikhil </h1>");
		}
		
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
