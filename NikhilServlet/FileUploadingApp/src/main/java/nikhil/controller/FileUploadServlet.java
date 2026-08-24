package nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadParameters;


@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private static final String SQL_INSERT_QUERY = "INSERT INTO person_profile (pname, paddress, resumeloc, photoloc)VALUES (?, ?, ?, ?)";

	
	@Resource(name="JNDI")
	private DataSource ds;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FileUploadServlet.doPost()");
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String resumeLocation="D:\\java files\\uploads\\text file\\";
		String photoLocation="D:\\java files\\uploads\\images\\";
		
		boolean uploadFlag =false;
		String username= null,useraddr=null,resumeFilePath =null,photoFilePath=null;
		
		try {
			//collecting request object which holds resume and photo as streams
			MultipartFormDataRequest nreq = new MultipartFormDataRequest(request);
			
			//geting string data from request object
			username = nreq.getParameter("username");
			useraddr = nreq.getParameter("useraddr");
			System.out.println(username);
			System.out.println(useraddr);
			
			//using uploadbean to work with filesystem
			UploadBean upb =new UploadBean();
			upb.setMaxfiles(15);
			//upb.setFilesizelimit(100*1024);
			upb.setOverwrite(true);
			upb.setBlacklist("install.exe,setup.exe");
			
			//specify the location of server machine where file needs to be stored
			upb.setFolderstore(resumeLocation);
			upb.store(nreq,"userresume");//completes resume uploading
			//specify the location of server machine where file needs to be stored
			upb.setFolderstore(photoLocation);
			upb.store(nreq,"userphoto");//completes photo uploading
			
			//geting all the uploaded filenames
			@SuppressWarnings("rawtypes")
			Vector vector =upb.getHistory();
			resumeFilePath = resumeLocation + ((UploadParameters) vector.get(0)).getFilename();
			System.out.println(resumeFilePath);
			photoFilePath = photoLocation + ((UploadParameters) vector.get(1)).getFilename();
			System.out.println(photoFilePath);
			
			uploadFlag=true;

			out.println("<h1 style='color:red; text-align:center;'>UPLOADING THE FILE INTO THE SERVER...</h1>");
			
			
		} catch (UploadException | IOException e) {
			uploadFlag=false;
			out.println("<h1 style='color:red; text-align:center;'>PROBLEM IN FILE UPLOADING</h1>");
			e.printStackTrace();
		}
		
		if (uploadFlag) {
			//jdbc code to sava data
			try(Connection con=ds.getConnection()) {
				try(PreparedStatement psmt = con.prepareStatement(SQL_INSERT_QUERY)){
					//set the values collected from the server
					psmt.setString(1, username);
					psmt.setString(2, useraddr);
					psmt.setString(3, resumeFilePath);
					psmt.setString(4, photoFilePath);
					
					int rowCount =psmt.executeUpdate();
					if (rowCount==0) {
						out.println("<h1 style='color:red; text-align:center;'>REGISTRATION FAILD</h1>");
					} else {
						out.println("<h1 style='color:green; text-align:center;'>UPLOADING THE FILE INTO THE SERVER</h1>");
					}
				
					out.println("<h1 style='text-align:center;'><a href='./index.html'>|HOMEPAGE|</h1>");
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<h1 style='color:red; text-align:center;'>REGISTRATION FAILD</h1>");
			}
			
		} else {

			out.println("<h1 style='color:red; text-align:center;'>PROBLEM IN FILE UPLOADING</h1>");
			
		}
		
	
	}
}
