package nikhil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import nikhil.bean.Employee;
import nikhil.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		System.out.println("**************Starting the  contanner***********");
		//starting the contaner
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//working with bean created by ioc
		Employee bean = context.getBean("emp",Employee.class);
		System.out.println(bean);
		
		
		//closing the container
		((AbstractApplicationContext) context).close();
		System.out.println("**************Closing the  contanner***********");
	}
}
