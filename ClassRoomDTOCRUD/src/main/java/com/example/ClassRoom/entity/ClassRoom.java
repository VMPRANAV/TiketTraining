package com.example.ClassRoom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classroom_new")
public class ClassRoom {
    @Id
    @Column(name = "rollNo", nullable = false, unique = true, length = 50)
    private Integer rollNo;
    @Column(name = "studentName", nullable = false)
    private String studentName;
    @Column(name = "dateOfBirth", nullable = false)
    private String dateOfBirth;
    @Column(name = "className", nullable = false)
    private String className;
    @Column(name = "bloodGroup", nullable = false)
    private String bloodGroup;
}
