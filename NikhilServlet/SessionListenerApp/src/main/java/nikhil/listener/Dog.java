package nikhil.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class Dog
 *
 */
@WebListener
public class Dog implements HttpSessionBindingListener {

    public void valueBound(HttpSessionBindingEvent event)  { 
         System.out.println("dog obbject added to sessionn scope");
    }
	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
         System.out.println("dog object removed from session scope");
    }
	
}
