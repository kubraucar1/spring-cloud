package com.spring.school.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student
{
    private String name;
    private String lastName;
    private String email;
}
