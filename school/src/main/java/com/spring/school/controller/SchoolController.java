package com.spring.school.controller;

import com.spring.school.entity.School;
import com.spring.school.response.FullStudentsOfSchoolResponse;
import com.spring.school.service.SchoolService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    public String insertSchool(@RequestBody School  school){
        schoolService.insertSchool(school);
        return "kayıt başarılı";
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools(){
       return ResponseEntity.ok(schoolService.getAllSchools());
    }
    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullStudentsOfSchoolResponse> findAllStudentsOfSchool(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(schoolService.findStudentsofSchool(schoolId));
    }
}
