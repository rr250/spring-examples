package com.example.service;

import com.example.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    boolean registerStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudentByStudentId(String studentId);

    Optional<Student> findStudentById(String studentId);

    List<Student> findAllStudents();
}
