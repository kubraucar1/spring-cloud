package com.spring.student.repo;

import com.spring.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
   List<Student> findAllBySchoolId(Integer schoolId);
}
