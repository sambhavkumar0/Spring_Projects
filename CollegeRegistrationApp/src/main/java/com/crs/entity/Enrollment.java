package com.crs.entity;

import java.time.LocalDate;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
//Provide necessary Annotation
@Entity
public class Enrollment {

    //Provide necessary Annotation
	@EmbeddedId
    private EnrollmentId id = new EnrollmentId();

    //Provide necessary Annotation
	@ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    //Provide necessary Annotation
	@ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDate enrollmentDate;
    private Double grade;
    private int attendancePercentage;
    
	public EnrollmentId getId() {
		return id;
	}
	public void setId(EnrollmentId id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public int getAttendancePercentage() {
		return attendancePercentage;
	}
	public void setAttendancePercentage(int attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
	
	public Enrollment() {
		
	}
	public Enrollment(EnrollmentId id, Student student, Course course, LocalDate enrollmentDate, Double grade,
			int attendancePercentage) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
		this.grade = grade;
		this.attendancePercentage = attendancePercentage;
	}

}