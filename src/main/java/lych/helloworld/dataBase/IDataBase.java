package lych.helloworld.dataBase;

import lych.helloworld.model.Student;

import java.util.List;

public interface IDataBase {

    public void addStudent(Student student);

    public void updateStudent(Student student);

    public void removeStudent(Integer id);

    public Student getStudentById(Integer id);

    public List<Student> listStudents();
}
