package lych.helloworld.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lych.helloworld.model.Student;
import lych.helloworld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultStudentService implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(final Student student) {

        log.info("Student added");

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(final Student student) {

        log.info("Student updated");

        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(final Integer id) {

        log.info("Student removed");

        studentRepository.delete(id);
    }

    @Override
    public Student getStudentById(final Integer id) {

        log.info("Student displayed");

        return studentRepository.findOne(id);
    }

    @Override
    public List<Student> listStudents() {

        log.info("Students were displayed");

        return studentRepository.findAll();
    }

    @Override
    public Boolean studentExist(Integer id) {

        log.info("Find student");

        return studentRepository.exists(id);
    }
}
