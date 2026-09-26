package com.example.ClassRoom.controller;

import com.example.ClassRoom.client.ClassRoomClient;
import com.example.ClassRoom.entity.ClassRoom;
import com.example.ClassRoom.service.ClassRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class classRoomController {

    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    private ClassRoomClient classRoomClient;


    @GetMapping("/getDetails/{rollNo}")
    public ClassRoom getDetails(@PathVariable int rollNo) {
        return classRoomService.getStudentDetails(rollNo);
    }

    @GetMapping("/getDetails/remote/{rollNo}")
    public ClassRoom getDetailsSQl(@PathVariable int rollNo) {
        return classRoomClient.getStudentDetails(rollNo);
    }
        @PutMapping  ("/updateDetails/{rollNo}")
    public ClassRoom updateDetails(@PathVariable int rollNo, @RequestBody ClassRoom classRoom ){
return classRoomService.updateDetails(
         rollNo,
        classRoom.getStudentName(),
        classRoom.getDateOfBirth(),
        classRoom.getClassName(),
        classRoom.getBloodGroup()
);
    }

    @PostMapping("/createStudent")
    public ClassRoom createStudent(@RequestBody ClassRoom classRoom) {
        return classRoomService.createDetails(
                classRoom.getRollNo(),
                classRoom.getStudentName(),
                classRoom.getDateOfBirth(),
                classRoom.getClassName(),
                classRoom.getBloodGroup()
        );
    }
        @DeleteMapping("/deleteStudent/{rollNo}")
                public ClassRoom deleteDetails(@PathVariable int rollNo){
return classRoomService.deleteDetails(rollNo);


    }


}
