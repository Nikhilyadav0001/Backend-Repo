package nikhil.runner;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.dao.ICustomerRepository;
import nikhil.entity.Customer;


@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Customer cust = new Customer(10,"Nikhil", "Hayatpur", 
				LocalDateTime.of(2006, 4,17, 17, 45, 3), 
				LocalTime.now(),
				LocalDate.now());

		repo.save(cust);
		System.out.println("*****Customer object is saved******");
		
		repo.findAll().forEach(System.out::println);
	}
}
