package com.example;

import com.example.entity.Gender;
import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class demo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build())
                .getMetadataBuilder().build().getSessionFactoryBuilder().build();

        Session session  =sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        Student student = new Student(21,"Ram","shyam", Gender.MALE);
        session.save(student);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
