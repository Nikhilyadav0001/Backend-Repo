package nikhil.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.service.IProductService;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private IProductService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.fetchProductsByName("mac", "rog").forEach(System.out::println);
	}
}