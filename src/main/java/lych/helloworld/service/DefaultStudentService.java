package lych.helloworld.service;

import lombok.RequiredArgsConstructor;
import lych.helloworld.model.Student;
import lych.helloworld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultStudentService implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(final Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(final Student student) {

        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(final Integer id) {

        studentRepository.delete(id);
    }

    @Override
    public Student getStudentById(final Integer id) {

        return studentRepository.findOne(id);
    }

    @Override
    public List<Student> listStudents() {
        return studentRepository.findAll();
    }
}
