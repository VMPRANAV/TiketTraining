package com.example.ClassRoom.service;

import com.example.ClassRoom.entity.ClassRoom;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ClassRoomService {

    HashMap<Integer, ClassRoom> classRoomData = new HashMap<>();

    public ClassRoom getStudentDetails(int rollNo) {
        return classRoomData.getOrDefault(rollNo, null);
    }

    public ClassRoom createDetails(int rollNo, String studentName, String dateOfBirth, String className, String bloodGroup) {

        ClassRoom classRoom = ClassRoom.builder()
                .rollNo(rollNo)
                .studentName(studentName)
                .dateOfBirth(dateOfBirth)
                .className(className)
                .bloodGroup(bloodGroup)
                .build();
        classRoomData.put(rollNo, classRoom);
        return classRoom;
    }

    public ClassRoom updateDetails(int rollNo, String studentName, String dateOfBirth, String className, String bloodGroup) {
        ClassRoom classRoom = ClassRoom.builder()
                .rollNo(rollNo)
                .studentName(studentName)
                .dateOfBirth(dateOfBirth)
                .className(className)
                .bloodGroup(bloodGroup)
                .build();
        classRoomData.put(rollNo, classRoom);
        return classRoom;
    }

    public ClassRoom deleteDetails(int rollNo) {
        if (!classRoomData.containsKey(rollNo)) {
            return null;
        }
        ClassRoom removed = classRoomData.remove(rollNo);
        return removed;

    }
}
