package com.bean;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "school")
public class School {

    @Id
    @Column(name = "school_id")
    private String schoolId;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "school_type")
    private String schoolType;
    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Student> studentList = new ArrayList<Student>();

    public String getSchoolId() {
        return schoolId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getCity() {
        return city;
    } 
    
    
    
    public void setCity(String city) {
    	this.city=city;
    	}
}