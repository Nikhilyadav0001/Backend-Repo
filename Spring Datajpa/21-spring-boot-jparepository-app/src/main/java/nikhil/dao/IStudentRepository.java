package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}