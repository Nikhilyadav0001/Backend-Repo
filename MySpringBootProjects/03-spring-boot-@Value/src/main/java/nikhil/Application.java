package nikhil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import nikhil.beans.BillGenerator;
import nikhil.beans.ItemsInfo;

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
		
		ItemsInfo bean = context.getBean(ItemsInfo.class);
		System.out.println(bean);
		
		BillGenerator generator = context.getBean(BillGenerator.class);
		System.out.println(generator);
		
		((ConfigurableApplicationContext) context).close();
		System.out.println("***********Container Stopped****************");
		
	}

}
