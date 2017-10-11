package lych.helloworld.controller;

import lych.helloworld.model.Student;
import lych.helloworld.service.DefaultStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private DefaultStudentService defaultStudentService;

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public ResponseEntity listStudents() {

        List<Student> studentList = this.defaultStudentService.listStudents();
        return ResponseEntity.ok().body(studentList);
    }

    @RequestMapping(value = "students/add", method = {RequestMethod.POST})
    public ResponseEntity addStudent(Student student) {
        if (student.getId() == 0) {
            this.defaultStudentService.addStudent(student);
        } else this.defaultStudentService.updateStudent(student);
        return ResponseEntity.ok().body("Student added");
    }

    @RequestMapping("students/remove/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Integer id) {
        this.defaultStudentService.removeStudent(id);

        return ResponseEntity.ok().body("Student deleted");
    }

    @RequestMapping("students/student/{id}")
    public ResponseEntity showTheStudent(@PathVariable("id") Integer id) {
        Student student = this.defaultStudentService.getStudentById(id);

        return ResponseEntity.ok().body(student);
    }
}