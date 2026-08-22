package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClinetServerInfo
 */
@WebServlet("/client")
public class ClinetServerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static {
		System.out.println("loading .class file of client server");
	}
    public ClinetServerInfo() {
        System.out.println("instanciation  for clintserver");
    }

    
    @Override
	public void init() throws ServletException{
    	System.out.println("initialization init()");
	}
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("requestprocessing");
    	//server details
    	String serverName =request.getServerName();
    	int serverPort = request.getServerPort();
    	//clintdetails
    	String remoteAddr =request.getRemoteAddr();
    	String remoteHost =request.getRemoteHost();
    	int remotePort = request.getRemotePort();
    	
    	
    	 
    	PrintWriter out = response.getWriter();
		out.println("<body align='center' bgcolor='cyan'>");
		out.println("<table  border='1'>");
		out.println("</tr>");
			out.println("<th> SERVERNAME</th>");
			out.println("<th> SERVERPORT</th>");
			out.println("<th> REMOTEADDR</th>");
			out.println("<th> REMOTEHOST</th>");
			out.println("<th> REMOTEPORT</th>");
		out.println("</tr>");
		out.println("</tr>");
			out.println("<th>"+serverName+"</th>");
			out.println("<th>"+serverPort+"</th>");
			out.println("<th>"+remoteAddr+"</th>");
			out.println("<th>"+remoteHost+"</th>");
			out.println("<th>"+remotePort+"</th>");
		
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.close();

    
    }

	

}
