package com.example.college.validation;

import java.util.Date;

import org.springframework.http.ResponseEntity;

import com.example.college.data.CollegeData;
import com.example.college.data.ResponseData;
import com.example.college.data.StudentData;
import com.example.college.service.CollegeService;

public class CollegeValidation {

	public static ResponseEntity<ResponseData<String>> insertCollegeData(CollegeData collegedata,
			CollegeService collegeservice) {
		ResponseData<String> response = new ResponseData<String>();
		response.setStatusCode(400);
		if(collegedata.getCollegeName()==null || collegedata.getCollegeName().isEmpty()) {
			response.setMessage("Enter the CollegeName");
			return ResponseEntity.badRequest().body(response);
		}
		if(collegeservice.iscollegeNameExist(collegedata.getCollegeName())) {
			response.setMessage("CollegeName Already Exist");
			return ResponseEntity.badRequest().body(response);
		}
		collegedata.setCreatedAt(new Date());
		collegedata.setUpdatedAt(new Date());
		response.setStatusCode(200);
		response.setMessage("Data Inserted Successfully");
		return ResponseEntity.ok(response);
	}

	public static ResponseEntity<ResponseData<String>> insertStudentData(StudentData studentdata,
			CollegeService collegeservice) {
		ResponseData<String> response = new ResponseData<String>();
		response.setStatusCode(400);
		if(studentdata.getStudentName()==null || studentdata.getStudentName().isEmpty()) {
			response.setMessage("Enter the StudentName");
			return ResponseEntity.badRequest().body(response);
		}
		if(collegeservice.isstudentNameExist(studentdata.getStudentName())){
			response.setMessage("StudentName Already Exist");
			return ResponseEntity.badRequest().body(response);
		}
		studentdata.setCreatedAt(new Date());
		studentdata.setUpdatedAt(new Date());
		response.setStatusCode(200);
		response.setMessage("Data Inserted Successfully");
		return ResponseEntity.ok(response);
	}




}
