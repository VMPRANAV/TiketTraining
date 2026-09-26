package com.example.ClassRoom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Integer rollNo;
    private String studentName;
    private String dateOfBirth;
    private String className;
    private String bloodGroup;
}
