package com.crs.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crs.entity.Enrollment;
import com.crs.entity.EnrollmentId;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {
	
    List<Enrollment> findByEnrollmentDate(LocalDate enrollmentDate);
    
    List<Enrollment> findByCourseInstructor(String instructor);
}