package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Student;


public interface StudentService{
	
	public List<Student> getAllStudents();
	
	public void deleteById(int theId);

	public Student findById(int theId);

	public Student addStudent(Student theStudent);
	
	public Student save(Student thestudent);
}
