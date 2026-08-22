package nikhil;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import nikhil.beans.Employee;


@SpringBootApplication
public class Application {
	static {
		System.out.println("Application.class file is loading...");
	}

	public Application() {
		System.out.println("Application Object is created...");
	}
	


	public static void main(String[] args) {
		// Start the container
		System.out.println("***********Container Started****************");
		
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("Name of the container is :: " + context.getClass().getName());
		
		Employee bean = context.getBean(Employee.class);
		System.out.println(bean);
		
		DataSource source = context.getBean(DataSource.class);
		System.out.println("DataSource is :: "+source.getClass().getName());
		
		((ConfigurableApplicationContext) context).close();
		System.out.println("***********Container Stopped****************");
		
	}

}
