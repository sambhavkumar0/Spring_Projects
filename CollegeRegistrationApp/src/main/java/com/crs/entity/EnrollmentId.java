package com.crs.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

//Provide necessary Annotation
@Embeddable
public class EnrollmentId implements Serializable {

    private int studentId;
    private int courseId;

    // Constructors, Getters, Setters, Equals, and HashCode
    public EnrollmentId() {}
    public EnrollmentId(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
       
    public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	// Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentId that = (EnrollmentId) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(studentId, courseId);
}
}