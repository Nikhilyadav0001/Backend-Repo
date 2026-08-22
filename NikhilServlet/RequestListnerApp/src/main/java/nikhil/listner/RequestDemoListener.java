package nikhil.listner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestDemoListener
 *
 */
@WebListener
public class RequestDemoListener implements ServletRequestListener {
	public static int count =0;
    static {
    	System.out.println("RequestDemoListener.:: loading()");
    }
    public RequestDemoListener() {
        System.out.println("RequestDemoListener.RequestDemoListener()::instantation");
        
    }

	
    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("RequestDemoListener.requestDestroyed()");
    }
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("Request Object details are :: "+sre.hashCode());
		System.out.println("RequestDemoListener.requestInitialized() : object created at " + new java.util.Date());
		count++;
		System.out.println("The no of hits for the webapplication is :: "+count);
    }
	
}
