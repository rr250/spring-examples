package com.example.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet resultSet, int i) throws SQLException {

		Student student = new Student();
		student.setId(resultSet.getString("id"));
		student.setFirstName(resultSet.getString("first_name"));
		student.setLastName(resultSet.getString("last_name"));
		student.setAge(resultSet.getInt("age"));
		student.setGender(Gender.valueOf(resultSet.getString("gender")));
		return student;
	}
}

