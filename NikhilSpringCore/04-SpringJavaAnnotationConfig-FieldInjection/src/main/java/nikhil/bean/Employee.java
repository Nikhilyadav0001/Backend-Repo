package nikhil.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
		static {
			System.out.println("Employee.class file is loading...");
		}
		
		@Value("${info.emp.eid}")
		private Integer eid;
		
		@Value("${info.emp.ename}")
		private String ename;
		
		@Value("${info.emp.eage}")
		private Float eage;
		
		public Employee() {
			System.out.println("Employee.Employee() zero param constructer");
		}
		
		@Override
		public String toString() {
			return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + "]";
		}
		
		
	
}
