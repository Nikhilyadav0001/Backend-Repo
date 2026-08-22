package nikhil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nikhil.exception.EmployeeNotFoundException;
import nikhil.model.Employee;
import nikhil.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public void saveRecord(Employee employee) {
		repo.save(employee);
	}

	@Override
	public List<Employee> displayAllRecord() {
		return repo.findAllByOrderByFirstNameAsc();
	}

	@Override
	public void deleteRecord(Integer eid) {
		repo.delete(repo.findById(eid).orElseThrow(
				()->new EmployeeNotFoundException("record not found for deletion")));
	}

	@Override
	public Employee findEmployee(Integer id) {
		Employee emp=repo.findById(id).get();
		return emp;
	}


}
