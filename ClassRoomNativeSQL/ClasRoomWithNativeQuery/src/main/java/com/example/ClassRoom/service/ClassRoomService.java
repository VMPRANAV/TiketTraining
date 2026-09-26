package com.example.ClassRoom.service;

import com.example.ClassRoom.dto.ClassRoomRequest;
import com.example.ClassRoom.dto.ClassRoomResponse;
import com.example.ClassRoom.entity.ClassRoom;
import com.example.ClassRoom.entity.Grades;
import com.example.ClassRoom.repositry.ClassRoomRepositry;
import com.example.ClassRoom.repositry.GradesRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    ClassRoomRepositry classRoomRepositry;
    @Autowired
    GradesRepositry gradesRepositry;

//    public ClassRoom getStudentDetails(int rollNo) {
//        if (mp.containsKey(rollNo))
//            return mp.get(rollNo);
//        else return null;
//    }

    public ClassRoomResponse createDetails(ClassRoomRequest classRoomRequest) {
        ClassRoom classRoom = ClassRoom.builder()
                .rollNo(classRoomRequest.getRollNo())
                .studentName(classRoomRequest.getStudentName())
                .dateOfBirth(classRoomRequest.getDateOfBirth())
                .className(classRoomRequest.getClassName())
                .bloodGroup(classRoomRequest.getBloodGroup())
                .build();

        Grades grades = Grades.builder()
                .rollNo(classRoomRequest.getRollNo())
                .Maths(classRoomRequest.getMaths())
                .Science(classRoomRequest.getScience())
                .English(classRoomRequest.getEnglish())
                .Hindi(classRoomRequest.getHindi())
                .CS(classRoomRequest.getCS())
                .build();

        ClassRoom classRoomResponse = classRoomRepositry.save(classRoom);
        Grades gradesResponse = gradesRepositry.save(grades);

        return ClassRoomResponse.builder()
                .className(classRoomResponse.getClassName())
                .bloodGroup(classRoomResponse.getBloodGroup())
                .dateOfBirth(classRoomResponse.getDateOfBirth())
                .studentName(classRoomResponse.getStudentName())
                .rollNo(classRoomResponse.getRollNo())
                .gradeId(gradesResponse.getGradeId())
                .CS(gradesResponse.getCS())
                .English(gradesResponse.getEnglish())
                .Hindi(gradesResponse.getHindi())
                .Science(gradesResponse.getScience())
                .Maths(gradesResponse.getMaths())
                .build();

    }

    public ClassRoomResponse updateDetails(int rollNo, ClassRoomRequest classRoomRequest) {
        ClassRoom classRoom = classRoomRepositry.findById(rollNo).orElseThrow(() -> new RuntimeException("Roll No Not Found"));
        Grades grades = gradesRepositry.findByRollNo(rollNo).orElseThrow(() -> new RuntimeException("Grades No Not Found"));
        classRoom.setClassName(classRoomRequest.getClassName());
        classRoom.setStudentName(classRoomRequest.getStudentName());
        classRoom.setBloodGroup(classRoomRequest.getBloodGroup());
        classRoom.setDateOfBirth(classRoomRequest.getDateOfBirth());
        classRoom.setRollNo(classRoomRequest.getRollNo());
        grades.setRollNo(classRoomRequest.getRollNo());
        grades.setCS(classRoomRequest.getCS());
        grades.setEnglish(classRoomRequest.getEnglish());
        grades.setHindi(classRoomRequest.getHindi());
        grades.setScience(classRoomRequest.getScience());
        grades.setMaths(classRoomRequest.getMaths());
        ClassRoom classRoomResponse = classRoomRepositry.save(classRoom);
        Grades gradesResponse = gradesRepositry.save(grades);


        return ClassRoomResponse.builder()
                .className(classRoomResponse.getClassName())
                .bloodGroup(classRoomResponse.getBloodGroup())
                .dateOfBirth(classRoomResponse.getDateOfBirth())
                .studentName(classRoomResponse.getStudentName())
                .rollNo(classRoomResponse.getRollNo())
                .gradeId(gradesResponse.getGradeId())
                .CS(gradesResponse.getCS())
                .English(gradesResponse.getEnglish())
                .Hindi(gradesResponse.getHindi())
                .Science(gradesResponse.getScience())
                .Maths(gradesResponse.getMaths())
                .build();

    }

    public ClassRoomResponse getDetails(int rollNo) {
        ClassRoom classRoomResponse = classRoomRepositry.findById(rollNo).orElseThrow(() -> new RuntimeException("Roll No Not Found"));
        Grades gradesResponse = gradesRepositry.findByRollNo(rollNo).orElseThrow(() -> new RuntimeException("Grades No Not Found"));


        return ClassRoomResponse.builder()
                .className(classRoomResponse.getClassName())
                .bloodGroup(classRoomResponse.getBloodGroup())
                .dateOfBirth(classRoomResponse.getDateOfBirth())
                .studentName(classRoomResponse.getStudentName())
                .rollNo(classRoomResponse.getRollNo())
                .gradeId(gradesResponse.getGradeId())
                .CS(gradesResponse.getCS())
                .English(gradesResponse.getEnglish())
                .Hindi(gradesResponse.getHindi())
                .Science(gradesResponse.getScience())
                .Maths(gradesResponse.getMaths())
                .build();
    }

    public ClassRoomResponse deleteDetails(int rollNo) {
        ClassRoom deletedClassRoomResponse = classRoomRepositry.findById(rollNo).orElseThrow(() -> new RuntimeException("Roll No Not Found"));
        Grades deletedGradesResponse = gradesRepositry.findByRollNo(rollNo).orElseThrow(() -> new RuntimeException("Grades No Not Found"));
        classRoomRepositry.deleteById(rollNo);
        gradesRepositry.deleteByRollNo(rollNo);
        return ClassRoomResponse.builder()
                .className(deletedClassRoomResponse.getClassName())
                .bloodGroup(deletedClassRoomResponse.getBloodGroup())
                .dateOfBirth(deletedClassRoomResponse.getDateOfBirth())
                .studentName(deletedClassRoomResponse.getStudentName())
                .rollNo(deletedClassRoomResponse.getRollNo())
                .CS(deletedGradesResponse.getCS())
                .gradeId(deletedGradesResponse.getGradeId())
                .English(deletedGradesResponse.getEnglish())
                .Hindi(deletedGradesResponse.getHindi())
                .Science(deletedGradesResponse.getScience())
                .Maths(deletedGradesResponse.getMaths())
                .build();

    }

}
