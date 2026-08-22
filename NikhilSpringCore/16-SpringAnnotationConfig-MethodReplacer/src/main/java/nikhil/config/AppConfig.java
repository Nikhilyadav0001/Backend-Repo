package nikhil.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "nikhil")
@ImportResource(locations = "nikhil/cfgs/applicationContext.xml")
public class AppConfig {

}
