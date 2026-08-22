package nikhil.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class FileDownloading
 */
@WebServlet("/downloadurl")
public class FileDownloading extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="JNDI")
	private DataSource ds;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FileDownloading.doGet()");
		
		//collecting input parameters
		String id =  request.getParameter("id");
		String type =  request.getParameter("type");
		String query = null;
		String fileLoc = null;
		
		if (type.equalsIgnoreCase("resume")) {
			query = "select resumeloc from person_profile where pid = ?";
		} else {
			query = "select photoloc from person_profile where pid = ?";
		}
		
		try(Connection con = ds.getConnection()) {
			try(PreparedStatement pstm =con.prepareStatement(query)){
				pstm.setInt(1, Integer.parseInt(id));
				try(ResultSet resultset = pstm.executeQuery()){
					if (resultset.next()) {
						fileLoc=resultset.getString(1);
						System.out.println(fileLoc);
					}
					
					
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//write file downloading 
		try {
			//as per file location create a file object
			File file =new File(fileLoc);
			
			//seting the type of response form the server
			//1.set contant lenght
			response.setContentLengthLong(file.length());

			//2. set contant type::mime
			ServletContext context=getServletContext();
			String mimeType =context.getMimeType(fileLoc);
			mimeType= (mimeType==null)? "application/octet-steam" : mimeType;
			System.out.println(mimeType);
			response.setContentType(mimeType);
			
			//3. Setting the responseheader about downloading information
			response.addHeader("Content-Disposition", "attachment;fileName="+file.getName());

			// sending the stream response
			FileInputStream fis = new FileInputStream(file);
			ServletOutputStream ostream = response.getOutputStream();
			IOUtils.copy(fis, ostream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
