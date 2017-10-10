package lych.helloworld.repository;

import lych.helloworld.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student,Integer>{
}
