package com.example.ClassRoom.controller;

import com.example.ClassRoom.entity.ClassRoom;
import com.example.ClassRoom.service.ClassRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;
    @GetMapping("/getDetails/{rollNo}")
    public Optional<ClassRoom> getDetails(@PathVariable int rollNo) {
        return classRoomService.getStudentDetails(rollNo);
    }

    @PostMapping("/createStudent")
    public ClassRoom createStudent(@RequestBody ClassRoom classRoom) {
        ClassRoom classRoom1 = classRoomService.createDetails(classRoom);
        return classRoom1;

    }

    @PutMapping("/updateStudent/{rollNo}")
    public ClassRoom updateStudent(@PathVariable int rollNo,@RequestBody ClassRoom classRoom){
        return classRoomService.updateDetails(rollNo,classRoom);
    }

@DeleteMapping("/deleteStudent/{rollNo}")
    public Optional<ClassRoom>deleteStudent(@PathVariable int rollNo) {
    return classRoomService.deleteDetails(rollNo);
}



}