package com.portalaluno.dao;

import com.portalaluno.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    private static final String INSERT_STUDENT_SQL = 
            "INSERT INTO students (name, email, course )VALUES (?, ?, ?)";
    
    private Connection conn;
    
    public void insertStudent(Student student) throws SQLException{
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(INSERT_STUDENT_SQL);
            st.setString(1, student.getName());
            st.setString(2, student.getEmail());
            st.setString(3, student.getCourse());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
