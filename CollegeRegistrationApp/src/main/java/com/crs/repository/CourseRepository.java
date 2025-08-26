package com.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.crs.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {  
    
	@Query("SELECT c FROM Course c WHERE SIZE(c.enrollments) = (SELECT MAX(SIZE(c2.enrollments)) FROM Course c2)")
	Course findMostEnrolledCourse();
}