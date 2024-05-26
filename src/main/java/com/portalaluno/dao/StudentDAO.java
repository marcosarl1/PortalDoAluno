package com.portalaluno.dao;

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
            = "INSERT INTO students (name, email, course )VALUES (?, ?, ?)";
    private static final String SELECT_ALLSTUDENTS_SQL
            = "SELECT * FROM students";
    private static final String DELETE_STUDENT_SQL
            = "DELETE FROM students WHERE id = ?";
    private static final String SEARCH_STUDENT_SQL
            = "SELECT * FROM students WHERE name LIKE ? OR email LIKE ? OR course LIKE ?";

    public void insertStudent(Student student) throws SQLException {
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(INSERT_STUDENT_SQL)) {
            if (conn != null) {
                st.setString(1, student.getName());
                st.setString(2, student.getEmail());
                st.setString(3, student.getCourse());
                st.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() throws SQLException{
        List<Student> students = new ArrayList<>();
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(SELECT_ALLSTUDENTS_SQL); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));

                students.add(student);
            }
        } catch (Exception e) {
        }
        return students;
    }

    public void deleteStudent(int id) {
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(DELETE_STUDENT_SQL)) {
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e) {
        }
    }

    public List<Student> searchStudents(String query) {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(SEARCH_STUDENT_SQL)) {
            String searchQuery = "%" + query.toLowerCase() + "%";
            st.setString(1, searchQuery);
            st.setString(2, searchQuery);
            st.setString(3, searchQuery);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setCourse(rs.getString("course"));
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
