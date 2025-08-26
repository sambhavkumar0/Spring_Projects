package com.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crs.entity.Course;
import com.crs.service.CourseService;

@RestController
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course newCourse = courseService.addCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    @GetMapping("/viewMostEnrolledCourse")
    public ResponseEntity<Course> viewMostEnrolledCourse() {
        Course course = courseService.viewMostEnrolledCourse();
        return ResponseEntity.ok(course);
}
}