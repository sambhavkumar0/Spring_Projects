package com.crs.entity;

import java.util.List;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//Provide necessary Annotation
@Entity
public class Course {

    //Provide necessary Annotation
	@Id
    private int courseId;
   
    private String courseName;
    private String instructor;
    private int credits;

    //Provide necessary Annotation
    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Enrollment> enrollments;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public Course() {
		
	}

	public Course(int courseId, String courseName, String instructor, int credits, List<Enrollment> enrollments) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.instructor = instructor;
		this.credits = credits;
		this.enrollments = enrollments;
	}
	
	
}