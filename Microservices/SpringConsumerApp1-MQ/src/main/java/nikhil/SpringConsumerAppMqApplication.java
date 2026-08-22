package nikhil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class SpringConsumerAppMqApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConsumerAppMqApplication.class, args);
	}

}