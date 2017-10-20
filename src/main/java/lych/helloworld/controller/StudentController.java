package lych.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lych.helloworld.exception.NoExistException;
import lych.helloworld.exception.NullFieldException;
import lych.helloworld.model.Student;
import lych.helloworld.service.DefaultStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {

    private final DefaultStudentService defaultStudentService;

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public ResponseEntity listStudents() {

        return ResponseEntity.ok().body(defaultStudentService.listStudents());
    }

    @RequestMapping(value = "students", method = RequestMethod.POST)
    public ResponseEntity addStudent(@RequestBody Student student) throws NullFieldException {

        if (student.getLastName() == null || student.getFirstName() == null) throw new NullFieldException();
        else return ResponseEntity.ok().body(defaultStudentService.addStudent(student));
    }

    @RequestMapping(value = "students/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) throws NullFieldException, NoExistException {

        if (student.getFirstName() == null || student.getLastName() == null) throw new NullFieldException();

        if (defaultStudentService.studentExist(id)) {

            Student updateStudent = defaultStudentService.getStudentById(id);
            updateStudent.setFirstName(student.getFirstName());
            updateStudent.setLastName(student.getLastName());

            return ResponseEntity.ok().body(defaultStudentService.updateStudent(updateStudent));
        } else throw new NoExistException();
    }

    @RequestMapping(value = "students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable("id") Integer id) throws NoExistException {

        if (defaultStudentService.studentExist(id)) {
            Student deletedStudent = defaultStudentService.getStudentById(id);
            defaultStudentService.removeStudent(id);

            return ResponseEntity.ok().body(deletedStudent);
        } else throw new NoExistException();
    }

    @RequestMapping(value = "students/{id}", method = RequestMethod.GET)
    public ResponseEntity showTheStudent(@PathVariable("id") Integer id) throws NoExistException {
        if (defaultStudentService.studentExist(id)) {

            return ResponseEntity.ok().body(defaultStudentService.getStudentById(id));
        } else throw new NoExistException();
    }
}