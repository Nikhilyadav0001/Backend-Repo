package nikhil.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SunMsServlet
 */
@WebServlet(name = "SunMsCode", urlPatterns = { "/sun" })
public class SunMsCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("loading SunMs instance");
	}
	
	
    
    public SunMsCode() {
       System.out.println("instan Sun ms responce");
    }

	
	public void init() throws ServletException {
		System.out.println("initilization Sun ms responce");
	}

	
	public void destroy() {
		System.out.println("de instacetion Sun ms rres");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("request pocessing:: sunms");
		/*
		response.setStatus(302);
		response.setHeader("Location","./oracle");*/
		response.sendRedirect("./oracle");
	}

}
