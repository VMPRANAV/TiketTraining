package com.example.StudentManagement.repositry;

import com.example.StudentManagement.entity.StudentProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositry extends MongoRepository<StudentProfile, String> {
    List<StudentProfile> findAll();

    @Query(value = "{'firstName':?0 }")
    StudentProfile findByFirstName(String firstName);

    StudentProfile findByRollNo(int rollNo);

    @Query(value = "{}", count = true)
    int getTotalCount();

    @Query(value = "{ 'lastName' : ?0 }")
    List<StudentProfile> findByLastName(String lastName);

    boolean existsByRollNo(int rollNo);


}
