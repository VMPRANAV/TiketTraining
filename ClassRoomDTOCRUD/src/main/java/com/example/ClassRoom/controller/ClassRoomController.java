package com.example.ClassRoom.controller;

import com.example.ClassRoom.dto.ClassRoomRequest;
import com.example.ClassRoom.dto.ClassRoomResponse;
import com.example.ClassRoom.dto.GradeMarksDTO;
import com.example.ClassRoom.dto.StudentResponse;
import com.example.ClassRoom.entity.ClassRoom;
import com.example.ClassRoom.service.ClassRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping("/getDetails/{rollNo}")
    public ClassRoomResponse getDetails(@PathVariable int rollNo) {
        return classRoomService.getDetails(rollNo);
    }

    @PutMapping("/updateDetails/{rollNo}")
    public ClassRoomResponse updateDetails(@PathVariable int rollNo, @RequestBody ClassRoomRequest classRoomRequest) {
        return classRoomService.updateDetails(rollNo, classRoomRequest);
    }

    @DeleteMapping("/deleteDetails/{rollNo}")
    public ClassRoomResponse deleteDetails(@PathVariable int rollNo) {
        return classRoomService.deleteDetails(rollNo);
    }

    @PostMapping("/createStudent")
    public ClassRoomResponse createStudent(@RequestBody ClassRoomRequest classRoomRequest) {
        return classRoomService.createDetails(classRoomRequest);

    }
    //Case Insensitive
    @GetMapping("/getDetailsNameCase/{name}")
    public StudentResponse getDetailsByNameCase(@PathVariable String name){
        return classRoomService.findByStudentNameDetailsCaseInsense(name);
    }
    //case Sensitive

    @GetMapping("/getDetailsName/{name}")
    public StudentResponse getDetailsByName(@PathVariable String name){
        return classRoomService.findByStudentNameDetails(name);
    }
// get Avg and Sum Marks
    @GetMapping("/getMarks/{rollNo}")
    public GradeMarksDTO getMarksByRollNo(@PathVariable int rollNo){
        return  classRoomService.getStudentMarksByRollNo(rollNo);
    }
    @GetMapping("/getUniqueBG")
    public List<StudentResponse> getStudentsByUniqueBloodGroup(){
        return classRoomService.getStudentsByUniqueBloodGroup();
    }

}