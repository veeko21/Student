package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    //instead of the list we want to use this and add it to constructor
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //instead of saying that we will return this list > return List.of();
    public List<Student> getStudents() {
        return studentRepository.findAll();//this returns a list to us
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }
}
