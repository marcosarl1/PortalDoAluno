package com.portalaluno.dao;

import com.portalaluno.model.Course;
import com.portalaluno.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    
    private static EntityManager entityManager = null;

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            entityManager = JPAUtil.getEntityManager();
            Query query = entityManager.createQuery("select c from Course c");
            courses = query.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
        return courses;
    }
}
