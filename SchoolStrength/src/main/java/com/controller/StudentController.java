package com.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.School;
import com.bean.Student;
import com.dao.SchoolDAO;


//Provide necessary Annotation
@RestController
public class StudentController {

    //Provide necessary Annotation
	@Autowired
    private SchoolDAO schoolDAO;

  // Provide necessary Annotation and fill code in the below methods
    
	@PostMapping("/registerStudentToSchool/{schoolId}")
	public ResponseEntity<List<Student>> registerStudentToSchool(@PathVariable("schoolId") String schoolId,@RequestBody List<Student> students ) {
		List<Student> registeredStudents = schoolDAO.registerStudentToSchool(schoolId, students);
        return new ResponseEntity<>(registeredStudents,HttpStatus.OK);
}	
}