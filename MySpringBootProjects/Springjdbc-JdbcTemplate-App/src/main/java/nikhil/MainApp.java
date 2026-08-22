package nikhil;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import nikhil.config.AppConfig;
import nikhil.service.IEmployeeMgmtService;

public class MainApp {

	public static void main(String[] args) {
		//start the container
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		IEmployeeMgmtService service = applicationContext.getBean(IEmployeeMgmtService.class);
	
		/*System.out.println("no of employees is::"+service.fetchEmployeeCount());
		System.out.println("salary of employee is::" + service.fetchEmployeeSalaryByEno(3));
		service.fetchEmployeeByEno(2).entrySet()
					.forEach(row -> System.out.print("\t"+row.getKey()+"==="+ row.getValue()));
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		service.fetchEmployeeByDesgn("chor", "kamchor")
	    .forEach(map ->
	        map.entrySet().forEach(row -> {
	            System.out.print("\t" + row.getKey() + "===" + row.getValue());
	            System.out.println("\n");
	        })
	    );*/
		
		int count =service.registerEmployee("rohit", "caption", 35000f, 12, 30);
		System.out.println("no of record inserted is"+count);
		
		//close the container
		applicationContext.close();
	}

}
