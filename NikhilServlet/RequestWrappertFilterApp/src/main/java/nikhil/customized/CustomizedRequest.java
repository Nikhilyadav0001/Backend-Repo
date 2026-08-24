package nikhil.customized;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedRequest extends HttpServletRequestWrapper {

	public CustomizedRequest(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String data = super.getParameter(name);
		System.out.println("data entered by the user is "+ data);
		
		if (data.equals("java") || data.equals("jee")) {
			return "sleeping";
		} else {
			return data;
		}
		
	}

}
