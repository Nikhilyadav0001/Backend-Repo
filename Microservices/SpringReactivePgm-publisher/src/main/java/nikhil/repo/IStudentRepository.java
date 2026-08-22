package nikhil.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import nikhil.entity.Student;

public interface IStudentRepository extends ReactiveMongoRepository<Student, String> {

}
