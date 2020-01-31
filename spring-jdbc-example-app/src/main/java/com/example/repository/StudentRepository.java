package com.example.repository;

import com.example.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    boolean save(Student student);

    boolean update(Student student);

    boolean delete(String studentId);

    Optional<Student> findById(String studentId);

    List<Student> findAll();
}
