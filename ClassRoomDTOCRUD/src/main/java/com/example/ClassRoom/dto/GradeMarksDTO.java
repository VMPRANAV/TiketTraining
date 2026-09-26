package com.example.ClassRoom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GradeMarksDTO {
    private Integer rollNo;
    private  double  sumMarks;
    private  double avgMarks;
}
