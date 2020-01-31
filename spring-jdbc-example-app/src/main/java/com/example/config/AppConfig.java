package com.example.config;

import com.example.repository.StudentRepository;
import com.example.repository.StudentRepositoryImpl;
import com.example.service.StudentService;
import com.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan(value={"com.example.repository", "com.example.service"})
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    private final String URL = "url";
    private final String USER = "user";
    private final String DRIVER = "driver";
    private final String PASSWORD = "password";

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        return driverManagerDataSource;
    }

//    @Bean
//    public StudentRepository studentRepository(){
//        return new StudentRepositoryImpl(dataSource());
//    }
//
//    @Bean
//    public StudentService studentService(){
//        return new StudentServiceImpl(studentRepository());
//    }
}