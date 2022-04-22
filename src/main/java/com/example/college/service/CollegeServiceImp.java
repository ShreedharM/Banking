package com.example.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.college.data.CollegeData;
import com.example.college.data.StudentData;
import com.example.college.repository.CollegeRepository;
import com.example.college.repository.StudentRepository;
@Service
public class CollegeServiceImp implements CollegeService {
    @Autowired
   CollegeRepository collegerepository;
    @Autowired
    StudentRepository studentrepository;
	@Override
	public void saveAllCollege(CollegeData collegedata) {
		collegerepository.save(collegedata);
		
	}

	@Override
	public void saveAllStudent(StudentData studentdata) {
		studentrepository.save(studentdata);
		
	}

	@Override
	public boolean iscollegeNameExist(String collegeName) {
		return collegerepository.existsBycollegeName(collegeName);
	}

	@Override
	public boolean isstudentNameExist(String studentName) {
		return studentrepository.existsBystudentName(studentName);
	}

	@Override
	public List<StudentData> getByStudentId(int studentId) {
		return studentrepository.getByStudentId(studentId);
	}
	

}
