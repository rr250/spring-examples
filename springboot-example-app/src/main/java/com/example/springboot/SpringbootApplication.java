package com.example.springboot;

import com.example.springboot.entity.Gender;
import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;
import com.example.springboot.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.example.springboot.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.example.springboot.entity")
public class SpringbootApplication implements CommandLineRunner {
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
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
		student.get().setLastName("CHANGED111");
		studentService.updateStudent(student.get());

		System.out.println("List of students:");

		for (Student s : studentService.findAllStudents()) {
			System.out.println(s);
		}
	}

}
