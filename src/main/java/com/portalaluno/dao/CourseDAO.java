package com.portalaluno.dao;

import com.portalaluno.model.Course;
import com.portalaluno.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    private static final String SELECT_ALL_COURSES_SQL
            = "SELECT * FROM course";

    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(SELECT_ALL_COURSES_SQL); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("course_id"));
                course.setName(rs.getString("course_name"));
                courses.add(course);
            }
        }
        return courses;
    }
}
