package nikhil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import nikhil.bean.VoterVerifier;
import nikhil.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		
		//starting the contaner
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//asking the ioccontainer to give the bean with the id as specified
		VoterVerifier bean = context.getBean("voter",VoterVerifier.class);
		System.out.println(bean.checkVotingEligibility());
		
		//closing the container
		((AbstractApplicationContext) context).close();
	}
}
