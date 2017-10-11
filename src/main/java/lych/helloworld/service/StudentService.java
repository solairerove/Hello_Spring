package lych.helloworld.service;

/**
 * Interface for work with Student Service
 */

import lych.helloworld.model.Student;

import java.util.List;

public interface StudentService {

    /**
     * @param student
     * @return "Message about successful work"
     * Implementation addition Student to Data Base
     */
    Student addStudent(Student student);

    /**
     *
     * @param student
     * @return "Message about successful work"
     * Implementation renewal Student in Data Base
     */
    Student updateStudent(Student student);

    /**
     * @param id
     * Implementation delete Student from Data Base by Id
     */
    void removeStudent(Integer id);

    /**
     * @param id
     * @return object of Student class
     * Display Student from Data Base by Id
     */
    Student getStudentById(Integer id);

    /**
     * @return List objects of Student class
     * Display all Students from Data Base
     */
    List<Student> listStudents();
}
