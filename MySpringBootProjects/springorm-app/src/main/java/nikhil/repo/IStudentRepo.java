package nikhil.repo;

import java.util.List;

import nikhil.beans.Student;

public interface IStudentRepo {
	public String saveStudent(Student student);

	public Student findById(Integer sid);

	public String delete(Integer sid);

	public String updateStudent(Student student);
	
	public List<Student> findAllStudents();
}
