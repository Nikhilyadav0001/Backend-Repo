package nikhil.dao;

import org.springframework.data.repository.CrudRepository;

import nikhil.entity.Student;

public interface IStudentDao extends CrudRepository<Student, Integer> {

}
