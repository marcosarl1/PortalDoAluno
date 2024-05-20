package com.portalaluno.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
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
    
    public static void closeConnection(){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void closePreparedStatement(PreparedStatement ps){
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
