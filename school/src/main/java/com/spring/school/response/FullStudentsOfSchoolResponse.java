package com.spring.school.response;

import com.spring.school.entity.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullStudentsOfSchoolResponse {
    private String name;
    private String email;
    List<Student> students;

}
