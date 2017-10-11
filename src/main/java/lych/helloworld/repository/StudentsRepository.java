package lych.helloworld.repository;

/**
 * Create interface for work with Spring Data jpa
 * Extends JpaRepository for using his methods
 */

import lych.helloworld.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student,Integer>{
}
