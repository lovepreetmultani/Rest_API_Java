package RestController;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Repository.StudentRepository;
import entities.Student;
import service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService theStudentService) {
		studentService=theStudentService;
	}
	
	@PostMapping("/students/")
	public Student addStudent(@RequestBody Student theStudent) {
		
		studentService.save(theStudent);
		
		return theStudent;
	}
	
	@PutMapping("/students/{id}")
	public Student editStudent(@RequestBody Student theStudent, @PathVariable Integer id) {

		Optional<Student> studentOp=Optional.ofNullable(studentService.findById(id));
		
		if(studentOp.isPresent()) {
			studentService.save(theStudent);
		}
		return theStudent;	
	}
	
	@GetMapping("/students")
	public List<Student> findAll(){
		return studentService.getAllStudents();
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Student theEmployee=studentService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeErrorException(null, "not found");
		}
		studentService.deleteById(employeeId);
		
		return "Deleted employee id-"+employeeId;	
	}
}
