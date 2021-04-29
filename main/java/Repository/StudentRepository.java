package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
