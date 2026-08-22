package nikhil.listner;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestServletAttributeListener
 *
 */
@WebListener
public class RequestServletAttributeListner implements ServletRequestAttributeListener {

	static {
		System.out.println("Loading-> RequestServletAttributeListener.class file is loading...");
	}
	
    /**
     * Default constructor. 
     */
    public RequestServletAttributeListner() {
    	System.out.println("Instantiation-> RequestServletAttributeListener object is created...");
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println(srae.getName()+" object is removed...");
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println(srae.getName()+" object is added...");
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("\n"+srae.getName()+" object is updated..."+"\n");
    }
	
}
