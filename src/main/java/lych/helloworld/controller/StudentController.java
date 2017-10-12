package lych.helloworld.controller;

import lombok.RequiredArgsConstructor;
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

    @RequestMapping(value = "students/add", method = RequestMethod.POST)
    public ResponseEntity addStudent(@RequestBody Student student) {

        return ResponseEntity.ok().body(defaultStudentService.addStudent(student));
    }

    @RequestMapping(value = "students/update/{id}", method = RequestMethod.POST)
    public ResponseEntity updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {

        Student updateStudent = defaultStudentService.getStudentById(id);
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());

        return ResponseEntity.ok().body(defaultStudentService.updateStudent(updateStudent));
    }

    @RequestMapping("students/remove/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Integer id) {

        Student deletedStudent = defaultStudentService.getStudentById(id);
        defaultStudentService.removeStudent(id);

        return ResponseEntity.ok().body(deletedStudent);
    }

    @RequestMapping("students/student/{id}")
    public ResponseEntity showTheStudent(@PathVariable("id") Integer id) {

        return ResponseEntity.ok().body(defaultStudentService.getStudentById(id));
    }
}