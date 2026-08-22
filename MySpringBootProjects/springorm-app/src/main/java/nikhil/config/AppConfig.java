package nikhil.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "nikhil")
@Import(PersistenceConfig.class)
public class AppConfig {

	
	
	
}
