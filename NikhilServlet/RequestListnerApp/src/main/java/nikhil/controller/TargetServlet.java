package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nikhil.listner.RequestDemoListener;

@WebServlet(urlPatterns={"/target"}, loadOnStartup =1)
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static {
		System.out.println("loading the .class file of target servlet");
	}
    public TargetServlet() {
        System.out.println("TargetServlet.TargetServlet() :: instantation");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("TargetServlet.init()::initialization");
		
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("TargetServletRequestProcessing:: TargetServlet.doGet()");
		System.out.println("Request  Object address is :: "+request.hashCode());
		System.out.println("Response Object address is :: "+response.hashCode());
		System.out.println("Servlet  Object address is :: "+this.hashCode());
		System.out.println("Thread information is      :: "+Thread.currentThread().hashCode());

		PrintWriter out = response.getWriter();

		out.println("<h1 style='color:green; text-align:center;'>REQUEST COMING TO TARGETSERVLET...</h1>");
		out.println("<h1 style='color:green; text-align:center;'>The no of hits for the webapplication is :: "
				+ RequestDemoListener.count + "</h1>");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
