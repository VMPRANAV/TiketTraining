package com.example.ClassRoom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoomResponse {
    private Integer rollNo;
    private String studentName;
    private String dateOfBirth;
    private String className;
    private String bloodGroup;
    private Integer gradeId;

    private double maths;

    private double science;

    private double english;

    private double hindi;
    private double cs;
}
