package com.example.springboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.UUID;

@Document
public class Student {
    @Id
    private String id = UUID.randomUUID().toString();

    private Integer age;

    private String firstName;

    private String lastName;

    private Gender gender;

    public Student() {
    }

    public Student(Integer age, String firstName, String lastName, Gender gender) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", age=" + age + ", gender=" + gender + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
                + '\'' + '}';
    }
}
