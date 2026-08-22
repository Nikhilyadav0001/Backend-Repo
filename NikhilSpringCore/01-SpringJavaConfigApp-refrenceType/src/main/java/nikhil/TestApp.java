package nikhil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import main.bean.Employee;
import nikhil.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		
		//starting the contaner
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//asking the container to give the bean with the id as specified
		Employee employ =context.getBean("emp",Employee.class);
		System.out.println(employ);
		
		//closing the container
		((AbstractApplicationContext) context).close();
	}
}
