package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * this class will have all of the resources for the API
 */
@RestController
@RequestMapping(path = "api/v1/student") //localhost:8080/api/v1/student
public class StudentController {

    //how do we tell that this studentService should be injected in to >
    private final StudentService studentService;

    //this constructor right here
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //we want to get something from our server
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);

    }
}
