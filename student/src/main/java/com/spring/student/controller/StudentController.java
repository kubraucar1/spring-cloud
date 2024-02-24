package com.spring.student.controller;

import com.spring.student.entity.Student;
import com.spring.student.service.StudentService;
import jakarta.ws.rs.HttpMethod;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public String insertStudent(@RequestBody  Student student){
        studentService.insertStudent(student);
        return "Student added";
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){{

    return ResponseEntity.ok(studentService.getAllStudents()); }
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> getStudentsSchool(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(studentService.getStudentsSchool(schoolId));
    }
}
