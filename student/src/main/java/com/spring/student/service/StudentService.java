package com.spring.student.service;

import com.spring.student.entity.Student;
import com.spring.student.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void insertStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
       return studentRepository.findAll();
    }

    public List<Student> getStudentsSchool(Integer schoolId) {
       return studentRepository.findAllBySchoolId(schoolId);
    }
}
