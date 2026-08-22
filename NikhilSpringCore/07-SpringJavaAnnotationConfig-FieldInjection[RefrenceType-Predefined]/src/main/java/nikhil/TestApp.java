package nikhil;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import nikhil.config.AppConfig;
import nikhil.dao.EmployeeMySQLDaoImpl;

public class TestApp {
	public static void main(String[] args) {

		// starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		
		String[] definitionNames = context.getBeanDefinitionNames();
		for (String beanname : definitionNames) {
			System.out.println(beanname);
		}
		System.out.println(definitionNames);
		
		EmployeeMySQLDaoImpl daoImpl = context.getBean("mysqlDao",EmployeeMySQLDaoImpl.class);
		System.out.println(daoImpl);
		daoImpl.getConnection();

		// close the container
		((AbstractApplicationContext) context).close();

	}
}
