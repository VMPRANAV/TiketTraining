package com.example.StudentManagement.entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document(collection="student_profile")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfile {
    @Id
    private String id;
    @Indexed(unique = true)
    private int rollNo;
    private String firstName;
    private String lastName;
    private String dateOfBirth;



}
