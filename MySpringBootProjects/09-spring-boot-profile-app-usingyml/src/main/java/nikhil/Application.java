package nikhil;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import nikhil.controller.MainController;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// Start the container
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		//collecting input from the user ki kitni chizo chaiye query me like job batman,chor
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the desiganation count::");
		int count =  scanner.nextInt();
		
		String [] desg = null;
		
		if (count>=1) {
			//create arrey for the specific count
			desg = new String[count];
			
		} else {
			//print invalid massage to the user
			System.out.println("Invalid Designation count...");
		}
		
		// initialize the array with user input['batman','chor']
		for (int i = 0; i < count; i++) {
			System.out.print("Enter the designation :: ");
			desg[i] = scanner.next();
		}
		
		//asking the container to give the controller Object
		try {
			MainController controller = context.getBean(MainController.class);
			controller.showEmployeeByDesg(desg).forEach(System.out::println);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//closing the resource
		scanner.close();
		
		//closing the container
		((ConfigurableApplicationContext) context).close();	
	}

}
