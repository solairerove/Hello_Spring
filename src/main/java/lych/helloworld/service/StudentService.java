package lych.helloworld.service;

import lych.helloworld.model.Student;

import java.util.List;


/**
 * Interface for work with Student Service
 */
public interface StudentService {

    /**
     * Implementation addition Student to Data Base
     *
     * @param student Student student.
     * @return "Message about successful work"
     */
    Student addStudent(final Student student);

    /**
     * Implementation renewal Student in Data Base
     *
     * @param student Student student.
     * @return "Message about successful work"
     */
    Student updateStudent(final Student student);

    /**
     * Implementation delete Student from Data Base by Id
     *
     * @param id Student id.
     */
    void removeStudent(final Integer id);

    /**
     * Display Student from Data Base by Id
     *
     * @param id Student id.
     * @return object of Student class
     */
    Student getStudentById(final Integer id);

    /**
     * Display all Students from Data Base
     *
     * @return List objects of Student class
     */
    List<Student> listStudents();

    /**
     * Display existence of student.
     *
     * @param id Student id.
     * @return boolean value.
     */
    Boolean studentExist(final Integer id);
}
