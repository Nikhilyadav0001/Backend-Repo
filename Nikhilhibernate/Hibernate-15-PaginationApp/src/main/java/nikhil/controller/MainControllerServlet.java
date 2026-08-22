package nikhil.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import nikhil.entity.InsurancePolicyDTO;
import nikhil.service.InsurancePolicyManagementService;
import nikhil.service.InsurancePolicyMgmtServiceImpl;

/**
 * Servlet implementation class MainControllerServlet
 */
@WebServlet(value ="/controller" ,loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InsurancePolicyManagementService service;
	
	@Override
	public void init() throws ServletException {
		service = new InsurancePolicyMgmtServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//default page size
		int pageSize =3;
		int pageNo=0;
		long pagesCount =0;
		
		String buttonClick =request.getParameter("s1");
		HttpSession session = null;
		List<InsurancePolicyDTO> listDto =null;
		RequestDispatcher rd =null;
		String targetpage =null;
		
		session =request.getSession(true);
		
		if (buttonClick.equalsIgnoreCase("generateReport")) {
			//user clicked on the submit button
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
			
			//default page no is one for initial request
			pageNo =1;
			
			//keeping pagesize in session scope to access accross multilple requests
			if (session != null) {
				session.setAttribute("pageSize", pageSize);
			}
			
		} else {
			//user clicked on the hiperlink
			
			pageNo =Integer.parseInt(request.getParameter("pageNo"));
			
			//keeping pagesize in session scope to access accross multilple requests
			if (session != null) {
				session.setAttribute("pageSize", pageSize);
			}
			
		}
		
		

		try {
			//logic to work with service layer
			
			//No of pages need to display the records in paganation style
			pagesCount =service.fetchPagesCount(pageSize);
			
			//get the records in each page to print on the ui
			listDto =service.fetchPageDate(pageSize, pageNo);
			
			request.setAttribute("policyList", listDto);
			request.setAttribute("pageCount", pagesCount);
			request.setAttribute("pageNo", pageNo);
			targetpage = "/report.jsp";
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
			targetpage = "/error.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			targetpage = "/error.jsp";
		}
		
		
		rd = request.getRequestDispatcher(targetpage);
		rd.forward(request, response);
		
		
	}

}
