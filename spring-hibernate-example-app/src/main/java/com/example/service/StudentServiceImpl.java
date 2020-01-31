package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    public StudentServiceImpl(StudentRepository studentRepository){
//        this.studentRepository = studentRepository;
//    }

    @Override
    public void registerStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        this.studentRepository.update(student);
    }

    @Override
    public void deleteStudentByStudentId(String studentId) {
        this.studentRepository.delete(studentId);
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
