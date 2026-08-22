package nikhil.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages="nikhil")
public class AppConfig {

	static {
		System.out.println("Appconfig.class file loading");
	}
	
	public AppConfig() {
		System.out.println("AppConfig.AppConfig() object is created");
	}
}
