package nikhil.config;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.bean.Employee;


@Configuration
public class AppConfig {

	static {
		System.out.println("Appconfig.class file loading");
	}
	
	public AppConfig() {
		System.out.println("AppConfig.AppConfig() object is created");
	}
	
	@Bean(name = "emp")
	public Object empObj() {
		
		//creating depndent obj
		List<String> friends = List.of("sher","pal","nikhil");
		Set<String> numbers = Set.of("1234567890","7011752235" ,"0000000000" );
		Map<String, String> accountNumbers = Map.of("axis","1234","hgb","7894");
		
		//creating target object
		Employee employee = new Employee(10,235444.5f,friends,numbers,accountNumbers);
		
		return  employee;
	}
}
