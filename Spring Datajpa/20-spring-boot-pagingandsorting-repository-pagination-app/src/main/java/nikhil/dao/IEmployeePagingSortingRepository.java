package nikhil.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import nikhil.entity.Employee;

public interface IEmployeePagingSortingRepository extends PagingAndSortingRepository<Employee, Integer> {

}
