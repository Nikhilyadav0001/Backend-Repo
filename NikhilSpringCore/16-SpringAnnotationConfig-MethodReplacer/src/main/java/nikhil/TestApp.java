package nikhil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import nikhil.bean.Bank;
import nikhil.config.AppConfig;

public class TestApp {
	public static void main(String[] args) throws Exception {

		// starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Bank bank = context.getBean(Bank.class);
		System.out.println(bank.calculateCompoundInterest(1000000,2,10));
		
		
		// close the container
		((AbstractApplicationContext) context).close();

	}
}
