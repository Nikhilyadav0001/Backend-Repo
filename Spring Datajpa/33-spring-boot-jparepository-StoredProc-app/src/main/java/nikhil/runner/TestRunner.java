package nikhil.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.service.IEmployeeService;


@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		service.searchEmpByDesgs("DEV", "QR").forEach(System.out::println);
		
		
	}
}
