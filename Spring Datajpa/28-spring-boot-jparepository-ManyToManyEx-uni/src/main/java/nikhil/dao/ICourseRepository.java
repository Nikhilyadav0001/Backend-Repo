package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
