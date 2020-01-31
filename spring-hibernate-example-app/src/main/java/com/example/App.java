package com.example;

import com.example.entity.Gender;
import com.example.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.entity.Student;
import com.example.config.AppConfig;
import com.example.repository.StudentRepository;

import java.util.Optional;
import java.util.UUID;


public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService studentService = context.getBean(StudentService.class);

        System.out.println("\nCreating person: ");
        Student student1 = new Student(36, "Garvey", "Ets", Gender.MALE);
        System.out.println(student1);
        studentService.registerStudent(student1);

        System.out.println("List of students:");

        for (Student s : studentService.findAllStudents()) {
            System.out.println(s);
        }

        System.out.println("\nGet student with ID 381e7df8-806f-4e15-91e1-fd4568865d6e");

        Optional<Student> studentById = studentService.findStudentById("381e7df8-806f-4e15-91e1-fd4568865d6e");
        if(studentById.isPresent()) {
            System.out.println("Student First Name:: " + studentById.get().getFirstName());
            System.out.println("Student Last Name:: " + studentById.get().getLastName());
            System.out.println("Student Id:: " + studentById.get().getId());
            System.out.println("Student Age:: " + studentById.get().getAge());
            System.out.println("Student Gender:: " + studentById.get().getGender());

        }else {
            throw new RuntimeException("Student Not found with id : 1");
        }

        System.out.println("\nCreating person: ");
        Student student2 = new Student(36, "Garvey", "Ets", Gender.MALE);
        System.out.println(student2);
        studentService.registerStudent(student2);

        System.out.println("List of students:");

        for (Student s : studentService.findAllStudents()) {
            System.out.println(s);
        }

        System.out.println("\nDeleting student with ID 2");
        studentService.deleteStudentByStudentId(student1.getId());

        System.out.println("\nUpdate person with ID 381e7df8-806f-4e15-91e1-fd4568865d6e");

        Optional<Student> student = studentService.findStudentById("381e7df8-806f-4e15-91e1-fd4568865d6e");
        student.get().setLastName("CHANGED");
        studentService.updateStudent(student.get());

        System.out.println("List of students:");

        for (Student s : studentService.findAllStudents()) {
            System.out.println(s);
        }

        context.close();
    }
}
