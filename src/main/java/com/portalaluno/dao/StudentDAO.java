package com.portalaluno.dao;

import com.portalaluno.model.Student;
import com.portalaluno.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    private static final String INSERT_STUDENT_SQL = 
            "INSERT INTO students (name, email, course )VALUES (?, ?, ?)";
    
    public void insertStudent(Student student) throws SQLException{
        try (Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(INSERT_STUDENT_SQL)){
            st.setString(1, student.getName());
            st.setString(2, student.getEmail());
            st.setString(3, student.getCourse());
            st.executeUpdate();
        } catch (SQLException e) {
        } 
    }
}
