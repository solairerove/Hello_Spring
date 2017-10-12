package lych.helloworld.repository;

import lych.helloworld.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create interface for work with Spring Data jpa
 * Extends JpaRepository for using his methods
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
