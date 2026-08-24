package nikhil.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageFileResponce
 */
@WebServlet(description = "working with inge file respoce", urlPatterns = { "/image" })
public class ImageFileResponce extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
		static {
			System.out.println("loading image instance");
		}
		
		
	    
	    public ImageFileResponce() {
	       System.out.println("instan image responce");
	    }

		
		public void init() throws ServletException {
			System.out.println("initilization image responce");
		}

		
		public void destroy() {
			System.out.println("de instacetion image rres");
		}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//seting mime type
				response.setContentType("image/jpeg");
				
				//geting byte stream to sent thr responce
				ServletOutputStream outputStream = response.getOutputStream();
				
				//reading the image through input stream
				String location ="D:\\java files\\NikhilServlet\\ThirdServletApp\\src\\main\\webapp\\image.jpg";
				String path =getServletContext().getRealPath("image.jpg");
				
				System.out.println("image located in"+location);
				System.out.println("image located in"+path);
				
				File file= new File(path);
				FileInputStream inputStream =new FileInputStream(file);
				byte[] b = new byte[(int)file.length()];
				inputStream.read(b);
				
				outputStream.write(b);
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				}

}
