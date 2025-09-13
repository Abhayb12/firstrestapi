package com.firstrestapi.firstrestapi.controller;

import com.firstrestapi.firstrestapi.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.firstrestapi.firstrestapi.repository.StudentRepository;



import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

        public StudentController(StudentRepository studentRepository){
            this.studentRepository = studentRepository;
        }

    @GetMapping("/Student")
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
}
