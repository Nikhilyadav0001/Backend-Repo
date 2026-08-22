package nikhil.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nikhil.bean.WishMassageGenerator;

@Configuration
public class AppConfig {

	static {
		System.out.println("Appconfig.class file loading");
	}
	
	public AppConfig() {
		System.out.println("AppConfig.AppConfig() object is created");
	}
	
	@Bean(name = "wmg")
	public WishMassageGenerator wmgObj() {
		System.out.println("AppConfig.wmgObj() object is created");
		
		//create target object
		WishMassageGenerator generator = new WishMassageGenerator();
		//create dependent object
		LocalDateTime ldt = LocalDateTime.now();
		//lining the object using setter style
		generator.setLdt(ldt);
		
		return generator;
	}
}
