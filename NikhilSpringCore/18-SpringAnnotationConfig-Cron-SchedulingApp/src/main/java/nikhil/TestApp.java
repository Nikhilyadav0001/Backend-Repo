package nikhil;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import nikhil.config.AppConfig;

public class TestApp {
	public static void main(String[] args) throws Exception {

		// starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("container started at::"+ new Date());
		
		
		
//		Thread.sleep(10000); // wait 10 seconds
//		// close the container
//		((AbstractApplicationContext) context).close();

	}
}
