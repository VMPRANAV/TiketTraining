package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.StudentRequestDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;
import com.example.StudentManagement.entity.StudentProfile;
import com.example.StudentManagement.exception.DuplicateResourceFoundException;
import com.example.StudentManagement.exception.ResourceNotFoundException;
import com.example.StudentManagement.repositry.StudentRepositry;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepositry studentRepositry;

    public List<StudentResponseDTO> getAllStudentDetails() {
        List<StudentProfile> studentProfiles = studentRepositry.findAll();
        if (studentProfiles.isEmpty()) {
            throw new ResourceNotFoundException("No Students  found");
        }
        List<StudentResponseDTO> studentResponseDTOList = new ArrayList<>();
        for (StudentProfile studentProfile : studentProfiles) {
            StudentResponseDTO studentResponseDTO = StudentResponseDTO.builder().id(studentProfile.getId()).rollNo(studentProfile.getRollNo()).firstName(studentProfile.getFirstName()).lastName(studentProfile.getLastName()).dateOfBirth(studentProfile.getDateOfBirth()).build();
            studentResponseDTOList.add(studentResponseDTO);
        }
        return studentResponseDTOList;
    }

    public StudentResponseDTO getStudentByName(String firstName) {
        StudentProfile studentProfile = studentRepositry.findByFirstName(firstName);
        if (studentProfile == null) {
            throw new ResourceNotFoundException("Student with name " + firstName + "doesn't exist");
        }

        return StudentResponseDTO
                .builder()
                .id(studentProfile.getId())
                .rollNo(studentProfile.getRollNo())
                .firstName(studentProfile.getFirstName())
                .lastName(studentProfile.getLastName())
                .dateOfBirth(studentProfile.getDateOfBirth())
                .build();
    }

    public StudentResponseDTO getStudentByRollNo(int rollNo) {
        StudentProfile studentProfile = studentRepositry.findByRollNo(rollNo);
        if (studentProfile == null) {
            throw new ResourceNotFoundException("Student with rollNo " + rollNo + "doesn't exist");
        }
        return StudentResponseDTO
                .builder()
                .id(studentProfile.getId())
                .rollNo(studentProfile.getRollNo())
                .firstName(studentProfile.getFirstName())
                .lastName(studentProfile.getLastName())
                .dateOfBirth(studentProfile.getDateOfBirth())
                .build();
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        if (studentRepositry.existsByRollNo(studentRequestDTO.getRollNo())) {
            throw new DuplicateResourceFoundException("Student with rollno " + studentRequestDTO.getRollNo() + " already exisits");
        }

        StudentProfile studentProfile = StudentProfile.builder()
                .rollNo(studentRequestDTO.getRollNo())
                .firstName(studentRequestDTO.getFirstName())
                .lastName(studentRequestDTO.getLastName())
                .dateOfBirth(studentRequestDTO.getDateOfBirth())
                .build();
        studentRepositry.save(studentProfile);
        return StudentResponseDTO.builder()
                .id(studentProfile.getId())
                .rollNo(studentProfile.getRollNo())
                .firstName(studentProfile.getFirstName())
                .lastName(studentProfile.getLastName())
                .dateOfBirth(studentProfile.getDateOfBirth())
                .build();

    }

    public StudentResponseDTO updateStudent(int rollNo, StudentRequestDTO studentRequestDTO) {
        StudentProfile studentProfile = studentRepositry.findByRollNo(rollNo);
        if (studentProfile == null) {
            throw new ResourceNotFoundException("Student with RollNo " + rollNo + "is not found");
        }
        studentProfile.setFirstName(studentRequestDTO.getFirstName());
        studentProfile.setLastName(studentRequestDTO.getLastName());
        studentProfile.setDateOfBirth(studentRequestDTO.getDateOfBirth());

        StudentProfile updatedStudent =
                studentRepositry.save(studentProfile);
        return StudentResponseDTO
                .builder()
                .id(studentProfile.getId())
                .rollNo(studentProfile.getRollNo())
                .firstName(studentProfile.getFirstName())
                .lastName(studentProfile.getLastName())
                .dateOfBirth(studentProfile.getDateOfBirth()).
                build();
    }

    @Transactional
    public void deleteStudent(int rollNo) {
        StudentProfile studentProfile = studentRepositry.findByRollNo(rollNo);
        if (studentProfile == null) {
            throw new ResourceNotFoundException("Student with RollNo " + rollNo + "is not found");
        }
        studentRepositry.deleteById(studentProfile.getId());


    }

    public int getTotalCount() {

        return studentRepositry.getTotalCount();
    }

    public List<StudentResponseDTO> deleteAllStudentsByLastName(String lastName) {
        List<StudentProfile> studentProfiles = studentRepositry.findByLastName(lastName);
        if (studentProfiles.isEmpty()) {
            throw new ResourceNotFoundException("Student with lastName " + lastName + "is not found");
        }
        List<StudentResponseDTO> studentResponseDTOS = studentProfiles.stream().map(student -> StudentResponseDTO
                .builder()
                .id(student.getId())
                .rollNo(student.getRollNo())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .dateOfBirth(student.getDateOfBirth()).
                build()).toList();
        studentRepositry.deleteAll(studentProfiles);

        return studentResponseDTOS;
    }


}
