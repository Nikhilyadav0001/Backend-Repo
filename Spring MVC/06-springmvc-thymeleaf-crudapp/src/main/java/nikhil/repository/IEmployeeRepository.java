package nikhil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByFirstNameAsc();
}
