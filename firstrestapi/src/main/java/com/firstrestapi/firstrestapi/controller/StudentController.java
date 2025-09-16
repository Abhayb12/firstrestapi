package com.firstrestapi.firstrestapi.controller;

import com.firstrestapi.firstrestapi.dto.AddStudentRequest;
import com.firstrestapi.firstrestapi.dto.Studentdto;
import com.firstrestapi.firstrestapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

//        public StudentController(StudentRepository studentRepository){
//            this.studentRepository = studentRepository;
//        }

    @GetMapping("/Student")
    public List<Studentdto> getStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/student")
    public ResponseEntity<Studentdto> createNewStudent(@RequestBody AddStudentRequest addStudentRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent (addStudentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
    studentService.deleteStudentById(id);
    return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studentdto> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequest addStudentRequest){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequest));
    }

    @PatchMapping("{/id}")
    public ResponseEntity<Studentdto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }
}
