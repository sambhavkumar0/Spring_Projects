package com.crs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crs.entity.Course;
import com.crs.repository.CourseRepository;

@Service
public class CourseService {
	
    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course viewMostEnrolledCourse() {
        return courseRepository.findMostEnrolledCourse();
}
}