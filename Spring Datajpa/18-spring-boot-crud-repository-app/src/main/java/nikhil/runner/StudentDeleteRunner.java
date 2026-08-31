package nikhil.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.dao.IStudentDao;
import nikhil.entity.Student;
import nikhil.exception.StudentNotFoundException;

@Component
public class StudentDeleteRunner implements CommandLineRunner {

	@Autowired
	private IStudentDao dao;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		dao.deleteById(9);
		System.out.println("record deleted by id");
		
		Student student = new Student();
		student.setSid(10);
		student.setSname("sachin");
		student.setSage(52);
		student.setSaddress("MI");
		dao.delete(student);

		dao.delete(dao
					.findById(9)
						.orElseThrow(
								()-> new StudentNotFoundException(
				String.format("Record for %s object not avalable for the id %d", String.class.getName() ,100)
											)
						)		
				);
		
		//delete all with 10,11
		dao.deleteAllById(List.of(10,11));
		
	}

}
