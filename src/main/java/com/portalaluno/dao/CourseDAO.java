package com.portalaluno.dao;

import com.portalaluno.model.Course;
import com.portalaluno.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public List<Course> getAllCourses() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        List<Course> courses = new ArrayList<>();
        try {
            Query query = entityManager.createQuery("select c from Course c");
            courses = query.getResultList();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
        return courses;
    }
}
