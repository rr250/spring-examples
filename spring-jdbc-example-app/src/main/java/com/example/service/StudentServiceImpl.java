package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean registerStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return this.studentRepository.update(student);
    }

    @Override
    public boolean deleteStudentByStudentId(String studentId) {
        return this.studentRepository.delete(studentId);
    }

    @Override
    public Optional<Student> findStudentById(String studentId) {
        return this.studentRepository.findById(studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        return this.studentRepository.findAll();
    }
}
