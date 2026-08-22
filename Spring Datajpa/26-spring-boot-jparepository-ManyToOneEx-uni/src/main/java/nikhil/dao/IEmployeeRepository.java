package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
