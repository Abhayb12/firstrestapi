package com.firstrestapi.firstrestapi.service;

import com.firstrestapi.firstrestapi.dto.AddStudentRequest;
import com.firstrestapi.firstrestapi.dto.Studentdto;
import com.firstrestapi.firstrestapi.entity.Student;
import com.firstrestapi.firstrestapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Studentdto createNewStudent(AddStudentRequest addStudentRequest) {
        Student newstudent = modelMapper.map(addStudentRequest, Student.class);
        Student student = studentRepository.save(newstudent);
        return modelMapper.map(student, Studentdto.class);
    }

    @Override
    public List<Studentdto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<Studentdto> studentdtolist = students.stream().map( student -> new Studentdto(student.getId(), student.getName(), student.getEmail()))
                .toList();
        return studentdtolist;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("STudent does not exist by the id:" + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Studentdto updateStudent(Long id, AddStudentRequest addStudentRequest) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with the id:" + id));
        modelMapper.map(student, addStudentRequest);

        student = studentRepository.save(student);
        return modelMapper.map(student,Studentdto.class);
    }

    @Override
    public Studentdto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with the id:" + id));

        updates.forEach((field, value) -> {
            switch (field) {
                case  "name": student.setName((String) value);
                break;
                case "email": student.setEmail((String) value);
                break;
                default: throw new IllegalArgumentException("field is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent,Studentdto.class);
    }
}
