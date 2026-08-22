package nikhil.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import nikhil.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MyRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		String baseUrl = "http://localhost:9999/v1/api/student";
		
		Mono<Student> result = WebClient .create(baseUrl) 
									.post() 
									.uri("/create")
									.body(Mono.just(new Student("ID.2", "Kartik", 165410.0)),Student.class)
									.retrieve() 
									.bodyToMono(Student.class);
		System.out.println("******create *****");
		//result.subscribe(System.out::println); subscribe return decomposible
		result.subscribe(res -> System.out.println(res+"student created"));
	  
		System.out.println("**************************************************");
		System.out.println();
		Flux<Student> flux = WebClient.create(baseUrl)
									.get()
									.uri("/findAll")
									.retrieve() 
									.bodyToFlux(Student.class);
	  
		System.out.println("*****Flux find all Response**********");
		flux.doOnNext(System.out::println).blockLast();
	  
	  
		System.out.println("**************************************************");
		System.out.println();
	  
		Mono<Student> bodyToMono = WebClient.create(baseUrl)
										.get()
										.uri("/fetch/ID.2")
										.retrieve() 
										.bodyToMono(Student.class);
	  
		System.out.println("****** fetch id*****");
		bodyToMono.subscribe(res -> System.out.println(res+"student fetch"));
	  
		System.out.println("**************************************************");
		System.out.println();
		 

		System.out.println("***Executing delete method call **********");
		Mono<Void> mono = WebClient.create(baseUrl)
									.method(HttpMethod.DELETE)
									.uri("/delete/ID.1")
									.retrieve()
									.bodyToMono(Void.class);
		
		System.out.println("******** delete id *******");
		
		//mono.subscribe(System.out::println);
		mono.block();
		System.out.println("Deleted successfully");
									
		/*
		*/
	}
		
}
