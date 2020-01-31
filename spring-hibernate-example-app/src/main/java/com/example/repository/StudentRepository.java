package com.example.repository;

import com.example.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    void save(Student student);

    void update(Student student);

    void delete(String studentId);

    Optional<Student> findById(String studentId);

    List<Student> findAll();
}
