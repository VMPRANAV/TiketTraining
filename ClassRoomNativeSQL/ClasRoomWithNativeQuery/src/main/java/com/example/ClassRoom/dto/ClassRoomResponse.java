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

    private String Maths;

    private String Science;

    private String English;

    private String Hindi;
    private String CS;
}
