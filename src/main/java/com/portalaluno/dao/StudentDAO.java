package com.portalaluno.dao;

import com.portalaluno.model.Student;
import com.portalaluno.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class StudentDAO {
    
    public void insertStudent(Student student) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void deleteStudent(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Student student = entityManager.find(Student.class, id);
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void editStudent(Student student) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Student> getStudent(String filter) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            String stringQuery = "Select s FROM Student s " +
                    "WHERE (:name is null OR s.name LIKE :name) " +
                    "OR (:email is null OR s.email LIKE :email) " +
                    "OR (:course is null OR s.courseid.name LIKE :course)";
            Query query = entityManager.createQuery(stringQuery);
            Object value = filter.isEmpty() ? null : "%" + filter + "%";
            query.setParameter("name", value);
            query.setParameter("email", value);
            query.setParameter("course", value);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Student getStudentById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Student.class, id);
        } catch (Exception e) {
            return null;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
