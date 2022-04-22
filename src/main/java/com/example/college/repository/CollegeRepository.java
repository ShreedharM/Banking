package com.example.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.college.data.CollegeData;

public interface CollegeRepository extends JpaRepository<CollegeData , Long> {

	boolean existsBycollegeName(String collegeName);

}
