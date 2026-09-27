package com.example.StudentManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentResponseDTO {
    @Id
    private String id;
    private int rollNo;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
}
