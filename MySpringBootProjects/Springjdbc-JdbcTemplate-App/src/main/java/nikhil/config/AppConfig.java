package nikhil.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistanceConfig.class)
@ComponentScan(basePackages = "nikhil")
public class AppConfig {

}
