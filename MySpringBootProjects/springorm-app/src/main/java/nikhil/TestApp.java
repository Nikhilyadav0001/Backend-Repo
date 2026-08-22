package nikhil;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import nikhil.beans.Student;
import nikhil.config.AppConfig;
import nikhil.repo.IStudentRepo;

public class TestApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IStudentRepo repo = context.getBean(IStudentRepo.class);

		
		repo.findAllStudents().forEach(System.out::println);
		
		System.out.println("*******************************************************");
		Student student = repo.findById(2);
		System.out.println(student);
		
		System.out.println("*******************************************************");
		Student stdUpdate = new Student();
		stdUpdate.setSid(1);
		stdUpdate.setSaddress("Hayatpur");
		stdUpdate.setSage(12);
		stdUpdate.setSname("Nikhil");
		
		System.out.println(repo.updateStudent(stdUpdate));
		
		context.close();
	}
}
