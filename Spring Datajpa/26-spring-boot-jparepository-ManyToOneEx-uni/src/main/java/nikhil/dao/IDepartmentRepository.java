package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

}
