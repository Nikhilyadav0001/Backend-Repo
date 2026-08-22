package nikhil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import nikhil.bean.WishMassageGenerator;
import nikhil.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		
		//starting the contaner
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//asking the ioccontainer to give the bean with the id as specified
		WishMassageGenerator wmg = context.getBean("wmg",WishMassageGenerator.class);
		String Status =  wmg.wishMassage("nikhil");
		System.out.println(Status);
		
		
		//closing the container
		((AbstractApplicationContext) context).close();
	}
}
