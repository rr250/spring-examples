package com.example.repository;

import com.example.entity.Student;
import com.example.entity.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_PERSON = "select * from students where id = ?;";
    private final String SQL_DELETE_PERSON = "delete from students where id = ?;";
    private final String SQL_UPDATE_PERSON = "update students set first_name = ?, last_name = ?, age  = ?, gender = ? where id = ?;";
    private final String SQL_GET_ALL = "select * from students;";
    private final String SQL_INSERT_PERSON = "insert into students values(?,?,?,?,?);";

    @Autowired
    public StudentRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Student student) {
        return jdbcTemplate.update(SQL_INSERT_PERSON, student.getId(), student.getFirstName(), student.getLastName(),
                student.getAge(), student.getGender().toString())>0;
    }

    @Override
    public boolean update(Student student) {
        return jdbcTemplate.update(SQL_UPDATE_PERSON, student.getFirstName(), student.getLastName(), student.getAge(),
                student.getGender().name(), student.getId()) > 0;
    }

    @Override
    public boolean delete(String studentId) {
        return jdbcTemplate.update(SQL_DELETE_PERSON, studentId) > 0;
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new StudentMapper()));
    }

    @Override
    public List<Student> findAll()
    {
        return jdbcTemplate.query(SQL_GET_ALL, new StudentMapper());
    }
}
