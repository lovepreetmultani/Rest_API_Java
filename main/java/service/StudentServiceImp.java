package service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import Repository.StudentRepository;
import entities.Student;
@Service
@Transactional
public class StudentServiceImp implements StudentService {
	
private StudentRepository studentRepository;
	
	public StudentServiceImp(StudentRepository theStudentRepository) {
		studentRepository=theStudentRepository;
	}
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}
	
	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);
		
		Student theStudent=null;
		if(result.isPresent()){
			theStudent=result.get();
		}
		return theStudent;
	}
	@Override
	public Student addStudent(Student theStudent) {
		return studentRepository.save(theStudent);
	}
	@Override
	public Student save(Student thestudent) {
		return studentRepository.save(thestudent);
	}
}
