package com.example.college.service;

import java.util.List;

import com.example.college.data.CollegeData;
import com.example.college.data.StudentData;

public interface CollegeService {

	void saveAllCollege(CollegeData collegedata);

	void saveAllStudent(StudentData studentdata);

	boolean iscollegeNameExist(String collegeName);

	boolean isstudentNameExist(String studentName);

	List<StudentData> getByStudentId(int studentId);


}
