package nikhil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nikhil.entity.Student;
import nikhil.repo.IStudentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository repo;
	
	@Override
	public Mono<Student> saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Mono<Student> getOneStudentInfo(String id) {
		return repo.findById(id).switchIfEmpty(Mono.empty());
	}

	@Override
	public Flux<Student> findAllStudents() {
		return repo.findAll();
	}

	@Override
	public Mono<Void> deleteStudent(String id) {
		return repo.deleteById(id);
	}

}
