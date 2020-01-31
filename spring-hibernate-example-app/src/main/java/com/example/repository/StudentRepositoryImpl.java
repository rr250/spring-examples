package com.example.repository;

import com.example.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {

//    @Autowired
//    private SessionFactory sessionFactory;

//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Student student) {
//        getSession().persist(student);
        em.persist(student);
    }

    @Override
    public void update(Student student) {
//        getSession().update(student);
        em.merge(student);
    }

    @Override
    public void delete(String studentId) {
//        Student student = getSession().find(Student.class,studentId);
//        getSession().remove(student);
        Student student = em.find(Student.class,studentId);
        em.remove(student);
//        Query query = getSession().createSQLQuery("delete from Employee where studentId = :studentId");
//        query.setString("studentId", studentId);
//        query.executeUpdate();
    }

    @Override
    public Optional<Student> findById(String id) {
//        return Optional.of(getSession().find(Student.class,id));
        return Optional.of(em.find(Student.class,id));
    }

    @Override
    public List<Student> findAll() {
//        CriteriaBuilder cb = getSession().getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
//        Root<Student> rootEntry = cq.from(Student.class);
//        CriteriaQuery<Student> all = cq.select(rootEntry);
//
//        TypedQuery<Student> allQuery = getSession().createQuery(all);
//        return allQuery.getResultList();

        return em.createQuery("from " + Student.class.getName()).getResultList();
    }
}
