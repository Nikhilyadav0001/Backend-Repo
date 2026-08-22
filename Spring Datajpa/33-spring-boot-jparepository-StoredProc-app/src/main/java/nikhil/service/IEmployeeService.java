package nikhil.service;

import java.util.List;

import nikhil.entity.Employee;

public interface IEmployeeService {

	public List<Employee> searchEmpByDesgs(String desg1,String desg2);
}
