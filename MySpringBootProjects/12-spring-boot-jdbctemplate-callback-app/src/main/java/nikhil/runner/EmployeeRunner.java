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

		EmployeeDTO employee = service.fetchEmployeeByNo(6);
		System.out.println(employee);
		System.out.println("*********************************");
		service.fetchEmployeeByDesg("batman", "kamchor").forEach(System.out::println);
		System.out.println("**************************************");
		service.fetchAllEmployees().forEach(System.out::println);

	}
}
