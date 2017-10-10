package lych.helloworld.service;

import lych.helloworld.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    Student updateStudent(Student student);

    void removeStudent(Integer id);

    Student getStudentById(Integer id);

    List<Student> listStudents();
}
