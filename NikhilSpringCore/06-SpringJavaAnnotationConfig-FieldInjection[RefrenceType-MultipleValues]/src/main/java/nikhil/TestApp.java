package nikhil;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import nikhil.bean.Flipcart;
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
		
		Flipcart bean = context.getBean("flipcart",Flipcart.class);
		System.out.println(bean);
		

		// close the container
		((AbstractApplicationContext) context).close();

	}
}
