package lych.helloworld.service;

import lych.helloworld.dataBase.DataBaseImpl;
import lych.helloworld.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    DataBaseImpl dataBase;
    @Override
    @Transactional
    public void addStudent(Student student) {
        this.dataBase.addStudent(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        this.dataBase.updateStudent(student);
    }

    @Override
    @Transactional
    public void removeStudent(Integer id) {
         this.dataBase.removeStudent(id);
    }

    @Override
    @Transactional
    public Student getStudentById(Integer id) {
        return this.dataBase.getStudentById(id);
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        return this.dataBase.listStudents();
    }
}
