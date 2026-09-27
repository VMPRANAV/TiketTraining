package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.StudentRequestDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;
import com.example.StudentManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudentsDetails() {
        return ResponseEntity.ok().body(studentService.getAllStudentDetails());

    }

    @GetMapping("/getByName/{firstName}")
    public ResponseEntity<StudentResponseDTO> getStudentByName(@PathVariable String firstName) {
        return ResponseEntity.ok(studentService.getStudentByName(firstName));
    }

    @GetMapping("/getByRollNo")
    public ResponseEntity<StudentResponseDTO> getStudentByRollNo(@RequestParam int rollNo) {
        return ResponseEntity.ok().body(studentService.getStudentByRollNo(rollNo));
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentRequestDTO));
    }

    @PutMapping("/updateStudent/{rollNo}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable int rollNo,@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        return ResponseEntity.ok(studentService.updateStudent(rollNo,studentRequestDTO));
    }

    @DeleteMapping("/deleteStudent/{rollNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int rollNo) {
        studentService.deleteStudent(rollNo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/totalCount")
    public ResponseEntity<Integer> totalCountOfStudents() {
        return ResponseEntity.ok(studentService.getTotalCount());
    }
@DeleteMapping ("/deleteALlStudents/{lastName}")
    public ResponseEntity<List<StudentResponseDTO>> deleteAllStudentsByLastName(@PathVariable String lastName){
        return ResponseEntity.ok(studentService.deleteAllStudentsByLastName(lastName));
}

}
