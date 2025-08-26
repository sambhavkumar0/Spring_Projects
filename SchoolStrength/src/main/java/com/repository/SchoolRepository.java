package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bean.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, String> {

    public List<School> findByCity(String city);

    @Query("SELECT s FROM School s WHERE s.city = :city AND SIZE(s.studentList) = (SELECT MAX(SIZE(s2.studentList)) FROM School s2 WHERE s2.city = :city AND SIZE(s2.studentList) > 0)")
    public List<School> findSchoolsWithMaxStudentsInCity(@Param("city") String city);

}