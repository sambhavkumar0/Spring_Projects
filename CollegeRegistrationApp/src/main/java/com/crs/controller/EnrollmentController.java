package com.crs.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crs.entity.Enrollment;
import com.crs.entity.EnrollmentId;
import com.crs.exception.InvalidEntityException;
import com.crs.service.EnrollmentService;

@RestController
public class EnrollmentController {
	
    @Autowired
    private EnrollmentService enrollmentService;
    
    @PostMapping("/addEnrollment/{studentId}/{courseId}")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment, @PathVariable int studentId, @PathVariable int courseId) throws InvalidEntityException {
        Enrollment newEnrollment = enrollmentService.addEnrollment(enrollment, studentId, courseId);
        return ResponseEntity.ok(newEnrollment);
    }

    @PutMapping("/updateStudentGrade/{studentId}/{courseId}/{grade}")
    public ResponseEntity<Enrollment> updateStudentGrade(@PathVariable int studentId, @PathVariable int courseId, @PathVariable double grade) throws InvalidEntityException {
        EnrollmentId enrollmentId = new EnrollmentId(studentId, courseId);
        Enrollment updatedEnrollment = enrollmentService.updateStudentGrade(enrollmentId, grade);
        return ResponseEntity.ok(updatedEnrollment);
    }

    @GetMapping("/viewEnrollmentByDate/{enrollmentDate}")
    public ResponseEntity<List<Enrollment>> viewEnrollmentByDate(@PathVariable LocalDate enrollmentDate) {
        List<Enrollment> enrollments = enrollmentService.viewEnrollmentByDate(enrollmentDate);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/viewEnrollmentsByInstructor/{instructor}")
    public List<Enrollment> viewEnrollmentsByInstructor(@PathVariable String instructor) {
        return enrollmentService.viewEnrollmentsByInstructor(instructor);
}
}