package com.example.ClassRoom.repositry;

import com.example.ClassRoom.entity.ClassRoom;
import com.example.ClassRoom.entity.Grades;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradesRepositry extends JpaRepository<Grades, Integer> {
    Optional<Grades> findByRollNo(Integer rollNo);

    @Transactional
    void deleteByRollNo(Integer rollNo);

}
