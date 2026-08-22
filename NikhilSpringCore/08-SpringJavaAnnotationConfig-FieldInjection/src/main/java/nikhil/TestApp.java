package nikhil;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import nikhil.beans.Flipkart;
import nikhil.config.AppConfig;


public class TestApp {
	public static void main(String[] args) {

		// starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		
		String[] definitionNames = context.getBeanDefinitionNames();
		for (String beanname : definitionNames) {
			System.out.println(beanname);
		}
		System.out.println(definitionNames);
		
		Flipkart bean = context.getBean("flipkart",Flipkart.class);
		String status =bean.shopping(new String[] {"iphone 17","ipad 11"}, new float[] {83000f,33000f});
		System.out.println(status);
		
		// close the container
		((AbstractApplicationContext) context).close();

	}
}
