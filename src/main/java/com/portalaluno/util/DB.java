package com.portalaluno.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

    public static Connection getConnection() {
        Connection conn = null;
        if (conn == null) {
            try {
                String user = System.getenv("DB_USER");
                String password = System.getenv("DB_PASSWORD");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portaldoaluno", user, password);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }
    
}
