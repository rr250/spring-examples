package com.example.springboot.repository;

import com.example.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {

}
