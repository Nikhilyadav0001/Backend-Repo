package nikhil.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.dao.IStudentDao;
import nikhil.entity.Student;
import nikhil.exception.StudentNotFoundException;

//@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	private IStudentDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(dao.getClass().getName());
		
		/*
		//save operation
		dao.save(new Student(1,"Nikhil","Hayatpur",19));
		
		Student s1 = new Student(2, "sachin", "rewari", 20);
		Student s2 = new Student(3, "kunal", "hayatpur", 19);
		Student s3 = new Student(4, "kartik", "hayatpur", 18);
		dao.saveAll(List.of(s1, s2, s3)).forEach(System.out::println);
	*/
		
	   Optional<Student> optional =	dao.findById(3);
	   // select * from student where sid = ?
	   if (optional.isEmpty()) {
		System.out.println("record not avalable for given id");
	} else {
		Student student = optional.get();
		System.out.println(student);
	}
	   // select * from student where sid = ?
	   Student st =dao.findById(4)
			   			.orElseThrow(
			   					()-> new StudentNotFoundException("no record associated with this exception")
			   					);
	   System.out.println(st);
	   
	// select * from student
	   dao.findAll().forEach(System.out::println);
	   
	   // select * from student where sid IN (?,?,?)
	   dao.findAllById(List.of(2, 3, 9)).forEach(System.out::println);
	   
	   System.out.println("*********************************");
	   
	   if (dao.existsById(7)) {
			System.out.println(dao.findById(7).get());
		}
	   
	   //select count(*) from student
	   long count =dao.count();
	   System.out.println("NO of record in student is "+count);
	   
	}
}
