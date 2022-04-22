package com.example.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.college.data.StudentData;

public interface StudentRepository extends JpaRepository<StudentData , Long> {


	boolean existsBystudentName(String studentName);
    @Query( value = "SELECT * FROM student_data where student_id=:studentId", nativeQuery=true)
	
	List<StudentData> getByStudentId(int studentId);

}
