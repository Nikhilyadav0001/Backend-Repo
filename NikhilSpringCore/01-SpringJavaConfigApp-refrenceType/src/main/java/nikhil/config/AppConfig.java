package nikhil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.bean.Employee;

@Configuration
public class AppConfig {

	static {
		System.err.println("Appconfig.class file loading");
	}
	
	public AppConfig() {
		System.out.println("AppConfig.AppConfig() object is created");
	}
	
	@Bean(name = "emp")
	public Employee empObj() {
		System.out.println("AppConfig.empObj() object is created");
		
		//creating employee object using zero param constructer
		Employee employee =new Employee();
		
		//injecting values through setters 
		employee.setEid(10);
		employee.setEname("nikhil");
		employee.setEage(19);
		employee.setEaddress("hayatpur");
		return employee;
	}
}
