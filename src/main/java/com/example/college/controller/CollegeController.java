package com.example.college.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.college.data.CollegeData;
import com.example.college.data.ResponseData;
import com.example.college.data.StudentData;
import com.example.college.service.CollegeService;
import com.example.college.validation.CollegeValidation;

@RestController
@RequestMapping("/api/v1/college")
public class CollegeController {
	@Autowired
	CollegeService collegeservice;
	@PostMapping("/insertCollegeData")
	public ResponseEntity<ResponseData<String>> insertCollegeData(@RequestBody CollegeData collegedata){
		ResponseEntity<ResponseData<String>>validation = CollegeValidation.insertCollegeData(collegedata , collegeservice);
		if(validation.getStatusCode().value()==200) {
			collegeservice.saveAllCollege(collegedata);
			return validation;
		}
		return validation;
		}
	@PostMapping("/insertStudentData")
	public ResponseEntity<ResponseData<String>> insertStudentData(@RequestBody StudentData studentdata){
		ResponseEntity<ResponseData<String>>validation = CollegeValidation.insertStudentData(studentdata , collegeservice);
		if(validation.getStatusCode().value()==200) {
			collegeservice.saveAllStudent(studentdata);
			return validation;
		}
		return validation;
	}
	@GetMapping("/getByStudentId")
	public ResponseEntity<ResponseData<List<StudentData>>> getByStudentId(@RequestBody StudentData studentdata){
		ResponseData<List<StudentData>> response = new ResponseData<List<StudentData>>();
		response.setStatusCode(200);
		response.setMessage("Data Fetched SuccessFully");
		response.setData(collegeservice.getByStudentId(studentdata.getStudentId()));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	 @PostMapping(value = "/fileUpload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
     public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
		    File convertFile = new File("C:\\Users\\shree\\Documents" + file.getOriginalFilename());
		    convertFile.createNewFile();
            try (FileOutputStream out = new FileOutputStream(convertFile)){
		      out.write(file.getBytes());
		    }
		    catch (Exception exe){
		      exe.printStackTrace();
		    }
		    return "File uploaded ";
		  }
     @GetMapping("/fileDownload")
     public ResponseEntity<Object> downloadFile() throws IOException{
	    String filename = "C:\\Users\\shree\\Documents\\java\\Arrays.java";
	    File file = new File(filename);
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
	    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	    headers.add("Pragma", "no-cache");
	    headers.add("Expires", "0");
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
        return responseEntity;
	  }


}
