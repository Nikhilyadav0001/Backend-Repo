package nikhil.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nikhil.model.Employee;

public interface IEmployeeService {

	
	//save the Employee
	public void saveRecord(Employee employee);
	
	//get employee list
	public Page<Employee> displayAllRecord(Pageable pageable);
	
	//delete record
	public void deleteRecord(Integer id);
	
	//get employee
	public Employee findEmployee(Integer id);
	
}
