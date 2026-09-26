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
@Table(name = "student_grades")
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gradeId")
    private Integer gradeId;
    @Column(name = "rollNo", nullable = false, unique = true, length = 50)
    private Integer rollNo;
    @Column(name = "Maths", nullable = false)
    private double maths;
    @Column(name = "Science", nullable = false)
    private double science;
    @Column(name = "English", nullable = false)
    private double  english;
    @Column(name = "Hindi", nullable = false)
    private double  hindi;
    @Column(name = "CS", nullable = false)
    private double  cs;
}


