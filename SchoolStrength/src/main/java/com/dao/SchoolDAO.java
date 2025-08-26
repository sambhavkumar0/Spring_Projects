package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bean.School;
import com.bean.Student;
import com.repository.SchoolRepository;
import com.repository.StudentRepository;

@Service
public class SchoolDAO {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<Student> registerStudentToSchool(String schoolId, List<Student> students) {
        Optional<School> schoolOptional = schoolRepository.findById(schoolId);
        if (schoolOptional.isPresent()) {
            School school = schoolOptional.get();
            for (Student student : students) {
                student.setSchool(school);
            }
            return studentRepository.saveAll(students);
        }
        return new ArrayList<>();
    }

    public List<School> schoolWithMaximumStudents(String city) {
        // The logic is now handled by the custom query in the repository.
        return schoolRepository.findSchoolsWithMaxStudentsInCity(city);
}
}