package com.cts;

public class Student {
    private int studentId;
    private String studentName;
    private String course;
    private double courseFees;

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public double getCourseFees() {
        return courseFees;
    }
    public void setCourseFees(double courseFees) {
        this.courseFees = courseFees;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", course=" + course
            + ", courseFees=" + courseFees + "]";
    }
}
