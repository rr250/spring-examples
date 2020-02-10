package com.example.springboot.controller;

import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<Student> result = studentService.findAllStudents();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping("/registerStudent")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        studentService.registerStudent(student);
        return new ResponseEntity("Student added succcessfully", HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteStudentByStudentId(@RequestParam("id") String id) {
        studentService.deleteStudentByStudentId(id);
    }
    @PostMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity("Student added succcessfully", HttpStatus.OK);
    }

    @GetMapping("/getStudentByStudentId")
    public ResponseEntity<?> getStudentByStudentId(@RequestParam("id") String id) {
        Optional<Student> result = studentService.findStudentById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
