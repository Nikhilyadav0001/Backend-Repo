package nikhil.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.beans.EmployeeDTO;
import nikhil.service.IEmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService service;

	@Override
	public void run(String... args) throws Exception {
		int count = service.registerEmployee(new EmployeeDTO("chita", "kamchor", 34000.0f, 3, 5));
		System.out.println("No of records inserted is :: " + count);
	}
}