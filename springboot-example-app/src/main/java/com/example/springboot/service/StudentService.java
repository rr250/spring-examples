package com.example.springboot.service;

import com.example.springboot.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    void registerStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentByStudentId(String studentId);

    Optional<Student> findStudentById(String studentId);

    List<Student> findAllStudents();
}
