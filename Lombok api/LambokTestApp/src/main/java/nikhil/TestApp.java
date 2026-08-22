package nikhil;

import nikhil.bean.Employee;

public class TestApp {

	public static void main(String[] args) {
		Employee emp1 = new Employee(10,"Nikhil","hr",10000f);
		System.out.println(emp1);
		
		Employee emp2 = new Employee();
		emp2.setEid(2);
		emp2.setSname("sherr");
		emp2.setSaddress("hr");
		System.out.println(emp2);
		
		Employee emp3 = new Employee(1,"sachin","hr");
		System.out.println(emp3);
	}
}
