package nikhil;

import nikhil.bean.Employee;

public class TestApp {
	public static void main(String[] args) {
		Employee emp= new Employee();
		emp.setEid(10);
		emp.setEname("nikhil");
		emp.setEaddress("hayatpur");
		
		System.out.println(emp);
		System.out.println(new Employee(1,"sachin","rewari"));
	}
}
