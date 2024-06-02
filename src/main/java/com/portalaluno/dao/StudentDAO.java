package com.portalaluno.dao;

import com.portalaluno.model.Course;
import com.portalaluno.model.Student;
import com.portalaluno.util.DB;
import com.portalaluno.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String DELETE_STUDENT_SQL
            = "DELETE FROM student WHERE id = ?";
    private static final String EDIT_STUDENT_SQL
            = "UPDATE student SET name=?, email=?, courseid=? WHERE id=?";
    private static final String SELECT_ALLSTUDENTS_SQL
            = "SELECT student.*, c.course_name FROM student INNER JOIN course c on student.courseid = c.id ORDER BY student.id;";
    private static final String SEARCH_STUDENT_SQL
            = "SELECT student.*, c.course_name FROM student INNER JOIN course c on student.courseid = c.id WHERE student.name LIKE ? OR student.email LIKE ? OR c.course_name LIKE ? ORDER BY student.id";

    public void insertStudent(Student student) throws SQLException {
        try (EntityManager entityManager = JPAUtil.getEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(DELETE_STUDENT_SQL)) {
            st.setInt(1, id);
            st.execute();
        }
    }

    public void editStudent(Student student) throws SQLException {
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(EDIT_STUDENT_SQL)) {
            st.setString(1, student.getName());
            st.setString(2, student.getEmail());
            st.setInt(3, student.getCourseId().getId());
            st.setInt(4, student.getId());
            st.execute();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(SELECT_ALLSTUDENTS_SQL); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Student student = createStudent(rs);
                students.add(student);
            }
        }
        return students;
    }

    public Student getStudentById(int id) throws SQLException {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.find(Student.class, id);
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
        String courseName = rs.getString("course_name");

        Course course = new Course(courseid, courseName);

        return new Student(id, name, email, course);
    }
}
