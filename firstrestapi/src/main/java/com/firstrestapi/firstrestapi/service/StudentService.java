package com.firstrestapi.firstrestapi.service;

import com.firstrestapi.firstrestapi.dto.AddStudentRequest;
import com.firstrestapi.firstrestapi.dto.Studentdto;
import com.firstrestapi.firstrestapi.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {



   Studentdto createNewStudent(AddStudentRequest addStudentRequest);

    List<Studentdto> getAllStudent();

    List<Student> findAll();

    void deleteStudentById(Long id);

    Studentdto updateStudent(Long id, AddStudentRequest addStudentRequest);

    Studentdto updatePartialStudent(Long id, Map<String, Object> updates);
}
