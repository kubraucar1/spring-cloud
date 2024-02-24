package com.spring.school.service;

import com.spring.school.client.StudentClient;
import com.spring.school.entity.School;
import com.spring.school.repoo.SchoolRepository;
import com.spring.school.response.FullStudentsOfSchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
private final StudentClient  studentClient;
    public void insertSchool(School school){
        schoolRepository.save(school);
    }

    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    public FullStudentsOfSchoolResponse findStudentsofSchool(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND").build());
       var students = studentClient.findAllStudentsBySchool(schoolId);

        return FullStudentsOfSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();

    }
}
