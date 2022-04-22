package com.example.college.data;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="college_data")
public class CollegeData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="college_id")
	private int collegeId;
	@Column(name="college_name")
	private String collegeName;
	@Column(name="created_at")
	private Date createdAt;
	@Column(name="updated_at")
	private Date updatedAt;
	
	@OneToMany(mappedBy = "collegedata" , cascade = CascadeType.ALL )
	private List<StudentData> studentdata;
	public List<StudentData> getStudentdata() {
		return studentdata;
	}
	public void setStudentdata(List<StudentData> studentdata) {
		this.studentdata = studentdata;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	}
