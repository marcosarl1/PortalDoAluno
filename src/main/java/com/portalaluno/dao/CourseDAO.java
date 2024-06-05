package com.portalaluno.dao;

import com.portalaluno.model.Course;
import com.portalaluno.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CourseDAO {

    public List<Course> getAllCourses() {
        try {
            EntityManager entityManager = JPAUtil.getEntityManager();
            Query query = entityManager.createQuery("select c from Course c");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
