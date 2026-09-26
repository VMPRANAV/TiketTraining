package com.example.ClassRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom {
    private int rollNo;
    private String studentName;
    private String dateOfBirth;
    private String className;
    private String bloodGroup;
}
