package nikhil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudOrderServiceLoadBalancerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderServiceLoadBalancerClientApplication.class, args);
	}

}
