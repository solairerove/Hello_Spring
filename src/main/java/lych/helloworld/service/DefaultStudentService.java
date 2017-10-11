package lych.helloworld.service;

import lych.helloworld.model.Student;
import lych.helloworld.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultStudentService implements StudentService {

    private final StudentsRepository studentsRepository;

    @Autowired
    public DefaultStudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public Student addStudent(Student student) {

        return studentsRepository.saveAndFlush(student);
    }

    @Override
    public Student updateStudent(Student student) {

        return studentsRepository.saveAndFlush(student);
    }

    @Override
    public void removeStudent(Integer id) {

        studentsRepository.delete(id);
    }

    @Override
    public Student getStudentById(Integer id) {

        return studentsRepository.findOne(id);
    }

    @Override
    public List<Student> listStudents() {
        return studentsRepository.findAll();
    }
}
