package nikhil.dao;

import org.springframework.data.repository.CrudRepository;

import nikhil.entity.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

}
