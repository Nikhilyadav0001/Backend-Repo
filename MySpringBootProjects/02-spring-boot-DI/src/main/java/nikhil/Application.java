package nikhil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import nikhil.beans.Student;



@SpringBootApplication
@ImportResource("nikhil/cfgs/appilcationcontext.xml")
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
		
		Student bean = context.getBean(Student.class);
		bean.preparation("java-interview");
		
		
		((ConfigurableApplicationContext) context).close();
		System.out.println("***********Container Stopped****************");
		
	}

}
