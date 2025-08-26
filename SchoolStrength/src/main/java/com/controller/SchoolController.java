package com.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.School;
import com.dao.SchoolDAO;


//Provide necessary Annotation
@RestController
public class SchoolController {

    //Provide necessary Annotation
	@Autowired
    private SchoolDAO schoolDAO;

  // Provide necessary Annotation and fill code in the below methods
	     @PostMapping("/addSchool")
         public ResponseEntity<School> addSchool(@RequestBody School school) {
        	 School addedSchool = schoolDAO.addSchool(school);
             return new ResponseEntity<>(addedSchool, HttpStatus.OK);
        }
    	
	     @GetMapping("/schoolWithMaximumStudents/{city}")
		public ResponseEntity<List<School>> schoolWithMaximumStudents(@PathVariable("city") String city){
	    	 List<School> schools = schoolDAO.schoolWithMaximumStudents(city);
	         return new ResponseEntity<>(schools,HttpStatus.OK);
}
}