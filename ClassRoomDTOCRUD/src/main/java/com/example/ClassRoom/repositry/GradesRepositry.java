package com.example.ClassRoom.repositry;

import com.example.ClassRoom.dto.GradeMarksDTO;
import com.example.ClassRoom.entity.ClassRoom;
import com.example.ClassRoom.entity.Grades;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GradesRepositry extends JpaRepository<Grades,Integer> {
    Optional<Grades>findByRollNo(Integer rollNo);
    @Transactional
    void deleteByRollNo(Integer rollNo);

    @Query("select new com.example.ClassRoom.dto.GradeMarksDTO( g.rollNo,(g.maths+g.english+g.cs+g.science+g.hindi),((g.maths+g.english+g.cs+g.science+g.hindi)/5.0)) from Grades g where g.rollNo=:rollNo")
    GradeMarksDTO getMarks(@Param("rollNo") int rollNo);


}
