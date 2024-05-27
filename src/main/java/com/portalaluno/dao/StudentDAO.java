package com.portalaluno.dao;

import com.portalaluno.model.Course;
import com.portalaluno.model.Student;
import com.portalaluno.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String INSERT_STUDENT_SQL
            = "INSERT INTO students (name, email, courseid) VALUES (?, ?, ?)";
    private static final String DELETE_STUDENT_SQL
            = "DELETE FROM students WHERE id = ?";
    private static final String EDIT_STUDENT_SQL
            = "UPDATE students SET name=?, email=?, courseid=? WHERE id=?";
    private static final String SELECT_ALLSTUDENTS_SQL
            = "SELECT * FROM students";
    private static final String SELECT_STUDENT_ID_SQL
            = "SELECT * FROM students WHERE id=?";
    private static final String SEARCH_STUDENT_SQL
            = "SELECT * FROM students WHERE name LIKE ? OR email LIKE ?";

    public void insertStudent(Student student) throws SQLException {
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(INSERT_STUDENT_SQL)) {
            st.setString(1, student.getName());
            st.setString(2, student.getEmail());
            st.setInt(3, student.getCourseId().getId());
            st.execute();
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
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(SELECT_STUDENT_ID_SQL)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                rs.next();
                Student student = createStudent(rs);
                return student;
            }
        }
    }

    public List<Student> searchStudents(String query) throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(SEARCH_STUDENT_SQL)) {
            String searchQuery = "%" + query + "%";
            st.setString(1, searchQuery);
            st.setString(2, searchQuery);
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
        int courseId = rs.getInt("courseid");
        Course course = getCourseById(courseId);
        return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), course);
    }
    
    private Course getCourseById(int id) throws SQLException {
        String sql = "SELECT * FROM course WHERE id=?";
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Course course = new Course();
                    course.setId(rs.getInt("id"));
                    course.setName(rs.getString("name"));
                    return course;
                }
            }
        }
        return null;
    }
}
