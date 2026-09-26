package com.example.ClassRoom.service;

import com.example.ClassRoom.entity.ClassRoom;
import com.example.ClassRoom.repositry.ClassRoomRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    ClassRoomRepositry classRoomRepositry;

    public Optional<ClassRoom> getStudentDetails(int rollNo) {
      return classRoomRepositry.findById(rollNo);
    }


    public ClassRoom createDetails(ClassRoom classRoom) {
        return classRoomRepositry.save(classRoom);
    }
public ClassRoom updateDetails(int rollNo,ClassRoom classRoom){
        classRoom.setRollNo(rollNo);
    return  classRoomRepositry.save(classRoom);

}
public Optional<ClassRoom> deleteDetails(int rollNo){
    Optional<ClassRoom> deletedClassRoom= classRoomRepositry.findById(rollNo);
          classRoomRepositry.deleteById(rollNo);
          return deletedClassRoom ;
}

}
