package com.portalaluno.dao;

import com.portalaluno.model.Course;
import com.portalaluno.model.Student;
import com.portalaluno.util.DB;
import com.portalaluno.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    
    private static final String SEARCH_STUDENT_SQL
            = "SELECT student.*, c.name FROM student INNER JOIN course c on student.courseid = c.id WHERE student.name LIKE ? OR student.email LIKE ? OR c.name LIKE ? ORDER BY student.id";

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

    public List<Student> getAllStudents() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        List<Student> students = new ArrayList<>();
        try {
            Query query = entityManager.createQuery("SELECT s FROM Student s");
            students = query.getResultList();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return students;
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

    public List<Student> searchStudents(String query) throws SQLException {
        List<Student> students = new ArrayList<>();
        String searchQuery = "%" + query + "%";
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(SEARCH_STUDENT_SQL)) {
            st.setString(1, searchQuery);
            st.setString(2, searchQuery);
            st.setString(3, searchQuery);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Student student = createStudent(rs);
                    students.add(student);
                }
            }
        }
        return students;
    }

    private Student createStudent(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        int courseid = rs.getInt("courseid");
        String courseName = rs.getString("c.name");

        Course course = new Course(courseid, courseName);

        return new Student(id, name, email, course);
    }
}
