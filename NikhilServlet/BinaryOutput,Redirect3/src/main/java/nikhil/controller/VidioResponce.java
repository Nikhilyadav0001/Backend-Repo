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
 * Servlet implementation class VidioResponce
 */
@WebServlet(name = "VideoResponce", description = "responce of video type", urlPatterns = { "/video" })
public class VidioResponce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static {
		System.out.println("loading video instance");
	}
	
	
    
    public VidioResponce() {
       System.out.println("instan vidio responce");
    }

	
	public void init() throws ServletException {
		System.out.println("initilization visio responce");
	}

	
	public void destroy() {
		System.out.println("de instacetion video rres");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//seting mime type
		response.setContentType("video/mp4");
		//geting byte responce to sent thr responce
		ServletOutputStream outputStream = response.getOutputStream();
		//reading the video through input stream
		String location ="D:\\java files\\NikhilServlet\\ThirdServletApp\\src\\main\\webapp\\video.mp4";
		String path =getServletContext().getRealPath("video.mp4");
		
		System.out.println("video located in"+location);
		System.out.println("video located in"+path);
		
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
